package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

// green
public class Forward extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		System.out.println("Forward");
		pilot.travel(5);
	}
	
	@Override
	public String toString() {
		return "Forward []";
	}

}
