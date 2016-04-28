package see.motors;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import see.actions.Action;
import see.comm.Channel;
import see.comm.ChannelAction;
import see.robot.Robot;

public class DifferentialRobotMotor implements Motor<Action> {

	private ChannelAction channelAction;
	private DifferentialPilot pilot;
	
	public DifferentialRobotMotor() {
		this.channelAction = new ChannelAction(); 
	}
	
	@Override
	public void connect(Robot robot) {
		System.out.println("Connecting differential pilot");
		DifferentialPilot pilot = new DifferentialPilot(getWheelDiameter(robot), getTrackWidth(robot), getLeftMotor(robot), getRightMotor(robot), getReverse(robot));
		this.pilot = pilot;
		pilot.setAcceleration(4000);
		pilot.setTravelSpeed(20); // cm/sec
		pilot.setRotateSpeed(180); // deg/sec
	}
	
	@Override
	public Channel<Action> channel() {
		return channelAction;
	}

	@Override
	public void run() {
		System.out.println("Starting motor: " + this.toString());
		while(true) {
			Action action = channelAction.read();
			try {
				action.perform(pilot);
			} catch (Exception e) {
				System.err.println("Error while performing: " + action.toString() + " " +  e.getCause());
			}
		}
	}
	
	@Override
	public String toString() {
		return "DifferentialRobotMotor";
	}
	
	private double getWheelDiameter(Robot robot) {
		Double d = Double.valueOf(robot.getProperty("wheeldiameter"));
		return d.doubleValue();
	}

	private double getTrackWidth(Robot robot) {
		Double d = Double.valueOf(robot.getProperty("trackwidth"));
		return d.doubleValue();
	}

	private RegulatedMotor getLeftMotor(Robot robot) {
		String portName = robot.getProperty("motor.left.port");
		Port port = LocalEV3.get().getPort(portName);
		RegulatedMotor m = new EV3LargeRegulatedMotor(port);
		return m;
	}

	private RegulatedMotor getRightMotor(Robot robot) {
		String portName = robot.getProperty("motor.right.port");
		Port port = LocalEV3.get().getPort(portName);
		RegulatedMotor m = new EV3LargeRegulatedMotor(port);
		return m;
	}

	private boolean getReverse(Robot robot) {
		Boolean b = Boolean.valueOf(robot.getProperty("motor.reverse"));
		return b.booleanValue();
	}

	@Override
	public synchronized void stop() {
		pilot.stop();
	}
	
}
