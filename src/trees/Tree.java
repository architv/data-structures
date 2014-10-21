package trees;

import java.util.Scanner;

public class Tree {

	public static void printTree(Node<Integer> root) {
		if (root == null) {
			return;
		}
		
		String rootString = root.data + ":"; 
		
		for (int i = 0; i < root.children.size(); i++) {
			rootString += root.children.get(i).data + ", "; 
		}
		
		System.out.println(rootString);
		
		for (int i = 0; i < root.children.size(); i++) {
			printTree(root.children.get(i)); 
		}
	}
	
	public static Node<Integer> takeIntegerInput() {
		
		Scanner console = new Scanner(System.in);
		
		System.out.println("Enter root");
		int rootData = console.nextInt();
		
		Node<Integer> root = new Node<Integer>();
		root.data = rootData;
		
		GenericsQueues<Node<Integer>> inputQueue = new GenericsQueues<Node<Integer>>();
		inputQueue.enqueue(root);
		
		while (!inputQueue.isEmpty()) {
			Node<Integer> currentNode = inputQueue.dequeue();
			System.out.println("Enter number of children for " + currentNode.data);
			int numChildren = console.nextInt();
			
			for (int i =0; i < numChildren; i++) {
				System.out.println("Enter next Child for " + currentNode.data);
				int nextChild = console.nextInt();
				Node<Integer> newNode = new Node<Integer>();
				newNode.data = nextChild;
				
				currentNode.children.add(newNode);
				inputQueue.enqueue(newNode);
			}
			
		}
		return root;
	}
	
	public static int height(Node<Integer> root) {
		if (root.children.size() == 0) {
			return 1;
		}
		
		int max = 0;
		for (int i = 0; i < root.children.size(); i++) {
			int currentChildHeight = height(root.children.get(i)); 
			if (currentChildHeight > max) {
				max = currentChildHeight;
			}
		}
		return max + 1;
	}
	
	public static int getLargest(Node<Integer> root) {

		int max = root.data;
		
		for (int i = 0; i < root.children.size(); i++) {
			int data = getLargest(root.children.get(i));
			if (data > max) {
				max = data;
			}
		}
		
		return max;
	}
	
	private static int nodesGreaterThanRootHelper(Node<Integer> root, int max) {
		
		int myMax = root.data;
		int count = 0;
		
		if (myMax > max)
			count++;
		
		int newCount = 0;
		for (int i = 0; i < root.children.size(); i++) {
			newCount += nodesGreaterThanRootHelper(root.children.get(i), max);
		}
		
		return count + newCount;
	}
	
	public static int nodesGreaterThanRoot(Node<Integer> root) {
		return nodesGreaterThanRootHelper(root, root.data);
	}
	
	public static Node<Integer> maxSumOfNodes(Node<Integer> root) {
		
		Node<Integer> maxNode = root;
		int max = root.data;
		
		int sum = 0;
		sum += max;
		
		for (int i = 0; i < root.children.size(); i++) {
			sum += root.children.get(i).data;
		}
		
		for (int i = 0; i < root.children.size(); i++) {
			Node<Integer> temp = maxSumOfNodes(root.children.get(i));
			int newSum = 0;
			for (int j = 0; j < temp.children.size(); j++) {
				newSum += temp.children.get(i).data;
			}
			if (newSum > sum) {
				max = sum;
				maxNode = temp;
			}
		}
		return maxNode;
	}
	
	public static Node<Integer> takeInput2() {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the root");
		Node<Integer> root = new Node<Integer>();
		GenericsQueues<Node<Integer>> q = new GenericsQueues<Node<Integer>>();
		root.data = console.nextInt();
		q.enqueue(root);
		
		while (!q.isEmpty()) {
			
			Node<Integer> currentNode = q.dequeue();
			System.out.println("Enter the number of children  for " + currentNode.data);
			int n = console.nextInt();

			
			for (int i = 0; i < n; i++) {
				Node<Integer> newNode = new Node<Integer>();
				System.out.println("Enter next child for " + currentNode.data);
				newNode.data = console.nextInt();
				currentNode.children.add(newNode);
				q.enqueue(newNode);
			}
		}
		return root;
	}

	public static void preOrderTraversal (Node<Integer> root) {
		
		System.out.print(root.data + ":");
		
		for (int i = 0; i < root.children.size(); i++) {
			System.out.print(root.children.get(i).data + ", ");
		}
		
		System.out.println();
		
		for (int i = 0; i < root.children.size(); i++) {
			preOrderTraversal(root.children.get(i));
		}	
	}
	
