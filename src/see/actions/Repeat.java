package see.actions;

import lejos.hardware.Sound;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class Repeat extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		System.out.println("Repeat");
		Sound.beep();
	}
	
	@Override
	public String toString() {
		return "Repeat []";
	}

}
