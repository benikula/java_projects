package collections;

public class Person implements Comparable<Person> {
	public String name;
	public int id;
	public int age;
	
	public Person(String name, int id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}

	@Override
	public int compareTo(Person arg0) {
		return id - arg0.id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", age=" + age + "]\n";
	}
	
}
