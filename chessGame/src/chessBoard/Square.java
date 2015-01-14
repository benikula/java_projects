package chessBoard;

import chessPiece.ChessPiece;

public class Square {

	public int row;
	public int column;
	
	public ChessPiece piece;
	
	public Square(int line, int column, ChessPiece piece) {
		this.row = line;
		this.column = column;
		this.piece = piece;
	}
	
	public boolean isOnSameDiagonal(Square dst) {
		if((row - column == dst.row - dst.column) ||
		   (row + column == dst.row + dst.column)) {
			return true;
		}
		return false;
	}

	public boolean isOnSameColumn(Square dst) {
		return (column ==  dst.column) ? true : false;
	}

	public boolean isOnSameLine(Square dst) {
		return (row ==  dst.row) ? true : false;
	}
	
	public int distance(Square dst) {
		if(isOnSameLine(dst)) {
			return Math.abs(column - dst.column);
		}
		if(isOnSameColumn(dst)) {
			return Math.abs(row - dst.row);
		}
		return Math.abs(column - dst.column);
	}
}
