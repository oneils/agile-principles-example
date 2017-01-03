package info.devbug.bowling;

/**
 * @author Aliaksei Bahdanau.
 */
public class Game
{
	private int currentFrame = 1;
	private boolean isFirstShot = true;
	private Scorer scorer = new Scorer();

	public int getScore()
	{
		return getScoreForFrame(getCurrentFrame());
	}

	public void add(int pins)
	{
		scorer.addShot(pins);

		adjustCurrentFrame(pins);
	}

	private void adjustCurrentFrame(int pins)
	{
		if (lastBallInFrame(pins))
			advanceFrame();
		else
			isFirstShot = false;
	}

	private boolean lastBallInFrame(int pins)
	{
		return strike(pins) || (!isFirstShot);
	}

	private boolean strike(int pins)
	{
		return (isFirstShot && pins == 10);
	}

	private void advanceFrame()
	{
		currentFrame++;
		if (currentFrame > 10)
		{
			currentFrame = 10;
		}
	}

	public int getScoreForFrame(int theFrame)
	{
		return scorer.scoreForFrame(theFrame);
	}

	public int getCurrentFrame()
	{
		return currentFrame;
	}

}
