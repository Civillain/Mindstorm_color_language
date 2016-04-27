package see.sensors;

import java.util.Queue;

import see.events.TouchPress;
import see.events.TouchPressed;

public class MockTouchSensor extends TouchSensor {
	
	private Queue<TouchPress> queue;
	
	public MockTouchSensor(Queue<TouchPress> queue) {
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
