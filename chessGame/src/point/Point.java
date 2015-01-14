package point;

public class Point {
	public int row;
	public int column;
	
	public Point(int line, int column) {
		this.row = line;
		this.column = column;
	}
	
	public boolean isOnSameDiagonal(Point dst) {
		if((row - column == dst.row - dst.column) ||
		   (row + column == dst.row + dst.column)) {
			return true;
		}
		return false;
	}

	public boolean isOnSameColumn(Point dst) {
		return (column ==  dst.column) ? true : false;
	}

	public boolean isOnSameRow(Point dst) {
		return (row ==  dst.row) ? true : false;
	}
	
	public int distance(Point dst) {
		if(isOnSameRow(dst)) {
			return Math.abs(column - dst.column);
		}
		if(isOnSameColumn(dst)) {
			return Math.abs(row - dst.row);
		}
		return Math.abs(column - dst.column);
	}
}
