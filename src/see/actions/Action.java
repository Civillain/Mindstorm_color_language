package see.actions;

import lejos.robotics.navigation.DifferentialPilot;

public interface Action {

	public void perform(DifferentialPilot pilot) throws Exception;
}
