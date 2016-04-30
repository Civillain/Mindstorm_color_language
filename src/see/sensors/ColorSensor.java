package see.sensors;

import lejos.hardware.sensor.EV3ColorSensor;
import see.comm.Channel;
import see.comm.ChannelColorDetected;
import see.events.ColorDetected;
import see.robot.Robot;

public abstract class ColorSensor extends Sensor<ColorDetected> {
	protected ChannelColorDetected channelColorDetected;
	protected EV3ColorSensor colorSensor;
	
	public ColorSensor(Robot robot) {
		super(robot);
		this.channelColorDetected = new ChannelColorDetected();
	}
	
	@Override
	public Channel<ColorDetected> channel() {
		return channelColorDetected;
	}
}
