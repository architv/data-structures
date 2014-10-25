package assignment;

import java.util.Scanner;

public class BinaryTreeHelp {
	
	public static void printTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		
		String rootString = root.data + ":"; 
		
		if (root.left != null) {
			rootString += root.left.data + ", ";
		} else {
			rootString += "-1 , ";
		}
		
		
		if (root.right != null) {
			rootString += root.right.data + ", ";
		} else {
			rootString += "-1 , ";
		}
		
		System.out.println(rootString);
		
		printTree(root.left);
		printTree(root.right);
	}
	
	public static BinaryTreeNode<Integer> takeIntegerInput() {
		
		Scanner console = new Scanner(System.in);
		
		System.out.println("Enter root");
		int rootData = console.nextInt();
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
		root.data = rootData;
		
		GenericsQueues<BinaryTreeNode<Integer>> inputQueue = new GenericsQueues<BinaryTreeNode<Integer>>();
		inputQueue.enqueue(root);
		
		while (!inputQueue.isEmpty()) {
			BinaryTreeNode<Integer> currentNode = inputQueue.dequeue();
			System.out.println("Enter left child for " + currentNode.data);
			int next = console.nextInt();
			if (next != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>();
				leftChild.data = next;
				currentNode.left = leftChild;
				inputQueue.enqueue(leftChild);
			}
			
			System.out.println("Enter right child for " + currentNode.data);
			next = console.nextInt();
			if (next != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>();
				rightChild.data = next;
				currentNode.right = rightChild;
				inputQueue.enqueue(rightChild);
			}
		}
		return root;
	}
}
