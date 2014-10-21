package Stacks;

public class StackQ2 {
	
	QueueLL mainQueue;
	QueueLL backQueue;
	
	public StackQ2() {
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
		
		backQueue.enqueue(data);
		
		while (!isEmpty()) {
			backQueue.enqueue(mainQueue.dequeue());
		}
		
		QueueLL temp = mainQueue;
		mainQueue = backQueue;
		backQueue = temp;
	}
	
	public int pop() {
		if (isEmpty())
			return -1;
		return mainQueue.dequeue();
	}
	
	public int front () {
		return mainQueue.front();
	}
}
