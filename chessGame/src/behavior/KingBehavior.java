package behavior;

import java.util.ArrayList;
import java.util.List;

import point.Point;

public class KingBehavior extends Behavior {

	@Override
	public List<Point> getValidPath(Point src, Point dst) {
		List<Point> path = new ArrayList<Point>();
		
		if (src.distance(dst) == 1) {
			return path;
		}
		
		return null;
	}

}
