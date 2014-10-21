package oops;

public class GenericQueueUse {

	public static void main(String[] args) throws QueueEmptyException {
		QueueGeneric<String> q = new QueueGeneric<String>();
		q.enqueue("hello");
		q.enqueue("world");
		q.enqueue("!");
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println(q.front());
	}
}