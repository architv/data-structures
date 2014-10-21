package Stacks;

public class QueueLL {

	Node head;
	Node tail;
	int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size() == 0)
			return true;
		return false;
	}
	
	public void enqueue (int newData) {
		Node newNode = new Node();
		newNode.data = newData;
		size++;
		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		tail.next = newNode;
		tail = newNode;
	}
	
	public int dequeue () {
		if (size == 0)
			return -1;
		int element = head.data;
		head = head.next;
		if (size == 1)
			tail = null;
		size--;
		return element;
	}
	
	public int front() {
		if (size == 0)
			return -1;
		return head.data;
	}
}