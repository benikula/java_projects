package test;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import linkedList.DoublyLinkedList;
import linkedList.ListPusherThread;
import linkedList.ListRemoverThread;

import org.junit.Before;
import org.junit.Test;

public class testList {

	DoublyLinkedList<Integer> dll;
	@Before
	public void init() {
		dll = new DoublyLinkedList<Integer>();
	}
	
//	@Test
//	public void testIterator() {
//		
//		Iterator<Integer> itr = dll.iterator();
//		
//		int e = 9;
//		while (itr.hasNext()) {
//			int i = itr.next();
//			assertEquals(e, i);
//			--e;
//		}
//	}
//	
//	@Test
//	public void testForEach() {
//		Integer e = 9;
//		for(Integer a : dll) {
//			System.out.println(a);
//			assertEquals(e, a);
//			--e;
//		}
//	}
//	
//	@Test
//	public void testIterateOverEmpty() {
//		for (int i = 0; i < 10; i++) {
//			dll.popHead();
//		}
//		int i = 0;
//		for(Integer a : dll) {
//			i += a;
//		}
//		assertEquals(0, i);
//	}
	
	@Test
	public void testThreads() throws InterruptedException {
		int n = 0;
		for(int i = 0; i < 100; ++i) {
			dll = new DoublyLinkedList<Integer>();
			Thread t1 = new ListPusherThread(dll, 1000);
			Thread t2 = new ListPusherThread(dll, 1000);
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
			
			Iterator<Integer> itr = dll.iterator();
			
			n += dll.getNumOfItems();
			
			while (itr.hasNext()) {
				int j = itr.next();
				System.out.println(j);
			}
		}
		assertEquals(100 * 2 * 1000, n);
	}
	
	@Test
	public void testRemove() throws InterruptedException {
		int n = 0;
		for(int i = 0; i < 1000; ++i) {
			dll = new DoublyLinkedList<Integer>();
			Thread t1 = new ListPusherThread(dll, 1000);
			Thread t2 = new ListPusherThread(dll, 1000);
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
			
			Thread t3 = new ListRemoverThread(dll, 1000);
			Thread t4 = new ListRemoverThread(dll, 1000);
			
			t3.start();
			t4.start();
			t3.join();
			t4.join();
			Iterator<Integer> itr = dll.iterator();
			
			n += dll.getNumOfItems();
			
			while (itr.hasNext()) {
				int j = itr.next();
				System.out.println(j);
			}
		}
		assertEquals(0, n);
	}
}
