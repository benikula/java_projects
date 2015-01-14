package cyclicQueue;

public class QueueGetter<T> extends Thread {
	IQueue<T> q;
	private int n;
	
	
	public QueueGetter(IQueue<T> q, int n) {
		this.q = q;
		this.n = n;
	}

	@Override
	public void run() {
		for(int i = 0; i < n; ++i) {
			q.get();
		}
	}
}
