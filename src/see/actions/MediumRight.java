package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

// brown: turn head right
public class MediumRight extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		System.out.println("Medium Right");
		mediumMotor.rotate(45);
	}
	
	@Override
	public String toString() {
		return "MediumRight []";
	}

}
