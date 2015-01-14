package behavior;

import java.util.ArrayList;
import java.util.List;

import point.Point;

public class RookBehavior extends Behavior {

	@Override
	public List<Point> getValidPath(Point src, Point dst) {
		List<Point> path = new ArrayList<Point>();

		if(src.isOnSameRow(dst)) {
			int row = src.row;
			int begin = Math.min(src.column, dst.column);
			int end = Math.max(src.column, dst.column);
			for(int column = begin + 1; column < end; ++column) {
				path.add(new Point(row, column));
			}
			
			return path;
		}
		
		else if(src.isOnSameColumn(dst)) {
			int column = src.column;
			int begin = Math.min(src.row, dst.row);
			int end = Math.max(src.row, dst.row);
			for(int row = begin + 1; row < end; ++row) {
				path.add(new Point(row, column));
			}
			
			return path;
		}
		
		else {
			return null;
		}
		
	}

}
