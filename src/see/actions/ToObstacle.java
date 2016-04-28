package see.actions;

import lejos.robotics.navigation.DifferentialPilot;
import see.comm.ChannelObstacleDetected;

public class ToObstacle extends AbstractAction {

	private ChannelObstacleDetected obstacleDetected;
	
	@Override
	public void perform(DifferentialPilot pilot) throws Exception {
		System.out.println("ToObstacle");
		
	}
	
	@Override
	public String toString() {
		return "ToObstacle []";
	}

}
