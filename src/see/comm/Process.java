package see.comm;


public interface Process<T> extends Runnable {

	public Channel<T> channel();
	
}
