package see.sensors;

import java.util.HashMap;
import java.util.Map;

import see.robot.Connectable;
import see.robot.Robot;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.Port;

public class SensorMap implements Connectable {

	private Map<SensorType, Port> map;
	
	public SensorMap() {
		this.map = new HashMap<>();
	}

	public Port getPort(SensorType sensorType) {
		return map.get(sensorType);
	}

	@Override
	public void connect(Robot robot) {
		Port colorPort = LocalEV3.get().getPort(robot.getProperty("sensor.color.port"));
		Port touchPort = LocalEV3.get().getPort(robot.getProperty("sensor.touch.port"));
		Port infraRedPort = LocalEV3.get().getPort(robot.getProperty("sensor.ir.port"));

		map.put(SensorType.COLOR, colorPort);
		map.put(SensorType.TOUCH, touchPort);
		map.put(SensorType.INFRARED, infraRedPort);
	}

}
