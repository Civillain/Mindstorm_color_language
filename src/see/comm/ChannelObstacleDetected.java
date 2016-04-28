package see.comm;

import see.events.ObstacleDetected;

public class ChannelObstacleDetected extends AbstractChannel<ObstacleDetected> {

	public ChannelObstacleDetected() {
		super();
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
