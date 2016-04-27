package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

public class NoAction extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		// idling
	}
	
	@Override
	public String toString() {
		return "NoAction []";
	}

}
