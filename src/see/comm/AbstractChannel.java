package see.comm;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public abstract class AbstractChannel<T> implements Channel<T> {

	protected TransferQueue<T> channel;
	
	public AbstractChannel() {
		channel = new LinkedTransferQueue<>();
	}
}
