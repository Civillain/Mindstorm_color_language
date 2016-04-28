package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

// brown: turn head & bleep
public class MockScan extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		logger.info("Scan");
		Thread.sleep(100);
	}
	
	@Override
	public String toString() {
		return "Scan []";
	}

}
