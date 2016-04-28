package see.actions.witherrors;

import lejos.robotics.navigation.DifferentialPilot;
import see.actions.AbstractAction;

// green
public class MockForwardWithError extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		System.out.println("Forward");
		throw new Exception("Error while moving forward");
	}
	
	@Override
	public String toString() {
		return "Forward []";
	}

}
