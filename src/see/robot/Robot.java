package see.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import see.actions.MockActionMap;
import see.behaviours.DoRecord;
import see.behaviours.DoReplay;
import see.behaviours.Mode;
import see.motors.DifferentialRobotMotor;
import see.playback.Recorder;
import see.sensors.ColorSensor;
import see.sensors.DistanceSensor;
import see.sensors.SensorMap;
import see.sensors.TouchSensor;

public class Robot implements Connectable {

	private TouchSensor touchSensor;
	private ColorSensor colorSensor;
	private DistanceSensor distanceSensor;
	private Recorder recorder;
	private DifferentialRobotMotor differentialRobotMotor;
	private List<Connectable> devices;
	private List<Thread> processes;
	private MockActionMap actionMap;
	private SensorMap sensorMap;
	private Logger logger;
	private Mode mode = Mode.IDLE;
	
	public Robot() {
		this.devices = new ArrayList<>();
		this.processes = new ArrayList<>();
	}
	
	public void start() {
		logger.info("Starting Robot");
		devices.forEach(device -> {
			if(device instanceof Runnable) {
				Runnable r = (Runnable) device;
				Thread t = new Thread(r, r.toString());
				processes.add(t);
			}
		});
		processes.forEach(t -> t.start());
		Behavior doRecord = new DoRecord(this);
		Behavior doReplay = new DoReplay(this);
		Behavior [] behaviors = new Behavior [] {doRecord, doReplay};
		Arbitrator arbitrator = new Arbitrator(behaviors);
		arbitrator.start();
	}
	
	public DifferentialRobotMotor getDifferentialRobotMotor() {
		return differentialRobotMotor;
	}

	public void setDifferentialRobotMotor(
			DifferentialRobotMotor differentialRobotMotor) {
		this.differentialRobotMotor = differentialRobotMotor;
		devices.add(differentialRobotMotor);
	}

	public Recorder getRecorder() {
		return recorder;
	}

	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
	}

	public TouchSensor getTouchSensor() {
		return touchSensor;
	}

	public ColorSensor getColorSensor() {
		return colorSensor;
	}

	public DistanceSensor getDistanceSensor() {
		return distanceSensor;
	}
	
	public void setTouchSensor(TouchSensor touchSensor) {
		this.touchSensor = touchSensor;
		devices.add(touchSensor);
	}

	public void setColorSensor(ColorSensor colorSensor) {
		this.colorSensor = colorSensor;
		devices.add(colorSensor);
	}

	public void setDistanceSensor(DistanceSensor distanceSensor) {
		this.distanceSensor = distanceSensor;
		devices.add(distanceSensor);
	}
	
	
	public MockActionMap getActionMap() {
		return actionMap;
	}

	public void setActionMap(MockActionMap actionMap) {
		this.actionMap = actionMap;
	}

	public SensorMap getSensorMap() {
		return sensorMap;
	}

	public void setSensorMap(SensorMap sensorMap) {
		this.sensorMap = sensorMap;
	}
	
	@Override
	public void connect(Robot robot) {
		logger.info("Connecting Robot");
		sensorMap.connect(robot);
		devices.forEach(device -> device.connect(robot));
	}
	
	public String getProperty(String key) {
		String robotType = System.getProperty("robot.type");
		return System.getProperty(robotType + "." + key);
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public synchronized void setMode(Mode mode) {
		logger.info("Mode: " + mode.toString());
		this.mode = mode;
	}

	public synchronized Mode getMode() {
		return mode;
	}
	
}
