package heaps;

public class HeapUse {

	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.insert(-1);
		heap.insert(6);
		heap.insert(-5);
		heap.insert(17);
		heap.insert(18);
		heap.insert(3);
		heap.insert(20);
		
		while (!heap.isEmpty()) {
			System.out.println(heap.removeMin());
		}

	}

}
