package see.events;

public class TouchPressed implements Event<TouchPress> {

	private TouchPress event;
	private Boolean occurred = Boolean.FALSE;
	
	public TouchPressed() {
	}
	
	public TouchPressed(TouchPress event) {
		this.event = event;
		this.occurred = Boolean.TRUE;
	}
	
	@Override
	public Boolean occurred() {
		return occurred;
	}

	@Override
	public TouchPress getEvent() {
		return event;
	}

	@Override
	public String toString() {
		return "TouchPressed [event=" + event + ", occurred=" + occurred + "]";
	}

}
