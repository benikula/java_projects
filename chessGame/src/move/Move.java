package move;

import exception.InvalidMoveException;
import point.Point;

public interface Move {
	
	void setMove(String move) throws InvalidMoveException;
	Point getSrc();
	Point getDst();
}
