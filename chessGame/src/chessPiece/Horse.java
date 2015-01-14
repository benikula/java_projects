package chessPiece;

import color.Color;
import behavior.HorseBehavior;

public class Horse extends ChessPiece {

	public Horse(Color color) {
		super(color);
		behaviors.add(new HorseBehavior());
	}

	@Override
	public String toString() {
		return "H" + (color == Color.BLACK ? "B" : "W") ;
	}
}
