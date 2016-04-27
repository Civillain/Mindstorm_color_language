package see.behaviours;

import java.util.logging.Level;
import java.util.logging.Logger;

import lejos.robotics.subsumption.Behavior;
import see.actions.Action;
import see.actions.MockActionMap;
import see.comm.ChannelAction;
import see.comm.ChannelColorDetected;
import see.events.ColorDetected;
import see.playback.Recorder;
import see.robot.Robot;

public class DoRecord implements Behavior {

	private ChannelColorDetected channelColorDetected;
	private ChannelAction channelAction;
	private MockActionMap actionMap;
	private Recorder recorder;
	private boolean suppressed = false;
	private Robot robot;
	private Logger logger = Logger.getLogger("see");
	
	public DoRecord(Robot robot) {
		super();
		this.channelColorDetected = (ChannelColorDetected) robot.getColorSensor().channel();
		this.channelAction = (ChannelAction) robot.getDifferentialRobotMotor().channel();
		this.actionMap = robot.getActionMap();
		this.recorder = robot.getRecorder();
		this.robot = robot;
	}

	@Override
	public boolean takeControl() {
		if(robot.getMode() == Mode.IDLE) {
			robot.setMode(Mode.RECORD);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void action() {
		logger.info("Recording");
		while(!suppressed) {
			ColorDetected detected = channelColorDetected.read();
			if(detected.occurred()) {
				Action action = actionMap.get(detected.getEvent());
				recorder.add(action);
				try {
					channelAction.write(action);
				} catch (InterruptedException e) {
					logger.log(Level.SEVERE, "Error while writing: " + action.toString(), e.getCause());
					break;
				}
			}
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
