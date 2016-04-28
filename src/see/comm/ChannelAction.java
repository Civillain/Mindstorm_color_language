package see.comm;

import see.actions.Action;
import see.actions.NoAction;

public class ChannelAction extends AbstractChannel<Action> {
	
	public ChannelAction() {
		super();
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
