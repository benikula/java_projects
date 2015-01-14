package test;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import linkedList.DoublyLinkedList;

import org.junit.Before;
import org.junit.Test;

public class testList {

	DoublyLinkedList<Integer> dll;
	@Before
	public void init() {
		dll = new DoublyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			dll.pushHead(i);
		}
	}
	
	@Test
	public void testIterator() {
		
		Iterator<Integer> itr = dll.iterator();
		
		int e = 9;
		while (itr.hasNext()) {
			int i = itr.next();
			assertEquals(e, i);
			--e;
		}
	}
	
	@Test
	public void testForEach() {
		Integer e = 9;
		for(Integer a : dll) {
			System.out.println(a);
			assertEquals(e, a);
			--e;
		}
	}
	
	@Test
	public void testIterateOverEmpty() {
		for (int i = 0; i < 10; i++) {
			dll.popHead();
		}
		int i = 0;
		for(Integer a : dll) {
			i += a;
		}
		assertEquals(0, i);
	}

}
