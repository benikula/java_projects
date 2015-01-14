package chessBoard;

import java.util.ArrayList;
import java.util.List;

import color.Color;
import point.Point;
import status.Status;
import chessPiece.Bishop;
import chessPiece.ChessPiece;
import chessPiece.Horse;
import chessPiece.King;
import chessPiece.Pawn;
import chessPiece.Queen;
import chessPiece.Rook;

public class ChessBoard {
	private Square[][] board = new Square[8][8];
	private Square whiteKing;
	private Square blackKing;
	
	public ChessBoard() {
		initBoard();
	}
	
	private void initBoard() {
		setSquare(0, 0, new Rook(Color.WHITE));
		setSquare(0, 1, new Horse(Color.WHITE));
		setSquare(0, 2, new Bishop(Color.WHITE));
		setSquare(0, 3, new Queen(Color.WHITE));
		setSquare(0, 4, new King(Color.WHITE));
		setSquare(0, 5, new Bishop(Color.WHITE));
		setSquare(0, 6, new Horse(Color.WHITE));
		setSquare(0, 7, new Rook(Color.WHITE));
		
		for(int column = 0; column < 8; ++column) {
			setSquare(1, column, new Pawn(Color.WHITE));
			setSquare(2, column, null);
			setSquare(3, column, null);
			setSquare(4, column, null);
			setSquare(5, column, null);
			setSquare(6, column, new Pawn(Color.BLACK));
		}
		
		setSquare(7, 0, new Rook(Color.BLACK));
		setSquare(7, 1, new Horse(Color.BLACK));
		setSquare(7, 2, new Bishop(Color.BLACK));
		setSquare(7, 3, new Queen(Color.BLACK));
		setSquare(7, 4, new King(Color.BLACK));
		setSquare(7, 5, new Bishop(Color.BLACK));
		setSquare(7, 6, new Horse(Color.BLACK));
		setSquare(7, 7, new Rook(Color.BLACK));
		
		whiteKing = board[0][4];
		blackKing = board[7][4];
	}
		
	public void setSquare(int line, int column, ChessPiece piece) {
		board[line][column] = new Square(line, column, piece); 
	}
	
	
	public ChessPiece getPiece(int row, int column) {
		return board[row][column].piece;
	}
	
	public boolean isSameColor(Point p, Color c) {
		if(null != board[p.row][p.column].piece){
			return(board[p.row][p.column].piece.getColor() == c);
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("  a  b  c  d  e  f  g  h");
		for(int line = 7; line >= 0; --line) {
			sb.append("\n" + (line + 1));
			for(int column = 0; column < 8; ++column) {
				if(null !=  board[line][column].piece) {
					sb.append(" " + board[line][column].piece);
				}
				else {
					sb.append("  -");
				}
			}
		}
		
		return sb.toString();
	}

	public Status checkMoveValidity(Point src, Point dst, Color c) {
		//check bounds
		if(!inBounds(src) || !inBounds(dst)) {
			return Status.INVALID_MOVE;
		}
		//check turn color
		if(!isValidColor(src, dst, c)) {
			return Status.INVALID_MOVE;
		}
		
		if(!isValidPath(src, dst)) {
			return Status.INVALID_MOVE;
		}
		
		if(getPiece(src) instanceof Pawn) {
			if(false == checkPawnMove(src, dst)) {
				return Status.INVALID_MOVE;
			}
		}
		
//		if(Status.ABANDONMENT == checkCheck(c)) {
//			return Status.INVALID_MOVE;
//		}
		
		updateSquares(src, dst);
		
		return Status.VALID_MOVE;
	}
	
	private void updateSquares(Point src, Point dst) {
		setSquare(dst.row, dst.column, getPiece(src));
		setSquare(src.row, src.column, null);
		
	}

	private boolean isValidPath(Point src, Point dst) {
		ChessPiece piece = getPiece(src);
		List<Point> path = new ArrayList<Point>();
		path = piece.getValidPath(src, dst);
		//check valid move
		if(null == path) {
			return false;
		}
		
		//check free path
		for (Point point : path) {
			if(null != getPiece(point)) {
				return false;
			}
		}
		
		return true;
	}

	private boolean isValidColor(Point src, Point dst, Color c) {
		if(false == isSameColor(src, c)) {
			return false;
		}
		//check dst color
		if(isSameColor(dst, c)) {
			return false;
		}
		return true;
	}

	//FIXME!!!!!!!!!!!!!!!!!!!
	private Status checkCheck(Color c) {
		ChessPiece currKing;
		Point src;
		if(blackKing.piece.getColor() == c) {
			currKing =   blackKing.piece ;
			src = new Point(blackKing.row, blackKing.column);
		}
		else {
			currKing =  whiteKing.piece;
			src = new Point(whiteKing.row, whiteKing.column);
		}
		
		for (Square[] squares : board) {
			for (Square square : squares) {
				if(null != square.piece && square.piece.getColor() != c) {
					Point dst = new Point(square.row, square.column);
					List<Point> path = new ArrayList<Point>();
					path = currKing.getValidPath(src, dst);
					//check valid move
					if(null != path) {
						//check free path
						for (Point point : path) {
							if(null != getPiece(point)) {
								return Status.INVALID_MOVE;
							}
						}
					}
				}
			}
		}
		return null;
	}

	private boolean checkPawnMove(Point src, Point dst) {
		ChessPiece dstPiece = getPiece(dst);
		if(null == dstPiece) {
			if(false == src.isOnSameColumn(dst)) {
				return false;
			}
		}
		else {
			if(src.isOnSameColumn(dst)) {
				return false;
			}
		}
		return true;
	}

	private ChessPiece getPiece(Point src) {
		return board[src.row][src.column].piece;
	}

	private boolean inBounds(Point p) {
		if(p.row >= 0 && p.row < 9 && p.column >= 0 && p.column < 9) {
			return true;
		}
		return false;
	}
}
