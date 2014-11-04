package heaps;

import java.util.ArrayList;

public class InplaceHeap {
	
	ArrayList<Integer> inplaceHeap;
	
	public InplaceHeap(ArrayList<Integer> heap) {
		inplaceHeap = heap;
		insert();
	}
	
	public int size() {
		return inplaceHeap.size() - 1;
	}
	
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}
	
	public int min() {
		return inplaceHeap.get(1);
	}
	
	public void insert() {
		for (int i = 2; i < inplaceHeap.size(); i++) {
//			inplaceHeap.add(data);
			int indexOfData = i;
			while (indexOfData/2 >= 1) {
				if (inplaceHeap.get(indexOfData/2) > inplaceHeap.get(indexOfData)) {
					int root = inplaceHeap.get(indexOfData/2);
					int child = inplaceHeap.get(indexOfData);
					inplaceHeap.set(indexOfData, root);
					inplaceHeap.set(indexOfData/2, child);
				} else {
					break;
				}
				indexOfData = indexOfData/2;
			}
		}
	}
	
	public int removeMin() {
		
		int min = inplaceHeap.get(1);
		int child = inplaceHeap.get(size());
		inplaceHeap.set(1, child);
		inplaceHeap.remove(size());
		int index = 1;
		
		while (2*index <= size()) {
			if (2*index + 1 <= size()) {
				if (inplaceHeap.get(index) < Math.min(inplaceHeap.get(2*index), inplaceHeap.get(2*index + 1))) {
					break;
				} else if (inplaceHeap.get(2*index) < inplaceHeap.get(2*index + 1)) {
					int root = inplaceHeap.get(index);
					int immediateChild = inplaceHeap.get(2*index);
					inplaceHeap.set(index, immediateChild);
					inplaceHeap.set(2*index, root);
					index = 2*index;
				} else {
					int root = inplaceHeap.get(index);
					int immediateChild = inplaceHeap.get(2*index + 1);
					inplaceHeap.set(index, immediateChild);
					inplaceHeap.set(2*index + 1, root);
					index = 2*index + 1;
				}
			} else {
				if (inplaceHeap.get(index) < inplaceHeap.get(2*index)) {
					break;
				} else {
					int root = inplaceHeap.get(index);
					int immediateChild = inplaceHeap.get(2*index);
					inplaceHeap.set(index, immediateChild);
					inplaceHeap.set(2*index, root);
					index = 2*index;
				}
			}
		}
		return min;
	}
	
}
