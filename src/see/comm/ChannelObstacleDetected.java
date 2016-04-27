package see.comm;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

import see.events.ObstacleDetected;

public class ChannelObstacleDetected implements Channel<ObstacleDetected> {

	private TransferQueue<ObstacleDetected> channel;
	
	public ChannelObstacleDetected() {
		channel = new LinkedTransferQueue<>();
	}
	
	@Override
	public ObstacleDetected read() {
		ObstacleDetected cd = channel.poll();
		if(cd == null) {
			cd = new ObstacleDetected();
		}
		return cd;
	}

	@Override
	public void write(ObstacleDetected t) throws InterruptedException {
		channel.transfer(t);
	}

}
