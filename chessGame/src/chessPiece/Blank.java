package chessPiece;

import color.Color;

public class Blank extends ChessPiece {

	public Blank(Color color) {
		super(color);
	}
	
	@Override
	public String toString() {
		return "- ";
	}
}
