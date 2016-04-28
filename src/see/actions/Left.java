package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

// blue: left 45 degrees
public class Left extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		System.out.println("Left");
		pilot.rotate(-90);
	}
	
	@Override
	public String toString() {
		return "Left []";
	}

}
