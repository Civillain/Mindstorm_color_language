package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

// blue: left 45 degrees
public class MockLeft extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		System.out.println("Left");
		Thread.sleep(100);
	}
	
	@Override
	public String toString() {
		return "Left";
	}

}
