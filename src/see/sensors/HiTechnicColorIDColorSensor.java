package see.sensors;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.HiTechnicColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;
import lejos.utility.Delay;
import see.events.ColorDetected;
import see.robot.Robot;

public class HiTechnicColorIDColorSensor extends ColorSensor {

	public HiTechnicColorIDColorSensor(Robot robot) {
		super(robot);
	}

	@Override
	public void connect(Robot robot) {
		System.out.println("Connecting color sensor");
		SensorMap sensorMap = robot.getSensorMap();
		Port port = sensorMap.getPort(SensorType.COLOR);
		HiTechnicColorSensor colorSensor = new HiTechnicColorSensor(port);
		SensorMode sensorMode = colorSensor.getColorIDMode();
		colorSensor.setCurrentMode(sensorMode.getName());
		this.colorSensor = colorSensor;
	}
	
	@Override
	public ColorDetected read() throws InterruptedException {
		int colorId = colorSensor.getColorID();
		Delay.msDelay(500);
		ColorDetected detected = null;
		if(colorId == Color.NONE) {
			detected = new ColorDetected();
		} else {
			detected = new ColorDetected(colorId);
			//System.out.println("Color: " + colorId);
		}
		return detected;
	}
	
	@Override
	public String toString() {
		return "ColorIDColorSensor";
	}
	
}
