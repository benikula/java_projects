package shapes;

public abstract class Polygon extends Shape {

	int base;
	int height;
	String type = null;
	
	Polygon() {
		base = 10;
		height = 2;
	}
	
	Polygon(int x, int y, int base, int heigth) {
		super(x, y);
		this.base = base;
		this.height = heigth;
	}
	
	public void setBase(int base) {
		this.base = base;
	}
	
	public int getBase() {
		return base;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}
	
	@Override
	public String toString() {
		return type + " - Polygon [base=" + base + ", height=" + height + ", x=" 
					+ x + ", y=" + y + ", area()=" + area() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + base;
		result = prime * result + height;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polygon other = (Polygon) obj;
		if (base != other.base)
			return false;
		if (height != other.height)
			return false;
		return true;
	}
	
}
