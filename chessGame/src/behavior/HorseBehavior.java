package behavior;

import java.util.ArrayList;
import java.util.List;

import point.Point;

public class HorseBehavior extends Behavior {

	@Override
	public List<Point> getValidPath(Point src, Point dst) {
		List<Point> path = new ArrayList<Point>();
		if( (Math.abs(src.row - dst.row) == 1 && Math.abs(src.column - dst.column) == 2) ||
			(Math.abs(src.row - dst.row) == 2 && Math.abs(src.column - dst.column) == 1) ) {
			return path;
		}
		return null;
	}

}
