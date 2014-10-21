package trees;

import java.util.ArrayList;

public class Node<T> {
	T data;
	ArrayList<Node<T>> children;
	
	public Node() {
		children = new ArrayList<Node<T>>();
	}
}
