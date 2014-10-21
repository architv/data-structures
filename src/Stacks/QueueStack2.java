package Stacks;

public class QueueStack2 {
	
	Stack mainStack;
	Stack reverseStack;
	
	public QueueStack2() {
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
		
		while (!mainStack.isEmpty()) {
			reverseStack.push(mainStack.pop());
		}
		
		reverseStack.push(data);
		
		while (!reverseStack.isEmpty()) {
			mainStack.push(reverseStack.pop());
		}
	}
	
	public int dequeue() {
		
		if (mainStack.isEmpty()) {
			return -1;
		}
		
		return mainStack.pop();
	}
	
	public int front() {
		
		if (mainStack.isEmpty()) {
			return -1;
		}
		
		return mainStack.top();
	}
}
