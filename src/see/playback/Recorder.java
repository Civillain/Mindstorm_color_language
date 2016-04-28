package see.playback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import see.actions.Action;
import see.actions.Repeat;

public class Recorder implements Iterator<Action> {

	private List<Action> record;
	
	public Recorder() {
		this.record = new ArrayList<>();
	}
	
	public void add(Action action) {
		System.out.println("Recording: " + action.toString());
		record.add(action);
		if(action instanceof Repeat) {
			List<Action> toRepeat = new ArrayList<>();
			for(int i = record.size()-1; i >= 0; i--) {
				Action tr = record.get(i);
				if(! (tr instanceof Repeat)) {
					toRepeat.add(tr);
				} else {
					break;
				}
			}
			record.addAll(toRepeat);
		}
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
