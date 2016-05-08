package see.behaviours;

import lejos.hardware.Button;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;
import see.actions.Action;
import see.actions.ActionMap;
import see.playback.Recorder;
import see.robot.Robot;

public class DoRecordButtons implements Behavior {

	private ActionMap actionMap;
	private Recorder recorder;
	private boolean suppressed = false;
	private Robot robot;
	
	public DoRecordButtons(Robot robot) {
		super();
		this.actionMap = robot.getActionMap();
		this.recorder = robot.getRecorder();
		this.robot = robot;
	}

	@Override
	public boolean takeControl() {
		
		suppressed = robot.checkIfStopped();
		
		if(robot.getMode() == Mode.IDLE) {
			robot.setMode(Mode.RECORD);
		}
		return true;
	}

	@Override
	public void action() {
		int btnPressed = 0;
		while(!suppressed) {
			while( (btnPressed = Button.readButtons()) != 0) {
				Action action = actionMap.get(btnPressed);
				recorder.add(action);
				Delay.msDelay(250);
			}
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
