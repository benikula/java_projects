package clone;

public class CloneEmbeddedClass implements Cloneable {
	int a; 
	double b; 
	String s;
	CloneClass cc;
	
	public CloneClass getCc() {
		return cc;
	}
	public void setCc(CloneClass cc) {
		this.cc = cc;
	}
	public CloneEmbeddedClass(int a, double b, String s, CloneClass cc) {
		this.a = a;
		this.b = b;
		this.s = s;
		this.cc = cc;
	}
	// This method calls Object's clone(). 
	public CloneEmbeddedClass getClone() { 
		try {
			CloneEmbeddedClass ret =  (CloneEmbeddedClass) super.clone();
			ret.cc = (CloneClass) this.cc.clone();
			
			return ret;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return this; 
		} 
	}
	
	@Override
	public String toString() {
		return "cloneEmbeddedClass [a=" + a + ", b=" + b + ", s=" + s + ", cc="
				+ cc + "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		CloneEmbeddedClass ret =  (CloneEmbeddedClass) super.clone();
		ret.cc = (CloneClass) this.cc.clone();
		
		return ret;
	}
}
