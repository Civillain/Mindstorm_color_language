package see.robot;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

import see.actions.ActionMap;
import see.actions.ActionMapImpl;
import see.motors.DifferentialRobotMotor;
import see.playback.Recorder;
import see.sensors.ColorSensor;
import see.sensors.DistanceSensor;
import see.sensors.SensorMap;
import see.sensors.TouchSensor;

public class RobotFactory {
	
	public Robot create() {
		Robot robot = Robot.create();
		Recorder recorder = new Recorder();
		ActionMap actionMap = new ActionMapImpl();
		ColorSensor colorSensor = new ColorSensor(robot);
		TouchSensor touchSensor = new TouchSensor(robot);
		DistanceSensor distanceSensor = new DistanceSensor(robot);
		SensorMap sensorMap = new SensorMap();
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
