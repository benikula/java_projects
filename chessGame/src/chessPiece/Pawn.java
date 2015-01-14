package chessPiece;

import java.util.List;

import color.Color;
import point.Point;
import behavior.PawnBehavior;

public class Pawn extends ChessPiece {

	public Pawn(Color color) {
		super(color);
		behaviors.add(new PawnBehavior());
	}
	
	@Override
	public List<Point> getValidPath(Point src, Point dst) {
		List<Point> path = super.getValidPath(src, dst);

		if(path != null) {
			if(false == isColorValidMove(src, dst)) {
				return null;
			}
		}
		
		return path;
	}
	
	private boolean isColorValidMove(Point src, Point dst) {
		if(color == Color.BLACK) {
			if(src.row != dst.row + 1) {
				return false;
			}
		}
		else if(color == Color.WHITE) {
			if(src.row != dst.row - 1 ) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "P" + (color == Color.BLACK ? "B" : "W") ;
	}
	
}
