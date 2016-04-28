package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

// yellow
public class Backward extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		logger.info("Backward");
		pilot.travel(-10);
	}

	@Override
	public String toString() {
		return "Backward []";
	}

}
