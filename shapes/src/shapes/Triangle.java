package shapes;

public class Triangle extends Polygon {

	
	public Triangle() {
		type = "Triangle";
	}
	
	public Triangle(int x, int y, int base, int heigth) {
		super(x, y, base, heigth);
		type = "Triangle";
	}

	@Override
	double area() {
		return base * height / 2;
	}
}
