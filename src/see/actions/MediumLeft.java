package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

// brown: turn head left
public class MediumLeft extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		System.out.println("Medium Left");
		mediumMotor.rotate(-45);
	}
	
	@Override
	public String toString() {
		return "MediumLeft []";
	}

}
