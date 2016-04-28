package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

// red: right 45 degrees
public class Right extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		logger.info("Right");
		pilot.rotateRight();
	}
	
	@Override
	public String toString() {
		return "Right []";
	}

}
