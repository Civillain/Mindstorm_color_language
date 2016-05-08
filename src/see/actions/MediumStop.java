package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class MediumStop extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6822166686882775398L;
	
	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		mediumMotor.stop();
	}
	
	@Override
	public String toString() {
		return "MediumStop";
	}

}
