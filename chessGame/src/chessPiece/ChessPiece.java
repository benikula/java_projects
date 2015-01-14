package chessPiece;

import java.util.ArrayList;
import java.util.List;

import color.Color;
import point.Point;
import behavior.Behavior;

public abstract class ChessPiece {

	protected Color color;
	protected List<Behavior> behaviors;
	
	public ChessPiece(Color color) {
		this.color = color;
		behaviors = new ArrayList<Behavior>();
	}
	
	public Color getColor() {
		return color;
	}
	
	public List<Point> getValidPath(Point src, Point dst) {
		List<Point> path = new ArrayList<Point>();
		for (Behavior behavior : behaviors) {
			path.addAll(behavior.getValidPath(src, dst));
		}
		
		return path;
	}
}
