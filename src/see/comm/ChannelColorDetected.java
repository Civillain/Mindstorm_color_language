package see.comm;

import see.events.ColorDetected;

public class ChannelColorDetected extends AbstractChannel<ColorDetected> {

	public ChannelColorDetected() {
		super();
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
