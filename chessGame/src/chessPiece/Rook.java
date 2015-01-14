package chessPiece;

import color.Color;
import behavior.RookBehavior;

public class Rook extends ChessPiece {

	public Rook(Color color) {
		super(color);
		behaviors.add(new RookBehavior());
	}
	
	@Override
	public String toString() {
		return "R" + (color == Color.BLACK ? "B" : "W") ;
	}
	
}
