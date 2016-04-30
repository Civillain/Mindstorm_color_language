package see.sensors;

import see.behaviours.Mode;
import see.comm.Channel;
import see.comm.Process;
import see.events.Event;
import see.robot.Connectable;
import see.robot.Robot;

public abstract class Sensor<T extends Event<?>> implements Process<T>, Connectable {

	protected Robot robot;
	
	public Sensor(Robot robot) {
		this.robot = robot;
	}
	
	@Override
	public void run() {
		System.out.println("Starting sensor: " + this.toString());
		while(true) {
			
			if(robot.getMode() != Mode.RECORD) {
				continue;
			}
			
			Channel<T> channel = channel();
			try {
				T value = read();
				if(value.occurred()) {
					System.out.println("Reading: " + value.toString());
				}
				channel.write(value);
			} catch (Exception e) {
				System.err.println("Sensor read/write error: " + e.getCause());
				break;
			}
		}
		System.out.println("Stopping sensor: " + this.toString());
	}
	
	public abstract T read() throws InterruptedException;
}
