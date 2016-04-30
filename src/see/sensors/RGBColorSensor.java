package see.sensors;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;
import see.events.ColorDetected;
import see.robot.Robot;

public class RGBColorSensor extends ColorSensor {

	private float [] sample;
	
	public RGBColorSensor(Robot robot) {
		super(robot);
	}
	
	@Override
	public void connect(Robot robot) {
		System.out.println("Connecting color sensor");
		SensorMap sensorMap = robot.getSensorMap();
		Port port = sensorMap.getPort(SensorType.COLOR);
		EV3ColorSensor colorSensor = new EV3ColorSensor(port);
		SensorMode sensorMode = colorSensor.getRGBMode();
		colorSensor.setCurrentMode(sensorMode.getName());
		this.colorSensor = colorSensor;
		this.sample = new float[colorSensor.sampleSize()];
	}
	
	@Override
	public ColorDetected read() throws InterruptedException {
		SampleProvider sp = (SampleProvider)colorSensor;
		sp.fetchSample(sample, 0);
		
		System.out.print("R:" + sample[0] + ", ");
		System.out.print("G:" + sample[1]+ ", ");
		System.out.println("B:" + sample[2]);
		
		ColorDetected detected = null;
		Integer colorId = -1;
		if(colorId == Color.NONE) {
			detected = new ColorDetected();
		} else {
			detected = new ColorDetected(colorId);
		}
		return detected;
	}
	
	@Override
	public String toString() {
		return "RGBColorSensor";
	}

}
