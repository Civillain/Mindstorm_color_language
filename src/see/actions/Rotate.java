package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

// white: rotate & bleep
public class Rotate extends AbstractAction {

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
