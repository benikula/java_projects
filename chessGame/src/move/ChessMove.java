package move;

import exception.InvalidMoveException;
import point.Point;

public class ChessMove implements Move {

	String move;
	
	@Override
	public void setMove(String move) throws InvalidMoveException{
		this.move = move;
		
	}

	@Override
	public Point getSrc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getDst() {
		// TODO Auto-generated method stub
		return null;
	}

}
