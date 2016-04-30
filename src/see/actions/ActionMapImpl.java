package see.actions;

import java.util.HashMap;
import java.util.Map;

import lejos.robotics.Color;

public class ActionMapImpl implements ActionMap {

	protected Map<Integer, ActionType> map;
	protected Map<ActionType, Action> robotActions;
	
	public ActionMapImpl() {
		robotActions = new HashMap<>();
		map = new HashMap<>();
		initMap();
	}
	
	private void initMap() {
		map.put(Color.BLUE, ActionType.LEFT);
		map.put(Color.RED, ActionType.RIGHT);
		map.put(Color.GREEN, ActionType.BACKWARD);
		map.put(Color.YELLOW, ActionType.FORWARD);
		//map.put(Color.ORANGE, ActionType.ROTATE);
		//map.put(Color.PINK, ActionType.MEDIUM_RIGHT);
		//map.put(Color.MAGENTA, ActionType.MEDIUM_LEFT);
		map.put(Color.WHITE, ActionType.TO_OBSTACLE);
		map.put(Color.BLACK, ActionType.REPEAT);
		map.put(Color.NONE, ActionType.NO_ACTION);
		
		robotActions.put(ActionType.LEFT, new Left());
		robotActions.put(ActionType.RIGHT, new Right());
		robotActions.put(ActionType.BACKWARD, new Backward());
		robotActions.put(ActionType.FORWARD, new Forward());
		robotActions.put(ActionType.ROTATE, new Rotate());
		robotActions.put(ActionType.MEDIUM_LEFT, new MediumLeft());
		robotActions.put(ActionType.MEDIUM_RIGHT, new MediumRight());
		robotActions.put(ActionType.TO_OBSTACLE, new ToObstacle());
		robotActions.put(ActionType.REPEAT, new Repeat());
		robotActions.put(ActionType.NO_ACTION, new NoAction());
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
