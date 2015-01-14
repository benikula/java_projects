package chessPiece;

import color.Color;
import behavior.KingBehavior;

public class King extends ChessPiece {

	public King(Color color) {
		super(color);
		behaviors.add(new KingBehavior());
	}
	
	@Override
	public String toString() {
		return "K" + (color == Color.BLACK ? "B" : "W") ;
	}
}
