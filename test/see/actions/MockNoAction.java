package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

public class MockNoAction extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		//logger.finest("NoAction");

	}
	
	@Override
	public String toString() {
		return "NoAction []";
	}

}
