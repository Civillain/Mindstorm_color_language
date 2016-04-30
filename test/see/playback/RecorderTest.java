package see.playback;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import see.actions.Action;
import see.actions.Forward;
import see.actions.Repeat;

public class RecorderTest {

	@Test
	public void testRepeat() {
		Recorder r = new Recorder();
		Action fwd = new Forward();
		Action repeat = new Repeat();
		r.add(fwd);
		r.add(repeat);
		List<Action> actions = r.getRecord();
		assertEquals(2, actions.size());
		assertTrue(actions.get(0) instanceof Forward);
		assertTrue(actions.get(1) instanceof Forward);
		
	}

}
