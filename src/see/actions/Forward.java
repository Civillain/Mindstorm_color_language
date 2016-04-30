package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class Forward extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7609988720501010802L;

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		System.out.println("Forward");
		pilot.travel(5);
	}
	
	@Override
	public String toString() {
		return "Forward []";
	}

}
