package heaps;

import java.util.ArrayList;

public class Heap {
	
	ArrayList<Integer> heapList;
	
	public Heap() {
		heapList = new ArrayList<Integer>();
		heapList.add(null);
	}
	
	public int size() {
		return heapList.size() - 1;
	}
	
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}
	
	public int min() {
		return heapList.get(1);
	}
	
	public void insert(int data) {
		heapList.add(data);
		int indexOfData = size();
		while (indexOfData/2 >= 1) {
			if (heapList.get(indexOfData/2) > heapList.get(indexOfData)) {
				int root = heapList.get(indexOfData/2);
				int child = heapList.get(indexOfData);
				heapList.set(indexOfData, root);
				heapList.set(indexOfData/2, child);
			} else {
				break;
			}
			indexOfData = indexOfData/2;
		}
	}
	
	public int removeMin() {
		
		int min = heapList.get(1);
		int child = heapList.get(size());
		heapList.set(1, child);
		heapList.remove(size());
		int index = 1;
		
		while (2*index <= size()) {
			if (2*index + 1 <= size()) {
				if (heapList.get(index) < Math.min(heapList.get(2*index), heapList.get(2*index + 1))) {
					break;
				} else if (heapList.get(2*index) < heapList.get(2*index + 1)) {
					int root = heapList.get(index);
					int immediateChild = heapList.get(2*index);
					heapList.set(index, immediateChild);
					heapList.set(2*index, root);
					index = 2*index;
				} else {
					int root = heapList.get(index);
					int immediateChild = heapList.get(2*index + 1);
					heapList.set(index, immediateChild);
					heapList.set(2*index + 1, root);
					index = 2*index + 1;
				}
			} else {
				if (heapList.get(index) < heapList.get(2*index)) {
					break;
				} else {
					int root = heapList.get(index);
					int immediateChild = heapList.get(2*index);
					heapList.set(index, immediateChild);
					heapList.set(2*index, root);
					index = 2*index;
				}
			}
		}
		return min;
	}
	
}
