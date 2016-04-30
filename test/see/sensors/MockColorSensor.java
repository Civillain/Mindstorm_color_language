package see.sensors;

import java.util.Queue;

import see.events.ColorDetected;
import see.robot.Robot;

public class MockColorSensor extends ColorIDColorSensor {
	
	private Queue<Integer> queue;
	
	public MockColorSensor(Robot robot, Queue<Integer> queue) {
		super(robot);
		this.queue = queue;
	}
	
	@Override
	public ColorDetected read() {
		ColorDetected event = null;
		if(queue.isEmpty()) {
			event = new ColorDetected();
		} else {
			event = new ColorDetected(queue.remove()); 		
		}
		return event;
	}
}
