package see.actions;

import lejos.hardware.Sound;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class Repeat extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8853645499075066175L;

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		Sound.beep();
	}
	
	@Override
	public String toString() {
		return "Repeat";
	}

}
