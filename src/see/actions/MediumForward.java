package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class MediumForward extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4016068927118776965L;

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		mediumMotor.rotate(360, true);
	}
	
	@Override
	public String toString() {
		return "MediumForward";
	}

}
