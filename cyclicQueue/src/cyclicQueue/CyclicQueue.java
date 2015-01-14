package cyclicQueue;

import java.util.Arrays;


public class CyclicQueue<T> implements IQueue<T> {
	private final int capacity;
	private final  Object[] q;
	private int size = 0;
	private int head = 0;
	private int tail = 0;
	private final Object notFull = new Object();
	private final Object notEmpty = new Object();
	
	public CyclicQueue() {
		this(32);
	}
	
	public CyclicQueue(int capacity) {
		this.capacity = capacity;
		q = new Object[capacity];
	}
	
	/* (non-Javadoc)
	 * @see cyclicQueue.IQueue#put(T)
	 */
	@Override
	public void put(T obj) {
		synchronized (notFull) {
			while(size == capacity) {
				try {
					notFull.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			synchronized (this) {
				q[tail++] = obj;
				tail %= capacity;
				++size;
			}
		}
		synchronized (notEmpty) {
			notEmpty.notifyAll();
		}
		System.out.println(this);
	}
	
	/* (non-Javadoc)
	 * @see cyclicQueue.IQueue#get()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T get() {
		T obj = null;
		synchronized (notEmpty) {
			while(size == 0) {
				try {
					notEmpty.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			synchronized (this) {
				obj = (T) q[head];
				q[head++] = null;
				--size;
				head %= capacity;
			}
		}
		synchronized (notFull){ 
			notFull.notifyAll();
		}
		System.out.println(this);
		return obj;
	}
	
	/* (non-Javadoc)
	 * @see cyclicQueue.IQueue#getSize()
	 */
	@Override
	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "CyclicQueue " + Arrays.toString(q) ;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	
}
