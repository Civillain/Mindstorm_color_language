package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

// green
public class Forward extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		logger.info("Forward");
		pilot.travel(10);
	}
	
	@Override
	public String toString() {
		return "Forward []";
	}

}
