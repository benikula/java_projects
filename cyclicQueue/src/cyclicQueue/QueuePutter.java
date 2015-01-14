package cyclicQueue;

public class QueuePutter<T> extends Thread {
	IQueue<T> q;
	T obj;
	private int n;
	
	public QueuePutter(IQueue<T> q, T obj, int n) {
		this.q = q;
		this.obj = obj;
		this.n = n;
	}

	@Override
	public void run() {
		for(int i = 0; i < n; ++i) {
			q.put(obj);
		}
	}
}