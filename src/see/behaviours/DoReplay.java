package see.behaviours;

import java.util.logging.Level;
import java.util.logging.Logger;

import lejos.robotics.subsumption.Behavior;
import see.actions.Action;
import see.comm.ChannelAction;
import see.comm.ChannelTouchPressed;
import see.events.TouchPress;
import see.events.TouchPressed;
import see.playback.Recorder;
import see.robot.Robot;

public class DoReplay implements Behavior {

	private ChannelTouchPressed channelTouchPressed;
	private Recorder recorder;
	private ChannelAction channelAction;
	private boolean suppressed = false;
	private Logger logger = Logger.getLogger("see");
	private Robot robot;
	
	public DoReplay(Robot robot) {
		super();
		this.channelTouchPressed = (ChannelTouchPressed) robot.getTouchSensor().channel();
		this.recorder = robot.getRecorder();
		this.channelAction = (ChannelAction) robot.getDifferentialRobotMotor().channel();
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
					logger.info("Switching to replay mode");
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
		logger.info("Replaying");
		while(robot.getRecorder().hasNext()) {
			Action action = robot.getRecorder().next();
			if(suppressed) {
				break;
			}
			try {
				channelAction.write(action);
			} catch (InterruptedException e) {
				logger.log(Level.SEVERE, "Error while replaying: " + action.toString(), e.getCause());
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
