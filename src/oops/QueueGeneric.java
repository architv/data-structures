package oops;

public class QueueGeneric<T> {
	NodeGeneric<T> head;
	NodeGeneric<T> tail;
	int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size() == 0)
			return true;
		return false;
	}
	
	public void enqueue (T newData) {
		NodeGeneric<T> newNode = new NodeGeneric<T>();
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
	
	public T dequeue () throws QueueEmptyException {
		if (size == 0) {
			QueueEmptyException q = new QueueEmptyException();
			throw q;
		}
		T element = head.data;
		head = head.next;
		if (size == 1)
			tail = null;
		size--;
		return element;
	}
	
	public T front() throws QueueEmptyException {
		if (size == 0) {
			QueueEmptyException q = new QueueEmptyException();
			throw q;
		}
		return head.data;
	}
}