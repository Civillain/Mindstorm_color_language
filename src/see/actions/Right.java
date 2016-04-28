package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

// red: right 45 degrees
public class Right extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		System.out.println("Right");
		pilot.rotate(90);
	}
	
	@Override
	public String toString() {
		return "Right []";
	}

}
