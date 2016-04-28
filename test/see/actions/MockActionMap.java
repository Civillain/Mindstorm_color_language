package see.actions;

import lejos.robotics.Color;

public class MockActionMap extends ActionMapImpl {

	public MockActionMap() {
		super();
		initMap();
	}
	
	private void initMap() {
		map.put(Color.BLUE, ActionType.LEFT);
		map.put(Color.RED, ActionType.RIGHT);
		map.put(Color.YELLOW, ActionType.BACKWARD);
		map.put(Color.GREEN, ActionType.FORWARD);
		map.put(Color.ORANGE, ActionType.ROTATE);
		map.put(Color.BROWN, ActionType.NO_ACTION);
		
		robotActions.put(ActionType.LEFT, new MockLeft());
		robotActions.put(ActionType.RIGHT, new MockRight());
		robotActions.put(ActionType.BACKWARD, new MockBackward());
		robotActions.put(ActionType.FORWARD, new MockForward());
		robotActions.put(ActionType.ROTATE, new MockRotate());
		robotActions.put(ActionType.NO_ACTION, new MockNoAction());
	}
	
	@Override
	public Action get(Integer color) {
		return super.get(color);
	}
}
