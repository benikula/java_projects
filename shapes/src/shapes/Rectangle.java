package shapes;

public class Rectangle extends Triangle {

	
	public Rectangle() {
		type = "Rectangle";
	}

	public Rectangle(int x, int y, int base, int heigth) {
		super(x, y, base, heigth);
		type = "Rectangle";
	}
	
	@Override
	double area() {
		return base * height;
	}
	
}
