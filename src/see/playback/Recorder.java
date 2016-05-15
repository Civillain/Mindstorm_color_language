package see.playback;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import see.actions.Action;
import see.actions.NoAction;
import see.actions.Repeat;

public class Recorder implements Iterator<Action> {

	private List<Action> record;
	
	public Recorder() {
		this.record = new ArrayList<>();
	}
	
	public void add(Action action) {
		if(action instanceof NoAction) {
			return;
		}
		System.out.println(action.toString());
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
			record.add(action);
			Collections.reverse(toRepeat);
			record.addAll(toRepeat);
		} else {
			record.add(action);
		}
	}
	
	
	public void clear() {
		this.record.clear();
	}
	
	public void persist() {
		System.out.println("Persisting record");
		try(FileOutputStream out = new FileOutputStream("record.out"); ObjectOutputStream oos = new ObjectOutputStream(out)) {
			oos.writeObject(record);
		    oos.flush();
		} catch (IOException e) {
			System.out.println("Problem serializing: " + e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void load() {
		System.out.println("Loading record");
		try(FileInputStream in = new FileInputStream("record.out");ObjectInputStream ois = new ObjectInputStream(in)) {
		    this.record = (List<Action>) (ois.readObject());
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Problem serializing: " + e);
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
