package see.events;


public class ColorDetected implements Event<Integer> {

	private Integer event = Integer.valueOf(-1);
	private Boolean occurred = Boolean.FALSE;
	
	public ColorDetected() {
	}
	
	public ColorDetected(Integer event) {
		this.event = event;
		this.occurred = Boolean.TRUE;
	}
	
	@Override
	public Boolean occurred() {
		return occurred;
	}

	@Override
	public Integer getEvent() {
		return event;
	}

	@Override
	public String toString() {
		return "ColorDetected [event=" + event + ", occurred=" + occurred + "]";
	}

}
