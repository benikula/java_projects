package testClone;

import clone.CloneClass;
import clone.CloneEmbeddedClass;

public class TestClone {

	public static void main(String[] args) {
		CloneClass c = new CloneClass(1, 33);
		CloneClass d = c.getClone();
		CloneClass e = null;
		try {
			e = (CloneClass) d.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
		
		CloneEmbeddedClass em = new CloneEmbeddedClass(1, 2.32, "abcd", c);
		CloneEmbeddedClass em1 = null;
		try {
			em1 = (CloneEmbeddedClass) em.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
		System.out.println(em);
		System.out.println(em1);
		
		em.getCc().setA(1234);
		System.out.println(em);
		System.out.println(em1);
	}

}
