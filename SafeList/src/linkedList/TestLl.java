package linkedList;

public class TestLl {

	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.pushHead(2);
		dll.pushHead(3);
		dll.pushHead(4);
		dll.pushHead(5);
		dll.pushHead(6);
		dll.pushHead(7);
		dll.pushHead(8);
		dll.pushHead(9);
		dll.pushHead(10);
		System.out.println(dll);
		
		Action<Integer> a = new Action<Integer>();
		
	}
	
}
