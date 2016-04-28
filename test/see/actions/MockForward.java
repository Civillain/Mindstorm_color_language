package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

// green
public class MockForward extends AbstractAction {

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		System.out.println("Forward");
		Thread.sleep(100);
	}
	
	@Override
	public String toString() {
		return "Forward []";
	}

}
