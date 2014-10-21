package Stacks;

public class Stack2 {
	Node2 head;
	private int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size() == 0)
			return true;
		return false;
	}
	
	public void push(int data, int index) {
		Node2 newNodeToBeAdded = new Node2();
		newNodeToBeAdded.data = data;
		newNodeToBeAdded.index = index;
		newNodeToBeAdded.next = head;
		head = newNodeToBeAdded;
		size++;
	}
	
	public int[] pop() {
		
		if (head == null)
			return null;
		size--;
		int[] arr = new int[2];
		arr[0] = head.data;
		arr[1] = head.index;
		head = head.next;
		return arr;
	}
	
	public int[] top() {
		if (head == null)
			return null;
		int[] arr = new int[2];
		arr[0] = head.data;
		arr[1] = head.index;
		return arr;
	}
}
