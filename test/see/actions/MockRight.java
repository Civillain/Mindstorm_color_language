package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

// red: right 45 degrees
public class MockRight extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		System.out.println("Right");
		Thread.sleep(100);
	}
	
	@Override
	public String toString() {
		return "Right []";
	}

}
