package see.robot;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RobotRunner {
	
	public static void main(String [] args) {
		try {
			loadRobotCfg();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		Robot robot = loadRobot();
		robot.connect(robot);
		robot.start();
		System.exit(0);
	}
	
	static Robot loadRobot() {
		RobotFactory robotFactory = new RobotFactory();
		Robot robot = robotFactory.create();
		return robot;
	}
	
	static void loadRobotCfg() throws IOException {
		final Properties properties = new Properties();
		try (final InputStream stream = RobotRunner.class.getClass().getResourceAsStream("robot.properties")) {
		    properties.load(stream);
		}
		System.setProperties(properties);
	}
	
}
