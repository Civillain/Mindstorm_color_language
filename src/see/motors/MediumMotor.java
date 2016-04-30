package see.motors;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.Port;
import see.actions.Action;
import see.comm.Channel;
import see.comm.ChannelAction;
import see.robot.Robot;

public class MediumMotor implements Motor<Action> {

	private ChannelAction channelAction;
	private EV3MediumRegulatedMotor mediumMotor;
	
	public MediumMotor() {
		this.channelAction = new ChannelAction(); 
	}
	
	@Override
	public Channel<Action> channel() {
		return channelAction;
	}

	@Override
	public void run() {
		System.out.println("Starting motor: " + this.toString());
		while(true) {
			Action action = channelAction.read();
			try {
				action.perform(null, mediumMotor);
			} catch (Exception e) {
				System.err.println("Error while performing: " + action.toString() + " " +  e.getCause());
			}
		}
	}

	@Override
	public void connect(Robot robot) {
		System.out.println("Connecting medium motor");
		String portName = robot.getProperty("motor.medium.port");
		Port port = LocalEV3.get().getPort(portName);
		mediumMotor = new EV3MediumRegulatedMotor(port);
	}

	@Override
	public void stop() {
		mediumMotor.stop();
	}
	
	@Override
	public String toString() {
		return "MediumMotor";
	}

}
