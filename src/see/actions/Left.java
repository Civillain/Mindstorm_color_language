package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

// blue: left 45 degrees
public class Left extends AbstractAction {

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
