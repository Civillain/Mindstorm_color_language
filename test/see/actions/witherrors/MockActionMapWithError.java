package see.actions.witherrors;

import java.util.HashMap;
import java.util.Map;

import lejos.robotics.Color;
import see.actions.Action;
import see.actions.ActionMapImpl;
import see.actions.ActionType;
import see.actions.MockBackward;
import see.actions.MockLeft;
import see.actions.MockNoAction;
import see.actions.MockRepeat;
import see.actions.MockRight;
import see.actions.MockRotate;
import see.actions.MockScan;
import see.actions.MockToObstacle;

public class MockActionMapWithError extends ActionMapImpl {

	private Map<Integer, ActionType> map;
	private Map<ActionType, Action> robotActions;
	
	public MockActionMapWithError() {
		super();
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
		
		robotActions.put(ActionType.LEFT, new MockLeft());
		robotActions.put(ActionType.RIGHT, new MockRight());
		robotActions.put(ActionType.BACKWARD, new MockBackward());
		robotActions.put(ActionType.FORWARD, new MockForwardWithError());
		robotActions.put(ActionType.ROTATE, new MockRotate());
		robotActions.put(ActionType.SCAN, new MockScan());
		robotActions.put(ActionType.TO_OBSTACLE, new MockToObstacle());
		robotActions.put(ActionType.REPEAT, new MockRepeat());
		robotActions.put(ActionType.NO_ACTION, new MockNoAction());
	}
	
	@Override
	public Action get(Integer color) {
		return super.get(color);
	}
	
}
