package Stacks;

public class StackQ {
	
	QueueLL mainQueue;
	QueueLL backQueue;
	
	public StackQ() {
		mainQueue = new QueueLL();
		backQueue = new QueueLL();
	}
	
	public int size() {
		return mainQueue.size();
	}
	
	public boolean isEmpty () {
		return mainQueue.isEmpty();
	}
	
	public void push (int data) {
		mainQueue.enqueue(data);
	}
	
	public int pop() {
		if (isEmpty())
			return -1;
		while (mainQueue.size() != 1) {
			backQueue.enqueue(mainQueue.dequeue());
		}
		
		QueueLL temp = mainQueue;
		mainQueue = backQueue;
		backQueue = temp;
		
		return backQueue.dequeue();
	}
	
	public int front () {
		if (isEmpty())
			return -1;
		int lastElement = -1;
		while (mainQueue.size() != 0) {
			lastElement = mainQueue.dequeue();
			backQueue.enqueue(lastElement);
		}
		
		QueueLL temp = mainQueue;
		mainQueue = backQueue;
		backQueue = temp;
		
		return lastElement;
	}
}
