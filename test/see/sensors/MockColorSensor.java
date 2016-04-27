package see.sensors;

import java.util.Queue;

import see.events.ColorDetected;

public class MockColorSensor extends ColorSensor {
	
	private Queue<Integer> queue;
	
	public MockColorSensor(Queue<Integer> queue) {
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
