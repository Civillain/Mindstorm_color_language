package see.behaviours;

import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;
import see.actions.Action;
import see.comm.ChannelAction;
import see.comm.ChannelTouchPressed;
import see.events.TouchPress;
import see.events.TouchPressed;
import see.robot.Robot;

public class DoReplay implements Behavior {

	private ChannelTouchPressed channelTouchPressed;
	private ChannelAction channelActionDiffPilot;
	private ChannelAction channelActionMediumMotor;
	private boolean suppressed = false;
	private Robot robot;
	
	public DoReplay(Robot robot) {
		super();
		this.channelTouchPressed = (ChannelTouchPressed) robot.getTouchSensor().channel();
		this.channelActionDiffPilot = (ChannelAction) robot.getDifferentialRobotMotor().channel();
		this.channelActionMediumMotor = (ChannelAction) robot.getMediumMotor().channel();
		this.robot = robot;
	}
	
	@Override
	public boolean takeControl() {
		
		if(robot.getMode() != Mode.REPLAY) {
			boolean control = false;
			TouchPressed detected = channelTouchPressed.read(); 
			if(detected.occurred()) {
				if(detected.getEvent() == TouchPress.PRESSED) {
					control = true;
					robot.setMode(Mode.REPLAY);
					Delay.msDelay(2000);
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
				channelActionDiffPilot.write(action);
				channelActionMediumMotor.write(action);
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
