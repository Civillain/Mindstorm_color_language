package see.actions;

import java.util.HashMap;
import java.util.Map;

import see.comm.ChannelObstacleDetected;
import see.robot.Robot;
import lejos.hardware.Button;

public class ActionMapImplButtons implements ActionMap {

	protected Map<Integer, ActionType> map;
	protected Map<ActionType, Action> robotActions;
	protected Robot robot;
	
	public ActionMapImplButtons(Robot robot) {
		robotActions = new HashMap<>();
		map = new HashMap<>();
		this.robot = robot;
		initMap();
	}
	
	private void initMap() {
		map.put(Button.ID_LEFT, ActionType.LEFT);
		map.put(Button.ID_RIGHT, ActionType.RIGHT);
		//map.put(Button.ID_DOWN, ActionType.BACKWARD);
		map.put(Button.ID_UP, ActionType.TO_OBSTACLE);
		//map.put(Button.ID_ENTER, ActionType.ROTATE);
		//map.put(Color.PINK, ActionType.MEDIUM_RIGHT);
		//map.put(Color.MAGENTA, ActionType.MEDIUM_LEFT);
		map.put(Button.ID_ENTER, ActionType.REPEAT);
		map.put(Button.ID_DOWN, ActionType.BACKWARD);
		//map.put(Color.NONE, ActionType.NO_ACTION);
		
		robotActions.put(ActionType.LEFT, new Left());
		robotActions.put(ActionType.RIGHT, new Right());
		robotActions.put(ActionType.BACKWARD, new Backward());
		robotActions.put(ActionType.FORWARD, new Forward());
		robotActions.put(ActionType.ROTATE, new Rotate());
		robotActions.put(ActionType.MEDIUM_LEFT, new MediumLeft());
		robotActions.put(ActionType.MEDIUM_RIGHT, new MediumRight());
		robotActions.put(ActionType.MEDIUM_FWD, new MediumForward());
		robotActions.put(ActionType.TO_OBSTACLE, new ToObstacle());
		robotActions.put(ActionType.REPEAT, new Repeat());
		robotActions.put(ActionType.NO_ACTION, new NoAction());
		
		ToObstacle toObstacle = (ToObstacle) robotActions.get(ActionType.TO_OBSTACLE);
		toObstacle.setObstacleDetected((ChannelObstacleDetected)robot.getDistanceSensor().channel());
	}
	
	@Override
	public Action get(Integer color) {
		ActionType actionType =  map.get(color);
		Action action = robotActions.get(actionType);
		if(action == null) {
			action = new NoAction();
		}
		return action;
	}
	
}
