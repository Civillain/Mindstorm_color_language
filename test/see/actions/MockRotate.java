package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

// white: rotate & bleep
public class MockRotate extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		logger.info("Rotate");
		Thread.sleep(100);
	}
	
	@Override
	public String toString() {
		return "Rotate []";
	}

}
