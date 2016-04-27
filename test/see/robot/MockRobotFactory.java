package see.robot;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

import see.actions.MockActionMap;
import see.events.TouchPress;
import see.motors.DifferentialRobotMotor;
import see.playback.Recorder;
import see.sensors.MockColorSensor;
import see.sensors.MockDistanceSensor;
import see.sensors.MockTouchSensor;
import see.sensors.SensorMap;

public class MockRobotFactory {
	
	public final Queue<Integer> colorQ;
	public final Queue<Float> distQ;
	public final Queue<TouchPress> touchQ;
	
	public MockRobotFactory() {
		colorQ = new LinkedList<>();
		distQ = new LinkedList<>();
		touchQ = new LinkedList<>();
	}
	
	public Robot create() throws InterruptedException {
		
		Robot robot = new Robot();
		Recorder recorder = new Recorder();
		MockActionMap actionMap = new MockActionMap();
		SensorMap sensorMap = new SensorMap();
		
		MockColorSensor colorSensor = new MockColorSensor(colorQ);
		MockTouchSensor touchSensor = new MockTouchSensor(touchQ);
		MockDistanceSensor distanceSensor = new MockDistanceSensor(distQ);
		DifferentialRobotMotor differentialRobotMotor = new DifferentialRobotMotor();
		
		robot.setDifferentialRobotMotor(differentialRobotMotor);
		robot.setColorSensor(colorSensor);
		robot.setDistanceSensor(distanceSensor);
		robot.setRecorder(recorder);
		robot.setTouchSensor(touchSensor);
		robot.setActionMap(actionMap);
		robot.setSensorMap(sensorMap);
		robot.setLogger(createLogger());
		return robot;
	}
	
	private Logger createLogger() {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %4$-6s %2$s %5$s%6$s%n");
		Logger logger = Logger.getLogger("see");
		logger.setUseParentHandlers(false);
		logger.setLevel(Level.INFO);
		SimpleFormatter fmt = new SimpleFormatter();
		StreamHandler sh = new StreamHandler(System.out, fmt);
		logger.addHandler(sh);
		return logger;
	}
}
