package see.robot;

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
		return robot;
	}
	
}
