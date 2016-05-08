package see.sensors;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.SampleProvider;
import see.comm.Channel;
import see.comm.ChannelObstacleDetected;
import see.events.ObstacleDetected;
import see.robot.Robot;

public class DistanceSensor extends Sensor<ObstacleDetected>  {

	private ChannelObstacleDetected channelObstacleDetcted;
	private SampleProvider irSensor;
	private float[] sample;
	private float distanceToDetectObstacle = 50.0f; // 1.0f equals roughly 1 meter
	
	public DistanceSensor(Robot robot) {
		super(robot);
		this.channelObstacleDetcted = new ChannelObstacleDetected();
	}
	
	@Override
	public void connect(Robot robot) {
		System.out.println("Connecting IR sensor");
		SensorMap sensorMap = robot.getSensorMap();
		Port port = sensorMap.getPort(SensorType.INFRARED);
		EV3IRSensor irSensor = new EV3IRSensor(port);
		SensorMode sensorMode = irSensor.getDistanceMode();
		irSensor.setCurrentMode(sensorMode.getName());
		this.irSensor = irSensor;
		int sampleSize = irSensor.sampleSize();
		this.sample = new float[sampleSize];
	}
	
	@Override
	public Channel<ObstacleDetected> channel() {
		return channelObstacleDetcted;
	}

	@Override
	public ObstacleDetected read() {
		irSensor.fetchSample(sample, 0);
		float obstacleDistance = sample[0];
		ObstacleDetected detected = null;
		if(obstacleDistance <= distanceToDetectObstacle) {
			detected = new ObstacleDetected(Float.valueOf(obstacleDistance));
		} else {
			detected = new ObstacleDetected();
		}
		return detected;
	}
	
	@Override
	public String toString() {
		return "DistanceSensor";
	}
}
