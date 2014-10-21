package trees;

public class GenericsQueues<T> {

	int count;
	GenNode<T> head;
	GenNode<T> tail;
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		
		if(size() == 0) {
			return true;
		}
		return false;
	}
	
	public void enqueue(T newData){
		GenNode<T> fresh = new GenNode<T>();
		fresh.data = newData;
		fresh.next = null;
		
		if(head == null) { 
			head = fresh;
			tail=fresh;
		} else {
			tail.next = fresh;
			tail = tail.next;
		}
		count++;
	}
	
	public T front(){
		
		if(isEmpty()) {
			return null;
		}
		return head.data;
	}
	
	public T dequeue(){
		if(isEmpty()) {
			return null;
		}
		T front = front();
		count--;
		head = head.next;
		if(count == 0) {
			tail=null;
		}
		return front;
	}
}