package assignment;

import java.util.HashMap;

public class BSTGraphHashTableHeap {
	
	// prints pair of nodes in a BST which sum to a number
	public static void sumOfPairsHashTable (trees.BinaryTreeNode<Integer> root, int num) {
		
		GenericsQueues<trees.BinaryTreeNode<Integer>> q = new GenericsQueues<trees.BinaryTreeNode<Integer>>();
		HashMap<Integer, Integer> sumOfPairs = new HashMap<Integer, Integer>();
		q.enqueue(root);
		int index = 0;
		
		while (!q.isEmpty()) {
			trees.BinaryTreeNode<Integer> currentNode = q.dequeue();
			if (currentNode != null) {
				sumOfPairs.put(index, currentNode.data);
				index++;
				q.enqueue(currentNode.left);
				q.enqueue(currentNode.right);
			}
		}
		
		for (int i = 0; i < index; i++) {
			int numToBeFound = num - sumOfPairs.get(i);
			if (sumOfPairs.containsValue(numToBeFound)) {
				System.out.println(sumOfPairs.get(i) + " " + (num - sumOfPairs.get(i)));
			}
		}
	}
	
	// prints pair of nodes in a BST which sum to a number
	public static void sumOfPairsRecursive (trees.BinaryTreeNode<Integer> root, int num) {
		GenericsQueues<trees.BinaryTreeNode<Integer>> q = new GenericsQueues<trees.BinaryTreeNode<Integer>>();
//		HashMap<Integer, Integer> sumOfPairs = new HashMap<Integer, Integer>();
		q.enqueue(root);
		
		while (!q.isEmpty()) {
			trees.BinaryTreeNode<Integer> currentNode = q.dequeue();
			if (currentNode != null) {
				int numToBeFound = currentNode.data;
				trees.BinaryTreeNode<Integer> sumNode = sumOfPairsRecursiveHelper(root, num - numToBeFound);
				if (sumNode != null) {
					System.out.println(numToBeFound + " " + sumNode.data);
				}
				q.enqueue(currentNode.left);
				q.enqueue(currentNode.right);
			}
		}
	}
	
	private static trees.BinaryTreeNode<Integer> 
	sumOfPairsRecursiveHelper(trees.BinaryTreeNode<Integer> root, int numToBeFound) {
		
		if (root == null) {
			return null;
		}
		
		else if (root.data == numToBeFound) {
			return root;
		}
		
		else if (root.data > numToBeFound) {
			return sumOfPairsRecursiveHelper(root.left, numToBeFound);
		}
		
		else {
			return sumOfPairsRecursiveHelper(root.right, numToBeFound);
		}
		
		
	}
	
	public static void main(String args[]) {
		trees.BinaryTreeNode<Integer> root = trees.BinaryTree.takeIntegerInput();
//		pairOfNodesHashTable(root, 5);
//		pairOfNodesHashTable(root, 9);
		sumOfPairsRecursive(root, 4);
		
	}

}