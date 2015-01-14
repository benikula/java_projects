package game;

import point.Point;
import status.Status;
import chessBoard.ChessBoard;

public class ChessGame extends Game {

//	protected ChessBoard board;
	protected ChessBoard board;
	
	public ChessGame() {
		super(2);
	}

	
	public Status move(String step) {
		//TODO check validity in Player
		if(false == isValidStep(step)) {
			return Status.INVALID_MOVE;
		}
		int srcRow = step.charAt(1) - '0' - 1;
		int srcColumn = step.charAt(0) - 'a';
		
		int dstRow = step.charAt(3) - '0' - 1;
		int dstColumn = step.charAt(2) - 'a';
		return board.checkMoveValidity(new Point(srcRow, srcColumn), 
				new Point(dstRow, dstColumn), playingNow.getColor());
		
	}
	
	private boolean isValidStep(String step) {
		return true;
	}

	
	boolean isCheck() {
		return false;
	}
	
	@Override
	public boolean isRnning() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void initGame() {
		board = new ChessBoard();
		
	}

	@Override
	public void startPlaying() {
		int indexSelector = -1;
		while(isRnning()) {
			playingNow = indexSelector == -1 ? players.get(0) : players.get(1);
			Status turnValidity = Status.INVALID_MOVE;
			while(Status.INVALID_MOVE == turnValidity) {
				System.out.println(this);
				String s = playingNow.makeMove();
				turnValidity = move(s);
				if(Status.INVALID_MOVE == turnValidity) {
					System.out.println("\n** Invalid step! try again **");
				}
			}
			indexSelector *= -1;
		}
	}
	
	@Override
	public String toString() {
		return "\nBoard:\n" + board.toString() + "\n";
	}
}
