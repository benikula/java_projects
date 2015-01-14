package collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		Person[] s = {new Person("first", 12346, 20), 
					new Person("second", 456412346, 30), 
					new Person("aaaa", 123545446, 100),
					new Person("cljko", 128454346, 10) };
		
		Set<Person> hSet = new HashSet<Person>(Arrays.asList(s));
		Set<Person> tSet = new TreeSet<Person>(Arrays.asList(s));
		Set<Person> lSet = new LinkedHashSet<Person>(Arrays.asList(s));
		for (Person string : s) {
			System.out.println(string);
		}
		System.out.println(hSet);
		System.out.println(tSet);
		System.out.println(lSet);
		
		
	}

}
