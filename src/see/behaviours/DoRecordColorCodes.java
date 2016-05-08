package see.behaviours;

import lejos.robotics.subsumption.Behavior;
import see.actions.Action;
import see.actions.ActionMap;
import see.comm.ChannelAction;
import see.comm.ChannelColorDetected;
import see.events.ColorDetected;
import see.playback.Recorder;
import see.robot.Robot;

public class DoRecordColorCodes implements Behavior {

	private ChannelColorDetected channelColorDetected;
	private ChannelAction channelActionDiffPilot;
	private ChannelAction channelActionMediumMotor;
	private ActionMap actionMap;
	private Recorder recorder;
	private boolean suppressed = false;
	private Robot robot;
	
	public DoRecordColorCodes(Robot robot) {
		super();
		this.channelColorDetected = (ChannelColorDetected) robot.getColorSensor().channel();
		this.channelActionDiffPilot = (ChannelAction) robot.getDifferentialRobotMotor().channel();
		this.channelActionMediumMotor = (ChannelAction) robot.getMediumMotor().channel();
		this.actionMap = robot.getActionMap();
		this.recorder = robot.getRecorder();
		this.robot = robot;
	}

	@Override
	public boolean takeControl() {
		
		if(robot.getMode() == Mode.IDLE) {
			robot.setMode(Mode.RECORD);
		}
		return true;
	}

	@Override
	public void action() {
		while(!suppressed) {
			ColorDetected detected = channelColorDetected.read();
			if(detected.occurred()) {
				Action action = actionMap.get(detected.getEvent());
				recorder.add(action);
				try {
					channelActionDiffPilot.write(action);
					channelActionMediumMotor.write(action);
				} catch (InterruptedException e) {
					System.err.println("Error while writing: " + action.toString() + " " + e.getCause());
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
