package see.playback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import see.actions.Action;

public class Recorder implements Iterator<Action> {

	private List<Action> record;
	
	public Recorder() {
		this.record = new ArrayList<>();
	}
	
	public void add(Action action) {
		System.out.println("Recording: " + action.toString());
		record.add(action);
	}
	
	@Override
	public boolean hasNext() {
		return !record.isEmpty();
	}

	@Override
	public Action next() {
		return record.remove(0);
	}

	public List<Action> getRecord() {
		List<Action> clone = Collections.unmodifiableList(record);
		return clone;
	}

	@Override
	public void remove() {
		// not implemented
	}
}
