package see.events;

public interface Event<T> {
	
	public Boolean occurred();
	
	public T getEvent();
}
