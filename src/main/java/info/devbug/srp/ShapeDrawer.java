package info.devbug.srp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Aliaksei Bahdanau.
 */
public class ShapeDrawer
{
	public static void main(String[] args)
	{
		List<Shape> shapes = Arrays.asList(new Circle(), new Square(), new Square(), new Circle());
		drawAllShapes(shapes);
	}

	private static void drawAllShapes(List<Shape> shapes)
	{
		shapes.sort(new ShapeComparator());
		shapes.forEach(Shape::draw);
	}

}
