package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

// yellow
public class MockBackward extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		logger.info("Backward");
		
	}

	@Override
	public String toString() {
		return "Backward []";
	}

}
