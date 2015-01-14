package collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class TestDeque {

	public static void main(String[] args) {
		Deque<Person> deq = new ArrayDeque<Person>();
		deq.add(new Person("first", 12346, 20)); 
		deq.offer(new Person("second", 456412346, 30));
		deq.add(new Person("aaaa", 123545446, 100));
		deq.addFirst(new Person("cljko", 128454346, 10));
		
		System.out.println(deq);
	}

}
