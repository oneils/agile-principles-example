package info.devbug.patterns.templatemethod;

/**
 * @author Aliaksei Bahdanau.
 */
public class DoubleBubbleSorter extends BubbleSorter
{
	double[] array;

	public int sort(double[] arrayToSort)
	{
		this.array = arrayToSort;
		length = arrayToSort.length;
		return doSort();
	}

	@Override
	protected void swap(int index)
	{
		double temp = array[index];
		array[index] = array[index + 1];
		array[index + 1] = temp;
	}

	@Override
	protected boolean outOfOrder(int index)
	{
		return (array[index] > array[index + 1]);
	}
}
