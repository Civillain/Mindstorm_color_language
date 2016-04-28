package see.sensors;

import java.util.logging.Level;
import java.util.logging.Logger;

import see.behaviours.Mode;
import see.comm.Channel;
import see.comm.Process;
import see.events.Event;
import see.robot.Connectable;
import see.robot.Robot;

public abstract class Sensor<T extends Event<?>> implements Process<T>, Connectable {

	protected Robot robot;
	
	protected Logger logger = Logger.getLogger("see");
	
	public Sensor(Robot robot) {
		this.robot = robot;
	}
	
	@Override
	public void run() {
		logger.info("Starting sensor: " + this.toString());
		while(true) {
			
			if(robot.getMode() != Mode.RECORD) {
				continue;
			}
			
			Channel<T> channel = channel();
			try {
				T value = read();
				if(value.occurred()) {
					logger.info("Reading: " + value.toString());
				}
				channel.write(value);
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Sensor read/write error", e.getCause());
				break;
			}
		}
		logger.info("Stopping sensor: " + this.toString());
	}
	
	public abstract T read() throws InterruptedException;
}
