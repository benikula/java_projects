package linkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T>{
	
	int numOfItems;
	Node head;
	Node tail;
	
	public DoublyLinkedList() {
		numOfItems = 0;
		head = new Node();
		tail = new Node(null, head, null);
		
		head.setNode(null, null, tail);
		tail.setNode(null, head, null);
	}
	
	

	private void addNodeToHead(Node n) {
		n.prev.next = n;
		n.next.prev = n;
	}

	public void pushHead(T data) {
		Node newNode = new Node(data, head, head.next);
		addNodeToHead(newNode);
		++numOfItems;
	}
	
	public T popHead() {
		if(numOfItems == 0) {
			return null;
		}
		T data = head.next.data;
		
		removeFromHead();
		
		return data;
	}
	
	private void removeFromHead() {
		Node next = head.next.next; 
		next.prev = head;
		head.next = next;
	}

	public class Node {
		T data;
		Node next;
		Node prev;
		
		Node(){}
		
		Node(T data, Node prev, Node next) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
		private void setNode(T data, Node prev, Node next) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}
	
	public class DoublyLinkedListIterator implements Iterator<T> {
		
		Node curr = null;
		
		DoublyLinkedListIterator(Node n) {
			curr = n;
		}
		
		@Override
		public boolean hasNext() {
			if(curr.next != null)
				return true;
			return false;
		}

		@Override
		public T next() {
			T data = curr.data;
			curr = curr.next;
			return data;
		}
		
	}
	
//	public void forEach(Action<T> a) {
//		ListIterator<T> itr = this.listIterator();
//		while(itr.hasNext()) {
//			T element = itr.next();
//			a.print(element);
//		}
//	}

	@Override
	public Iterator<T> iterator() {
		return new DoublyLinkedListIterator(head.next);
	}
	
}

