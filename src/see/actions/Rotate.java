package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

// white: rotate & bleep
public class Rotate extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		System.out.println("Rotate");
		pilot.rotate(180);
	}
	
	@Override
	public String toString() {
		return "Rotate []";
	}

}
