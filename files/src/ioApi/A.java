package ioApi;

import java.io.Serializable;

public class A implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int a = 9;
	int b = 456;
	@Override
	public String toString() {
		return "A [a=" + a + ", b=" + b + "]";
	}
	
}
