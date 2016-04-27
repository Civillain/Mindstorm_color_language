package see.actions;

import java.util.HashMap;
import java.util.Map;

import lejos.robotics.Color;

public class ActionMap {

	private Map<Integer, ActionType> map;
	private Map<ActionType, Action> robotActions;
	
	public ActionMap() {
		robotActions = new HashMap<>();
		map = new HashMap<>();
		initMap();
	}
	
	private void initMap() {
		map.put(Color.BLUE, ActionType.LEFT);
		map.put(Color.RED, ActionType.RIGHT);
		map.put(Color.YELLOW, ActionType.BACKWARD);
		map.put(Color.GREEN, ActionType.FORWARD);
		map.put(Color.ORANGE, ActionType.ROTATE);
		map.put(Color.BLACK, ActionType.SCAN);
		map.put(Color.WHITE, ActionType.TO_OBSTACLE);
		map.put(Color.MAGENTA, ActionType.REPEAT);
		map.put(Color.BROWN, ActionType.NO_ACTION);
		
		robotActions.put(ActionType.LEFT, new Left());
		robotActions.put(ActionType.RIGHT, new Right());
		robotActions.put(ActionType.BACKWARD, new Backward());
		robotActions.put(ActionType.FORWARD, new Forward());
		robotActions.put(ActionType.ROTATE, new Rotate());
		robotActions.put(ActionType.SCAN, new Scan());
		robotActions.put(ActionType.TO_OBSTACLE, new ToObstacle());
		robotActions.put(ActionType.REPEAT, new Repeat());
		robotActions.put(ActionType.NO_ACTION, new NoAction());
	}
	
	public Action get(Integer color) {
		ActionType actionType =  map.get(color);
		Action action = robotActions.get(actionType);
		return action;
	}
	
}
