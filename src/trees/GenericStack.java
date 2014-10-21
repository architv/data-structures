package trees;

public class GenericStack<T> {
	
	GenNode<T> head;
	private int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size() == 0)
			return true;
		return false;
	}
	
	public void push(T data) {
		GenNode<T> newNodeToBeAdded = new GenNode<T>();
		newNodeToBeAdded.data = data;
		newNodeToBeAdded.next = head;
		head = newNodeToBeAdded;
		size++;
	}
	
	public T pop() {
		
		if (isEmpty()) {
			return null;
		}
		size--;
		T  data = head.data;
		head = head.next;
		return data;
	}
	
	public T top() {
		if (isEmpty()) {
			return null;
		}
		return head.data;
	}

}
