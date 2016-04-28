package see.sensors;

import java.util.Queue;

import see.events.TouchPress;
import see.events.TouchPressed;
import see.robot.Robot;

public class MockTouchSensor extends TouchSensor {
	
	private Queue<TouchPress> queue;
	
	public MockTouchSensor(Robot robot, Queue<TouchPress> queue) {
		super(robot);
		this.queue = queue;
	}
	
	@Override
	public TouchPressed read() {
		TouchPressed event = null;
		if(queue.isEmpty()) {
			event = new TouchPressed();
		} else {
			event = new TouchPressed(queue.remove()); 		
		}
		return event;
	}
}
