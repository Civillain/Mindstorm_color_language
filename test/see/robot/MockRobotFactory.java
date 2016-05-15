package see.robot;

import java.util.LinkedList;
import java.util.Queue;

import see.actions.MockActionMap;
import see.actions.witherrors.MockActionMapWithError;
import see.events.TouchPress;
import see.motors.DifferentialRobotMotor;
import see.motors.MediumMotor;
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
		
		Robot robot = Robot.create();
		Recorder recorder = new Recorder();
		MockActionMap actionMap = new MockActionMap();
		SensorMap sensorMap = new SensorMap();
		
		MockColorSensor colorSensor = new MockColorSensor(robot, colorQ);
		MockTouchSensor touchSensor = new MockTouchSensor(robot, touchQ);
		MockDistanceSensor distanceSensor = new MockDistanceSensor(robot, distQ);
		DifferentialRobotMotor differentialRobotMotor = new DifferentialRobotMotor();
		MediumMotor mediumMotor = new MediumMotor();
		robot.setDifferentialRobotMotor(differentialRobotMotor);
		robot.setMediumMotor(mediumMotor);
		robot.setColorSensor(colorSensor);
		robot.setDistanceSensor(distanceSensor);
		robot.setRecorder(recorder);
		robot.setTouchSensor(touchSensor);
		robot.setActionMap(actionMap);
		robot.setSensorMap(sensorMap);
		return robot;
	}
	
	public Robot createWithErrorInForward() throws InterruptedException {
		Robot robot = create();
		MockActionMapWithError actionMap = new MockActionMapWithError();
		robot.setActionMap(actionMap);
		return robot;
	}
	
}
