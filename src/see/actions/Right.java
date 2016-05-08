package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class Right extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -884016318391380598L;

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		pilot.rotate(90);
	}
	
	@Override
	public String toString() {
		return "Right";
	}

}
