package chessPiece;

import color.Color;
import behavior.BishopBehavior;
import behavior.RookBehavior;

public class Queen extends ChessPiece {

	public Queen(Color color) {
		super(color);
		behaviors.add(new RookBehavior());
		behaviors.add(new BishopBehavior());
	}

	@Override
	public String toString() {
		return "Q" + (color == Color.BLACK ? "B" : "W") ;
	}
	
}
