package trees;

import javax.swing.text.AbstractDocument.LeafElement;

public class TreeProblems {

	public static void findInorderSuccessor(BTInorderSuccessor<Integer> root) {
		if (root == null) {
			return;
		}
		
		if (root.right != null) {
			root.successor = root.right;
		}
		
		findInorderSuccessor(root.left);
		if (root.left != null) {
			root.left.successor = root;
		}
		
		findInorderSuccessor(root.right);
//		if (root.)
	}
	
	public static void leftViewTree (BinaryTreeNode<Integer> root) {
		
		if (root == null) {
			return;
		}
		
		if (root.left == null && root.right == null) {
			return;
		}
		System.out.println(root.data);
		
		leftViewTree(root.left);
	}
	
	public static void rightViewTree (BinaryTreeNode<Integer> root) {
		
		if (root == null) {
			return;
		}
		
		rightViewTree(root.right);
		
		if (root.left == null && root.right == null) {
			return;
		}
		System.out.println(root.data);
		
		
	}
	
	public static void printLeafNodes(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		
		if (root.left == null && root.right == null) {
			System.out.println(root.data);
		}
		
		printLeafNodes(root.left);
		printLeafNodes(root.right);
	}
	
	public static void boundaryView (BinaryTreeNode<Integer> root) {
		// 1. Print the left boundary in top-down manner.
		leftViewTree(root);
		// 2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
		printLeafNodes(root);
		//	2.1 Print all leaf nodes of left sub-tree from left to right.
		// 	2.2 Print all leaf nodes of right subtree from left to right.
		// 3. Print the right boundary in bottom-up manner.
		rightViewTree(root);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTree.takeIntegerInput();
//		leftViewTree(root);
//		rightViewTree(root);
//		printLeafNodes(root);
		boundaryView(root);
	}
	
	

}
