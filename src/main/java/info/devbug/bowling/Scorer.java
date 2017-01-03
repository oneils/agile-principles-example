package info.devbug.bowling;

/**
 * @author Aliaksei Bahdanau.
 */
public class Scorer
{
	private int ball;
	private int[] shots = new int[21];
	private int currentShot;

	public void addShot(int pins)
	{
		shots[currentShot++] = pins;
	}

	public int scoreForFrame(int theFrame)
	{
		int score = 0;
		ball = 0;

		for (int currentFrame = 0; currentFrame < theFrame; currentFrame++)
		{
			if (isStrike())
			{
				score += 10 + getNextTwoBallsForStrike();
				ball++;
			}
			else if (isSpare())
			{
				score += 10 + getNextBallForSpare();
				ball += 2;
			}
			else
			{
				score += getTwoBallsInFrame();
				ball += 2;
			}
		}

		return score;
	}

	private int getNextTwoBallsForStrike()
	{
		return shots[ball + 1] + shots[ball + 2];
	}

	public int getNextBallForSpare()
	{
		return shots[ball + 2];
	}

	public int getTwoBallsInFrame()
	{
		return shots[ball] + shots[ball + 1];
	}

	private boolean isStrike()
	{
		return shots[ball] == 10;
	}

	private boolean isSpare()
	{
		return shots[ball] + shots[ball + 1] == 10;
	}

}
