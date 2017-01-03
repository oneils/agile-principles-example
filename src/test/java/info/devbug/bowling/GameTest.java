package info.devbug.bowling;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import info.devbug.bowling.Game;

/**
 * @author Aliaksei Bahdanau.
 */
public class GameTest
{

	private Game game;

	@Before
	public void setUp()
	{
		game = new Game();
	}

	@Test
	public void testTwoThrowsNoMark()
	{
		game.add(5);
		game.add(4);

		assertThat(game.getScore(), is(9));
		assertThat(game.getCurrentFrame(), is(2));
	}

	@Test
	public void testFourThrowsNoMark()
	{
		game.add(5);
		game.add(4);
		game.add(7);
		game.add(2);

		assertThat(game.getScore(), is(18));
		assertThat(game.getScoreForFrame(1), is(9));
		assertThat(game.getScoreForFrame(2), is(18));
	}

	@Test
	public void testSimpleSpare()
	{
		game.add(3);
		game.add(7);
		game.add(3);

		assertThat(game.getScoreForFrame(1), is(13));
	}

	@Test
	public void testSimpleFrameAfterSpare()
	{
		game.add(3);
		game.add(7);
		game.add(3);
		game.add(2);

		assertThat(game.getScoreForFrame(1), is(13));
		assertThat(game.getScoreForFrame(2), is(18));
		assertThat(game.getScore(), is(18));
	}

	@Test
	public void testSimpleStrike()
	{
		game.add(10);
		game.add(3);
		game.add(6);

		assertThat(game.getScoreForFrame(1), is(19));
		assertThat(game.getScore(), is(28));

		assertThat(game.getCurrentFrame(), is(3));
	}

	@Test
	public void testPerfectGame()
	{
		for (int i = 0; i < 12; i++)
		{
			game.add(10);
		}

		assertThat(game.getScore(), is(300));
		assertThat(game.getCurrentFrame(), is(10));

	}

	@Test
	public void testEndOfArray()
	{
		for (int i = 0; i < 9; i++)
		{
			game.add(0);
			game.add(0);
		}
		game.add(2);
		game.add(8); // спэа в 10-м фрейме
		game.add(10); // страйк в последней позиции массива

		assertThat(game.getScore(), is(20));
	}

	@Test
	public void testSampleGame()
	{
		game.add(1);
		game.add(4);
		game.add(4);
		game.add(5);
		game.add(6);
		game.add(4);
		game.add(5);
		game.add(5);
		game.add(10);
		game.add(0);
		game.add(1);
		game.add(7);
		game.add(3);
		game.add(6);
		game.add(4);
		game.add(10);
		game.add(2);
		game.add(8);
		game.add(6);

		assertThat(game.getScore(), is(133));
	}

	@Test
	public void testHeartBreak()
	{
		for (int i = 0; i < 11; i++)
			game.add(10);
		game.add(9);

		assertThat(game.getScore(), is(299));
	}

	@Test
	public void TestTenthFrameSpare()
	{
		for (int i = 0; i < 9; i++)
			game.add(10);
		game.add(9);
		game.add(1);
		game.add(1);

		assertThat(game.getScore(), is(270));
	}

}
