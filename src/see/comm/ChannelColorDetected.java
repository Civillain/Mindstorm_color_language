package see.comm;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

import see.events.ColorDetected;

public class ChannelColorDetected implements Channel<ColorDetected> {

	private TransferQueue<ColorDetected> channel;
	
	public ChannelColorDetected() {
		channel = new LinkedTransferQueue<>();
	}
	
	@Override
	public ColorDetected read() {
		ColorDetected cd = channel.poll();
		if(cd == null) {
			cd = new ColorDetected();
		}
		return cd;
	}

	@Override
	public void write(ColorDetected t) throws InterruptedException {
		channel.transfer(t);
	}

}
