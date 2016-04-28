package see.sensors;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;
import see.comm.Channel;
import see.comm.ChannelTouchPressed;
import see.events.TouchPress;
import see.events.TouchPressed;
import see.robot.Robot;


public class TouchSensor extends Sensor<TouchPressed>  {

	private ChannelTouchPressed channelTouchPressed;
	private EV3TouchSensor touchSensor;
	private float[] sample;
	
	public TouchSensor(Robot robot) {
		super(robot);
		this.channelTouchPressed = new ChannelTouchPressed();
	}
	
	@Override
	public void connect(Robot robot) {
		System.out.println("Connecting touch sensor");
		SensorMap sensorMap = robot.getSensorMap();
		Port port = sensorMap.getPort(SensorType.TOUCH);
		EV3TouchSensor touchSensor = new EV3TouchSensor(port);
		SensorMode sensorMode = touchSensor.getTouchMode();
		touchSensor.setCurrentMode(sensorMode.getName());
		this.touchSensor = touchSensor;
		int sampleSize = touchSensor.sampleSize();
		this.sample = new float[sampleSize];
	}
	
	@Override
	public Channel<TouchPressed> channel() {
		return channelTouchPressed;
	}

	@Override
	public TouchPressed read() {
		touchSensor.fetchSample(sample, 0);
		TouchPressed tp = null;
		if(sample[0] == 1.0f) {
			tp =  new TouchPressed(TouchPress.PRESSED);
		} else {
			tp = new TouchPressed();
		}
		return tp;
	}
	
	@Override
	public String toString() {
		return "TouchSensor";
	}

}
