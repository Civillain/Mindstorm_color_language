package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class Backward extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8049177771841381678L;

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		System.out.println("Backward");
		pilot.travel(-5);
	}

	@Override
	public String toString() {
		return "Backward []";
	}

}
