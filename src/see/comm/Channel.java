package see.comm;

public interface Channel<T> {

	public T read() throws Exception;
	
	public void write(T t) throws Exception;
}
