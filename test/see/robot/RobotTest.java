package see.robot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import lejos.robotics.Color;

import org.junit.Test;

import see.actions.Action;
import see.events.TouchPress;

public class RobotTest {

	@Test
	public void testStartRobot() throws InterruptedException {
		MockRobotFactory mockRobotFactory = new MockRobotFactory();
		Robot robot = mockRobotFactory.create();
		
		Runnable r = () -> {
			robot.start();
		};
		new Thread(r, "robot").start();
		
		mockRobotFactory.colorQ.add(Color.BLUE);
		mockRobotFactory.colorQ.add(Color.RED);
		mockRobotFactory.colorQ.add(Color.YELLOW);
		mockRobotFactory.colorQ.add(Color.GREEN);
		mockRobotFactory.colorQ.add(Color.ORANGE);
		
		Thread.sleep(100);
		
		List<Action> actions = robot.getRecorder().getRecord();
		assertEquals(5, actions.size());
		assertEquals("Left []", actions.get(0).toString());
		assertEquals("Right []", actions.get(1).toString());
		assertEquals("Backward []", actions.get(2).toString());
		assertEquals("Forward []", actions.get(3).toString());
		assertEquals("Rotate []", actions.get(4).toString());
		
		mockRobotFactory.touchQ.add(TouchPress.PRESSED);
		
		Thread.sleep(1000);
		
		assertTrue(actions.isEmpty());
		
	}
	
}
