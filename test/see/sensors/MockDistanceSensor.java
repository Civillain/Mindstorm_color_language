package see.sensors;

import java.util.Queue;

import see.events.ObstacleDetected;
import see.robot.Robot;

public class MockDistanceSensor extends DistanceSensor {

	private Queue<Float> queue;
	
	public MockDistanceSensor(Robot robot, Queue<Float> queue) {
		super(robot);
		this.queue = queue;
	}
	
	@Override
	public ObstacleDetected read() {
		ObstacleDetected event = null;
		if(queue.isEmpty()) {
			event = new ObstacleDetected();
		} else {
			event = new ObstacleDetected(queue.remove()); 		
		}
		return event;
	}
}
