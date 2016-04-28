package see.motors;

import see.comm.Process;
import see.robot.Connectable;

public interface Motor<T> extends Process<T>, Connectable {
	public void stop();
 }
