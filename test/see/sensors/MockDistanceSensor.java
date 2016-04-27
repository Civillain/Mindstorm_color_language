package see.sensors;

import java.util.Queue;

import see.events.ObstacleDetected;

public class MockDistanceSensor extends DistanceSensor {

	private Queue<Float> queue;
	
	public MockDistanceSensor(Queue<Float> queue) {
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
