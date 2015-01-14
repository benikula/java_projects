
package cyclicQueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testQueue {
	
	IQueue<Integer> q;
	private int capacity = 28;
	Thread firstGetter;
	Thread secondGetter;
	Thread firstSetter;
	Thread secondSetter;
	Thread ThirdSetter;
	
	@Before
	public void pre() {
		q = new CyclicQueue<Integer>(capacity);
		firstSetter = new QueuePutter<Integer>(q, 4444, 5000000);
		secondSetter = new QueuePutter<Integer>(q, 2222, 5000000);
		ThirdSetter = new QueuePutter<Integer>(q, 3333, 5000000);
		firstGetter = new QueueGetter<Integer>(q, 7000000);
		secondGetter = new QueueGetter<Integer>(q, 8000000);
	}
	@Test//(timeout = msec)
	public void test() throws InterruptedException {
		System.out.println("\nSTART");
		firstGetter.start();
		firstSetter.start();
		secondSetter.start();
		secondGetter.start();
		ThirdSetter.start();
		
		
		firstSetter.join();
		secondSetter.join();
		ThirdSetter.join();
		firstGetter.join();
		secondGetter.join();
		
		System.out.println("\nDONE");
		assertEquals(0, q.getSize());
	}

}
