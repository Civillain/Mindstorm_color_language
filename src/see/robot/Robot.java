package see.robot;

import java.util.ArrayList;
import java.util.List;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.robotics.Color;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;
import see.actions.ActionMap;
import see.actions.ToObstacle;
import see.behaviours.DoRecord;
import see.behaviours.DoReplay;
import see.behaviours.Mode;
import see.comm.ChannelObstacleDetected;
import see.motors.DifferentialRobotMotor;
import see.motors.MediumMotor;
import see.playback.Recorder;
import see.sensors.ColorSensor;
import see.sensors.DistanceSensor;
import see.sensors.SensorMap;
import see.sensors.TouchSensor;

public final class Robot implements Connectable {

	private TouchSensor touchSensor;
	private ColorSensor colorSensor;
	private DistanceSensor distanceSensor;
	private Recorder recorder;
	private DifferentialRobotMotor differentialRobotMotor;
	private MediumMotor mediumMotor;
	private List<Connectable> devices;
	private List<Thread> processes;
	private ActionMap actionMap;
	private SensorMap sensorMap;
	private Mode mode = Mode.IDLE;
	private static Robot ROBOT = null;
	private boolean connected = false;
	
	public static synchronized Robot create() {
		if(ROBOT == null) {
			ROBOT = new Robot();
		}
		return ROBOT;
	}
	
	private Robot() {
		this.devices = new ArrayList<>();
		this.processes = new ArrayList<>();
	}
	
	public void start() {
		System.out.println("Starting Robot");
		for(Connectable device : devices) {
			if(device instanceof Runnable) {
				Runnable r = (Runnable) device;
				Thread t = new Thread(r, r.toString());
				processes.add(t);
			}
		}
		for(Thread t : processes) {
			t.start();
		}
		Behavior doRecord = new DoRecord(this);
		Behavior doReplay = new DoReplay(this);
		Behavior [] behaviors = new Behavior [] {doRecord, doReplay};
		Arbitrator arbitrator = new Arbitrator(behaviors);
		arbitrator.start();
		System.out.println("Arbitrator finished");
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
	
	
	public ActionMap getActionMap() {
		return actionMap;
	}

	public void setActionMap(ActionMap actionMap) {
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
		System.out.println("Connecting Robot");
		sensorMap.connect(robot);
		for(Connectable device : devices ) {
			device.connect(robot);
		}
		ToObstacle toObstacle = (ToObstacle) actionMap.get(Color.WHITE);
		toObstacle.setObstacleDetected((ChannelObstacleDetected)distanceSensor.channel());
		connected = true;
        setLEDPattern(1);
        Sound.beepSequenceUp();
        Delay.msDelay(1000);
	}
	
	public String getProperty(String key) {
		String robotType = System.getProperty("robot.type");
		return System.getProperty(robotType + "." + key);
	}

	public synchronized void setMode(Mode mode) {
		System.out.println("Mode: " + mode.toString());
		this.mode = mode;
		if(mode == Mode.RECORD) {
			setLEDPattern(2); // static red 
		} else if (mode == Mode.REPLAY) {
			setLEDPattern(4); // blink green
		} else {
			setLEDPattern(3); // static yellow
		}
	}

	public synchronized Mode getMode() {
		return mode;
	}
	
	public synchronized boolean checkIfStopped() {
		if(!connected) return false;
		if (Button.readButtons() != 0) {
			System.out.println("Stopping motors");
	        getDifferentialRobotMotor().stop();
	        setLEDPattern(8); // fast blink red
	        Button.discardEvents();
	        if ((Button.waitForAnyPress() & Button.ID_ESCAPE) != 0) {
	        	System.out.println("Stopping robot");
	        	Sound.beepSequence();
	        	setLEDPattern(0); // clear leds
	        	System.exit(0);
	        }
	        Button.waitForAnyEvent();
	        return true;
	    } else {
	    	return false;
	    }
	}
	
	private void setLEDPattern(int pattern) {
		if(!connected) return;
		Button.LEDPattern(pattern);
	}

	public MediumMotor getMediumMotor() {
		return mediumMotor;
	}

	public void setMediumMotor(MediumMotor mediumMotor) {
		this.mediumMotor = mediumMotor;
	}
	
}
