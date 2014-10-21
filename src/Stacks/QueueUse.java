package Stacks;

public class QueueUse {
	
	public static void revereseQueue (QueueLL q){
		
		if (q.isEmpty()) {
			return;
		}
		
		int front = q.dequeue();
		revereseQueue(q);
		q.enqueue(front);
	}

	public static void main(String[] args) {
//		QueueLL q = new QueueLL();
//		q.enqueue(1);
//		q.enqueue(2);
//		q.enqueue(3);
//		q.enqueue(4);
////		q.dequeue();
////		q.dequeue();
////		System.out.println(q.front());
////		System.out.println(q.size());
////		System.out.println(q.isEmpty());
//		revereseQueue(q);
//		StackQ s1 = new StackQ();
////		s1.push(1);
////		s1.push(2);
////		s1.push(3);
////		s1.push(4);
////		System.out.println(s1.pop());
////		System.out.println(s1.pop());
//		//StacksUsingLinkedList.printLinkedList(s1.head);
//		StackQ2 s2 = new StackQ2();
//		s2.push(1);
//		s2.push(2);
//		s2.push(3);
//		System.out.println(s2.pop());
//		System.out.println(s2.pop());
		QueueStack2 q = new QueueStack2();
		q.enqueue(5);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.front());
	}
}
