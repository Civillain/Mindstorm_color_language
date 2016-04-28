package see.comm;

import see.events.TouchPressed;

public class ChannelTouchPressed extends AbstractChannel<TouchPressed> {

	public ChannelTouchPressed() {
		super();
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