	public static int maxNodeData (Node<Integer> root) {
		
		if (root.children.size() == 0) {
			return root.data;
		}
		
		int max = 0;
		for (int i = 0; i < root.children.size(); i++) {
			int data = maxNodeData(root.children.get(i));
			if (data > max) {
				max = data;
			}
		}
		
		return Math.max(root.data, max);
	}
	
	public static void elementAtDepthK (Node<Integer> root, int k) {
		
		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		
		for (int i = 0; i < root.children.size(); i++) {
			elementAtDepthK(root.children.get(i), k - 1);
		}
		
	}
	
	private static int numberOfNodesGreaterThanRootHelper(Node<Integer> root, int k) {
		
		int count = 0;
		if (root.data > k) {
			count += 1;
		}
	
		for (int i = 0; i < root.children.size(); i++) {
			count += numberOfNodesGreaterThanRootHelper(root.children.get(i), k);
		}
		
		return count;
	}
	
	public static int numberOfNodesGreaterThanRoot (Node<Integer> root) {
		return numberOfNodesGreaterThanRootHelper(root, root.data);
	}
	
	public static Node<Integer> maxParentNode (Node<Integer> root) {
		
		int maxSum = 0;
		Node<Integer> maxNode = new Node<Integer>();
		int nodeSum = root.data;
		
		for (int i = 0; i < root.children.size(); i++) {
			nodeSum += root.children.get(i).data;
		}
		
		if (nodeSum > maxSum) {
			maxNode = root;
			maxSum = nodeSum;
		}
		
		for (int i = 0; i < root.children.size(); i++) {
			Node<Integer> temp = maxParentNode(root.children.get(i));
			int sum = temp.data;
			
			for (int j = 0; j < temp.children.size(); j++) {
				sum += temp.children.get(j).data;
			}
			
			if (sum > maxSum) {
				maxSum = sum;
				maxNode = temp;
			}
		}
		
		return maxNode;
	}
	
	public static void preOrderTraversalIterative (Node<Integer> root) {
		
		GenericStack<Node<Integer>> s = new GenericStack<Node<Integer>>();
		s.push(root);
		
		while (!s.isEmpty()) {
			Node<Integer> nodeVisited = s.pop();
			System.out.println(nodeVisited.data);
			
			for (int i = nodeVisited.children.size() - 1; i >= 0; i--) {
				s.push(nodeVisited.children.get(i));
			}
		}	
	}
	
	public static void postOrderTraversal(Node<Integer> root) {
		
		for (int i = 0; i < root.children.size(); i++) {
			postOrderTraversal(root.children.get(i));
		}
		System.out.println(root.data);
	}
	
//	public static void levelOrderTraversal (Node<Integer> root) {
//		
//		GenericsQueues<Node<Integer>> q = new GenericsQueues<Node<Integer>>();
//		q.enqueue(root);
//		
//		while (!q.isEmpty()) {
//			Node<Integer> nodeVisited = q.dequeue();
//			System.out.println(nodeVisited.data);
//			
//			for (int i = nodeVisited.children.size() - 1; i >= 0; i--) {
//				q.enqueue(nodeVisited.children.get(i));
//			}
//			
//			for ()
//		}	
//	}
	
	public static int sumOfNodes(Node<Integer> root) {
		
		GenericStack<Node<Integer>> s = new GenericStack<Node<Integer>>();
		s.push(root);
		int sum = 0;
		
		while (!s.isEmpty()) {
			Node<Integer> nodeVisited = s.pop();
			System.out.println(nodeVisited.data);
			sum += nodeVisited.data;
			
			for (int i = nodeVisited.children.size() - 1; i >= 0; i--) {
				s.push(nodeVisited.children.get(i));
			}
		}	
		return sum;
	}
	
	public static void main(String args[]) {
//		Node<Integer> root = takeIntegerInput();
		Node<Integer> root = takeInput2();
//		System.out.println(height(root));
//		printTree(root);
//		preOrderTraversal(root);
		//System.out.println(maxSumOfNodes(root).data);
		//System.out.println(height(root));
//		postOrderTraversal(root);
//		preOrderTraversalIterative(root);
//		System.out.println(getLargest(root));
//		System.out.println(maxNodeData(root));
//		elementAtDepthK(root, 2);
//		System.out.println(numberOfNodesGreaterThanRoot(root));
		System.out.println(maxParentNode(root).data);
	}
}
