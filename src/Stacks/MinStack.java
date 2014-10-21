package Stacks;

public class MinStack {
	Stack mainStack;
	Stack minStack;
	
	public MinStack() {
		mainStack = new Stack();
		minStack = new Stack();
	}
	
	public int size() {
		return mainStack.size();
	}
	
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}
	
	public void push(int data) {
		
		mainStack.push(data);
		
		if (minStack.isEmpty()) {
			minStack.push(data);
		} 
		else if (minStack.top() > data) {
			minStack.push(data);
		}
	}
	
	public int pop() {
		
		if (mainStack.isEmpty()) {
			return -1;
		}
		
		int data = mainStack.pop();
		
		if (data == minStack.top()) {
			minStack.pop();
		}
		
		return data;
	}
	
	public int getMinimum() {
		if (minStack.isEmpty()) {
			return -1;
		}
		return minStack.top();
	}
	
	public int top() {
		if (mainStack.isEmpty()) {
			return -1;
		}
		return mainStack.top();
	}
}
