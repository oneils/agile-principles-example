package info.devbug.bowling;

/**
 * @author Aliaksei Bahdanau.
 */
public class Frame
{
	private int score;

	public int getScore()
	{
		return this.score;
	}

	public void add(int pins)
	{
		score += pins;
	}
}
