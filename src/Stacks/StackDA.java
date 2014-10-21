package Stacks;

import java.util.ArrayList;

public class StackDA<T> {
	
	ArrayList<T> list;
	public StackDA() {
		list = new ArrayList<T>();
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		if (list.size() == 0) {
			return true;
		}
		return false;
	}
	
	public void push (T data) {
		list.add(data);
	}
	
	public T pop() {
		return list.remove(size() - 1);
	}
	
	public T top() {
		return list.get(size() - 1);
	}

 }
