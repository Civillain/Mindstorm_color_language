package see.comm;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

import see.events.TouchPressed;

public class ChannelTouchPressed implements Channel<TouchPressed> {

private TransferQueue<TouchPressed> channel;
	
	public ChannelTouchPressed() {
		channel = new LinkedTransferQueue<>();
	}
	
	@Override
	public TouchPressed read() {
		TouchPressed cd = channel.poll();
		if(cd == null) {
			cd = new TouchPressed();
		}
		return cd;
	}

	@Override
	public void write(TouchPressed t) throws InterruptedException {
		channel.transfer(t);
	}
}
