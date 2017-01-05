package info.devbug.patterns.templatemethod;

/**
 * @author Aliaksei Bahdanau.
 */
public abstract class BubbleSorter
{
	private int operation = 0;
	protected int length = 0;

	protected int doSort()
	{
		if (length <= 1)
		{
			return operation;
		}

		for (int i=0; i<length-1; i++)
		{
			for (int index = 0; index < length-1; index++)
			{
				if(outOfOrder(index))
				{
					swap(index);
				}
				operation++;
			}
		}
		return operation;
	}

	protected abstract void swap(int index);

	protected abstract boolean outOfOrder(int index);
}
