package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class NoAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 874747807537705331L;

	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		// idling
	}
	
	@Override
	public String toString() {
		return "NoAction";
	}

}
