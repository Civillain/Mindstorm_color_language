package see.behaviours;

import lejos.robotics.subsumption.Behavior;
import see.actions.Action;
import see.comm.ChannelAction;
import see.comm.ChannelTouchPressed;
import see.events.TouchPress;
import see.events.TouchPressed;
import see.robot.Robot;

public class DoReplay implements Behavior {

	private ChannelTouchPressed channelTouchPressed;
	private ChannelAction channelAction;
	private boolean suppressed = false;
	private Robot robot;
	
	public DoReplay(Robot robot) {
		super();
		this.channelTouchPressed = (ChannelTouchPressed) robot.getTouchSensor().channel();
		this.channelAction = (ChannelAction) robot.getDifferentialRobotMotor().channel();
		this.robot = robot;
	}
	
	@Override
	public boolean takeControl() {
		
		suppressed = robot.checkIfStopped();
		
		if(robot.getMode() != Mode.REPLAY) {
			boolean control = false;
			TouchPressed detected = channelTouchPressed.read(); 
			if(detected.occurred()) {
				if(detected.getEvent() == TouchPress.PRESSED) {
					control = true;
					robot.setMode(Mode.REPLAY);
				}
			}
			return control;
		} else {
			return true;
		}
	}

	@Override
	public void action() {
		while(robot.getRecorder().hasNext()) {
			Action action = robot.getRecorder().next();
			if(suppressed) {
				break;
			}
			try {
				channelAction.write(action);
			} catch (InterruptedException e) {
				System.err.println("Error while replaying: " + action.toString() + " "+ e.getCause());
				break;
			}
		}
		robot.setMode(Mode.IDLE);
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
}
