package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class Rotate extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1960052100521226614L;

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		System.out.println("Rotate");
		pilot.rotate(180);
	}
	
	@Override
	public String toString() {
		return "Rotate []";
	}

}
