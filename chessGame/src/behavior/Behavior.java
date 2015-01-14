package behavior;

import java.util.List;

import point.Point;


public abstract class Behavior {
	public abstract List<Point> getValidPath(Point src, Point dst);
}
