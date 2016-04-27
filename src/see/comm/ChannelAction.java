package see.comm;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

import see.actions.Action;
import see.actions.NoAction;

public class ChannelAction implements Channel<Action> {

	private TransferQueue<Action> channel;
	
	public ChannelAction() {
		channel = new LinkedTransferQueue<>();
	}
	
	@Override
	public Action read() {
		Action cd = channel.poll();
		if(cd == null) {
			cd = new NoAction();
		}
		return cd;
	}

	@Override
	public void write(Action t) throws InterruptedException {
		channel.transfer(t);
	}

}
