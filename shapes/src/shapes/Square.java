package shapes;

public class Square extends Polygon {

	public Square() {
		base = height;
		type = "Square";
	}

	public Square(int x, int y, int edge) {
		super(x, y, edge, edge);
		type = "Square";
	}

	@Override
	double area() {
		return base * height;
	}
	
	@Override
	public void setBase(int base) {
		super.setBase(base);
		super.setHeight(base);
	}
	
	@Override
	public void setHeight(int height) {
		super.setHeight(height);
		super.setBase(height);
	}
}
