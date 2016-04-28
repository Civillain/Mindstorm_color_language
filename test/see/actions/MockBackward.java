package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

// yellow
public class MockBackward extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		System.out.println("Backward");
		Thread.sleep(100);
	}

	@Override
	public String toString() {
		return "Backward []";
	}

}
