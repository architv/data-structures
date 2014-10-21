package Stacks;

public class StackQ3 {
	
	QueueLL mainQueue;
	QueueLL backQueue;

	public int size() {
		return mainQueue.size();
	} 
	
	public boolean isEmpty() {
		return mainQueue.isEmpty();
	}
	
	public void push(int data) {
		mainQueue.enqueue(data);
	}
	
	public int pop() {
		if (mainQueue.isEmpty()){
			return -1;
		}
		
		while (mainQueue.size() == 1) {
			backQueue.enqueue(mainQueue.dequeue());
		}
		
		QueueLL temp = mainQueue;
		mainQueue = backQueue;
		backQueue = temp;
		
		return backQueue.dequeue();
	}
	
	public int top() {
		if (mainQueue.isEmpty()){
			return -1;
		}
		
		int lastElement = 0;
		
		while (mainQueue.isEmpty()) {
			lastElement = mainQueue.dequeue();
			backQueue.enqueue(lastElement);
		}
		
		QueueLL temp = mainQueue;
		mainQueue = backQueue;
		backQueue = temp;
		
		return lastElement;
	}
}