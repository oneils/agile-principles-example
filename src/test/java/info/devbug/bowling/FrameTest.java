package info.devbug.bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import info.devbug.bowling.Frame;

/**
 * @author Aliaksei Bahdanau.
 */
public class FrameTest
{
	@Test
	public void scoreNoThrows()
	{
		Frame frame = new Frame();

		assertThat(frame.getScore(), is(0));
	}

	@Test
	public void addOneThrow()
	{
		Frame frame = new Frame();
		frame.add(5);

		assertThat(frame.getScore(), is(5));

	}
}
