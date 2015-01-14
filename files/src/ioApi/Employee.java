package ioApi;

import java.io.Serializable;

public class Employee implements Serializable 
{
	 
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private int id;
    transient private int salary;
    private A a;
     
    
    @Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary
				+ ", a=" + a + "]";
	}


	//getter and setter methods
    public String getName() {
        return name;
    }
 

	public void setName(String name) {
        this.name = name;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public int getSalary() {
        return salary;
    }
 
    public void setSalary(int salary) {
        this.salary = salary;
    }


	public A getA() {
		return a;
	}


	public void setA(A a) {
		this.a = a;
	}
     
    
}
