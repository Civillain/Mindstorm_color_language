package see.robot;

import lejos.robotics.subsumption.Behavior;
import see.actions.ActionMap;
import see.actions.ActionMapImplButtons;
import see.behaviours.DoRecordButtons;
import see.behaviours.DoReplayKraz3;
import see.motors.DifferentialRobotMotor;
import see.motors.MediumMotor;
import see.playback.Recorder;
import see.sensors.ColorSensor;
import see.sensors.DistanceSensor;
import see.sensors.HiTechnicColorIDColorSensor;
import see.sensors.SensorMap;
import see.sensors.TouchSensor;

public class RobotFactory {
	
	public Robot create() {
		Robot robot = Robot.create();
		Recorder recorder = new Recorder();
		//ColorSensor colorSensor = new RGBColorSensor(robot);
		ColorSensor colorSensor = new HiTechnicColorIDColorSensor(robot);
		TouchSensor touchSensor = new TouchSensor(robot);
		DistanceSensor distanceSensor = new DistanceSensor(robot);
		SensorMap sensorMap = new SensorMap();
		DifferentialRobotMotor differentialRobotMotor = new DifferentialRobotMotor();
		MediumMotor mediumMotor = new MediumMotor();
		robot.setDifferentialRobotMotor(differentialRobotMotor);
		robot.setMediumMotor(mediumMotor);
		robot.setColorSensor(colorSensor);
		robot.setDistanceSensor(distanceSensor);
		robot.setRecorder(recorder);
		robot.setTouchSensor(touchSensor);
		
		//ActionMap actionMap = new ActionMapImplEV3ColorCodes();
		ActionMap actionMap = new ActionMapImplButtons(robot);
		robot.setActionMap(actionMap);
		robot.setSensorMap(sensorMap);
		Behavior doRecord = new DoRecordButtons(robot);
		Behavior doReplay = new DoReplayKraz3(robot);
		robot.addBehavior(doRecord);
		robot.addBehavior(doReplay);
		return robot;
	}
	
}
