package see.sensors;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;
import lejos.utility.Delay;
import see.events.ColorDetected;
import see.robot.Robot;

public class ColorIDColorSensor extends ColorSensor {

	private int filterSize = 100;
	
	public ColorIDColorSensor(Robot robot) {
		super(robot);
	}

	@Override
	public void connect(Robot robot) {
		System.out.println("Connecting color sensor");
		SensorMap sensorMap = robot.getSensorMap();
		Port port = sensorMap.getPort(SensorType.COLOR);
		EV3ColorSensor colorSensor = new EV3ColorSensor(port);
		SensorMode sensorMode = colorSensor.getColorIDMode();
		colorSensor.setCurrentMode(sensorMode.getName());
		colorSensor.setFloodlight(Color.NONE);
		this.colorSensor = colorSensor;
	}
	
	@Override
	public ColorDetected read() throws InterruptedException {
		int colorId = 0;
		for(int i = 0; i < filterSize; i++) {
			colorId += colorSensor.getColorID();
			Delay.msDelay(10);
		}
		
		int colorIdAvg = Math.round(colorId / filterSize);
		System.out.println("Color: " + colorIdAvg);
		ColorDetected detected = null;
		if(colorId == Color.NONE) {
			detected = new ColorDetected();
		} else {
			detected = new ColorDetected(colorIdAvg);
		}
		return detected;
	}
	
	@Override
	public String toString() {
		return "ColorIDColorSensor";
	}
	
}
