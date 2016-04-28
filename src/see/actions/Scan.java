package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

// brown: turn head & bleep
public class Scan extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		System.out.println("Scan");
		
	}
	
	@Override
	public String toString() {
		return "Scan []";
	}

}
