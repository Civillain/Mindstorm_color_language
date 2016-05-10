package see.actions;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import see.comm.ChannelObstacleDetected;
import see.events.ObstacleDetected;

public class ToObstacle extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6822166686882775398L;
	private ChannelObstacleDetected obstacleDetected;
	
	@Override
	public void perform(DifferentialPilot pilot, EV3MediumRegulatedMotor mediumMotor) throws Exception {
		pilot.travel(-30, true);
		while( pilot.isMoving() ) {
			ObstacleDetected detected = obstacleDetected.read();
			if(detected.occurred()) {
				System.out.println("Obstacle detected");
				pilot.stop();
			}
		}
	}
	
	public void setObstacleDetected(ChannelObstacleDetected obstacleDetected) {
		this.obstacleDetected = obstacleDetected;
	}

	@Override
	public String toString() {
		return "ToObstacle";
	}

}
