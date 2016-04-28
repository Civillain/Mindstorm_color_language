package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

// blue: left 45 degrees
public class MockLeft extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		System.out.println("Left");
		Thread.sleep(100);
	}
	
	@Override
	public String toString() {
		return "Left []";
	}

}
