package behavior;

import java.util.ArrayList;
import java.util.List;

import point.Point;

public class BishopBehavior extends Behavior {

	@Override
	public List<Point> getValidPath(Point src, Point dst) {
		List<Point> path = new ArrayList<Point>();
		
		if(src.isOnSameDiagonal(dst)) {
			
			int begin = Math.min(src.row, dst.row);
			int end = Math.max(src.row, dst.row);
			int column = begin == src.row ? src.column : dst.column;
			int inc = column == Math.min(src.column, dst.column) ? 1: -1;
			column += inc;
			for(int row = begin + 1; row < end; ++row, column += inc) {
				path.add(new Point(row, column));
			}
			
			return path;
		}
		
		return null;
	}
	
}
