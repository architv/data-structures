package Stacks;

public class QueueStack {
	
	Stack mainStack;
	Stack reverseStack;
	
	public QueueStack() {
		mainStack = new Stack();
		reverseStack = new Stack();
	}

	public int size() {
		return mainStack.size();
	}
	
	public boolean isEmpty() {
		if (mainStack.size() == 0) {
			return true;
		}
		return false;
	}
	
	public void enqueue(int data) {
		mainStack.push(data);
	}
	
	public int dequeue() {
		
		if (mainStack.isEmpty()) {
			return -1;
		}
		
		while (!mainStack.isEmpty()) {
			reverseStack.push(mainStack.pop());
		}
		
		int lastElement = reverseStack.pop();
		
		while (!reverseStack.isEmpty()) {
			mainStack.push(reverseStack.pop());
		}
		
		return lastElement;
	}
	
	public int front() {
		
		if (mainStack.isEmpty()) {
			return -1;
		}
		
		while (!mainStack.isEmpty()) {
			reverseStack.push(mainStack.pop());
		}
		
		int frontElement = reverseStack.top();
		
		while (!reverseStack.isEmpty()) {
			mainStack.push(reverseStack.pop());
		}
		
		return frontElement;
	}
}
