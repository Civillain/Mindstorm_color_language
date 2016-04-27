package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

public class Repeat extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		logger.info("Repeat");
		
	}
	
	@Override
	public String toString() {
		return "Repeat []";
	}

}
