package see.events;

public class ObstacleDetected implements Event<Float> {

	private Float event = Float.valueOf(-1);
	private Boolean occurred = Boolean.FALSE;
	
	public ObstacleDetected() {}
	
	public ObstacleDetected(Float detected) {
		event = detected;
		occurred = Boolean.TRUE;
	}
	
	@Override
	public Boolean occurred() {
		return occurred;
	}

	@Override
	public Float getEvent() {
		return event;
	}

	@Override
	public String toString() {
		return "ObstacleDetected [event=" + event + ", occurred=" + occurred
				+ "]";
	}

}
