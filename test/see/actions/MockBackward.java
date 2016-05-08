package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

// yellow
public class MockBackward extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		System.out.println("Backward");
		Thread.sleep(100);
	}

	@Override
	public String toString() {
		return "Backward";
	}

}
