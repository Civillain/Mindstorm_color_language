package see.sensors;

import java.util.logging.Level;
import java.util.logging.Logger;

import see.comm.Channel;
import see.comm.Process;
import see.events.Event;
import see.robot.Connectable;

public abstract class Sensor<T extends Event<?>> implements Process<T>, Connectable {

	protected Logger logger = Logger.getLogger("see");
	
	@Override
	public void run() {
		logger.info("Starting sensor: " + this.toString());
		while(true) {
			
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
