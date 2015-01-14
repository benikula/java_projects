package linkedList;


public class ListRemoverThread extends Thread {
	DoublyLinkedList<Integer> dll;
	private int n;

	public ListRemoverThread(DoublyLinkedList<Integer> dll, int n) {
		super();
		this.dll = dll;
		this.n = n;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < n; ++i) {
			try {
				dll.remove(n - i - 1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}