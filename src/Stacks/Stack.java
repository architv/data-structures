package Stacks;

public class Stack {
	
	Node head;
	private int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size() == 0)
			return true;
		return false;
	}
	 
	public void push(int data) {
		Node newNodeToBeAdded = new Node();
		newNodeToBeAdded.data = data;
		newNodeToBeAdded.next = head;
		head = newNodeToBeAdded;
		size++;
	}
	
	public int pop() {
		
		if (head == null)
			return -1;
		size--;
		int  data = head.data;
		head = head.next;
		return data;
	}
	
	public int top() {
		return head.data;
	}
}
