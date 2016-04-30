package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class Left extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7274174170471829819L;

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		System.out.println("Left");
		pilot.rotate(-90);
	}
	
	@Override
	public String toString() {
		return "Left []";
	}

}
