package see.sensors;

import lejos.hardware.sensor.HiTechnicColorSensor;
import see.comm.Channel;
import see.comm.ChannelColorDetected;
import see.events.ColorDetected;
import see.robot.Robot;

public abstract class ColorSensor extends Sensor<ColorDetected> {
	protected ChannelColorDetected channelColorDetected;
	protected HiTechnicColorSensor colorSensor;
	
	public ColorSensor(Robot robot) {
		super(robot);
		this.channelColorDetected = new ChannelColorDetected();
	}
	
	@Override
	public Channel<ColorDetected> channel() {
		return channelColorDetected;
	}
}
