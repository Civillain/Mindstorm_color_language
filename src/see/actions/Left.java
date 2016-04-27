package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

// blue: left 45 degrees
public class Left extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		logger.info("Left");
		
	}
	
	@Override
	public String toString() {
		return "Left []";
	}

}
