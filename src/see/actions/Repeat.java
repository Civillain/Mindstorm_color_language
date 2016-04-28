package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

public class Repeat extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		System.out.println("Repeat");
		
	}
	
	@Override
	public String toString() {
		return "Repeat []";
	}

}
