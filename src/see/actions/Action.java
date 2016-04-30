package see.actions;

import java.io.Serializable;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public interface Action extends Serializable {

	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception;
}
