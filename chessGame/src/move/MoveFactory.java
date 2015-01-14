package move;

public class MoveFactory {
	public Move getMove(String moveType) {
		if(moveType.equalsIgnoreCase("ChessMove")) {
			return new ChessMove();
		}		
		
		return null;
	}
}
