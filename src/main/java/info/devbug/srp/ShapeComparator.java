package info.devbug.srp;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

/**
 * @author Aliaksei Bahdanau.
 */
public class ShapeComparator implements Comparator<Shape>
{
	private Map<String, Integer> shapePriorities = new Hashtable<>();

	public ShapeComparator()
	{
		shapePriorities.put("Circle", 1);
		shapePriorities.put("Square", 0);
	}

	private Integer priorityFor(Shape shape)
	{
		final String shapeType = shape.getClass().getSimpleName();
		if (shapePriorities.containsKey(shapeType))
		{
			return shapePriorities.get(shapeType);
		}
		return 0;
	}

	@Override
	public int compare(Shape o1, Shape o2)
	{
		final Integer shape1Priority = priorityFor(o1);
		final Integer shape2Priority = priorityFor(o2);
		return shape1Priority.compareTo(shape2Priority);
	}
}
