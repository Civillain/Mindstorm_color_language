package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public interface Action {

	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception;
}
