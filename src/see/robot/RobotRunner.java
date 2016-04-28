package see.robot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
		Properties properties = new Properties();
		File f = new File("robot.properties");
		if (!f.exists()) {
			return;
		}
		FileInputStream fis = new FileInputStream(f);
		try {
			properties.load(fis);
		} finally {
			fis.close();
		}
		System.setProperties(properties);
		System.setProperty("java.home", "/home/root/lejos/programs");
		System.out.println("Loading: " + System.getProperty("robot.type"));
	}
}
