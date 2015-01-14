package linkedList;


public class ListPusherThread extends Thread {
	DoublyLinkedList<Integer> dll;
	int n;
	public ListPusherThread(DoublyLinkedList<Integer> dll, int n) {
		super();
		this.dll = dll;
		this.n = n;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < n; ++i) {
			dll.pushHead(i);
		}
	}
	
}
