package behavior;

import java.util.ArrayList;
import java.util.List;

import point.Point;

public class PawnBehavior extends Behavior {

	@Override
	public List<Point> getValidPath(Point src, Point dst) {
		List<Point> path = new ArrayList<Point>();
		
		if (src.distance(dst) == 1) {
			if(src.isOnSameColumn(dst) || src.isOnSameDiagonal(dst)) {
				return path;
			}
		}
		
		return null;
	}

}
