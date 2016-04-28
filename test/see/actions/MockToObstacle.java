package see.actions;

import lejos.robotics.navigation.DifferentialPilot;
import see.comm.ChannelObstacleDetected;

public class MockToObstacle extends AbstractAction {

	private ChannelObstacleDetected obstacleDetected;
	
	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		System.out.println("ToObstacle");
		Thread.sleep(500);
	}
	
	@Override
	public String toString() {
		return "ToObstacle []";
	}

}
