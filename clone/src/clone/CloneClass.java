package clone;

public class CloneClass implements Cloneable { 
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}

	int a; 
	double b; 
	
	public CloneClass(int a, double b) {
		this.a = a;
		this.b = b;
	}
	// This method calls Object's clone(). 
	public CloneClass getClone() { 
		try {
			return (CloneClass) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return this; 
		} 
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone(); 
	}
	
	@Override
	public String toString() {
		return "CloneClass [a=" + a + ", b=" + b + "]";
	} 
	
	
}



