package chessPiece;

import color.Color;
import behavior.BishopBehavior;

public class Bishop extends ChessPiece {

	public Bishop(Color color) {
		super(color);
		behaviors.add(new BishopBehavior());
	}
	
	@Override
	public String toString() {
		return "B" + (color == Color.BLACK ? "B" : "W") ;
	}
}
