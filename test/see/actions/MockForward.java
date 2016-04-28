package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

// green
public class MockForward extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		logger.info("Forward");
		Thread.sleep(100);
	}
	
	@Override
	public String toString() {
		return "Forward []";
	}

}
