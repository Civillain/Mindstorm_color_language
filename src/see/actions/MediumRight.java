package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class MediumRight extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4425684148739082410L;

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		System.out.println("Medium Right");
		mediumMotor.rotate(45);
	}
	
	@Override
	public String toString() {
		return "MediumRight";
	}

}
