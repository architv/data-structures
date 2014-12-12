package trees;

import java.util.ArrayList;

public class TreesProblems {

	public static BinaryTreeNode<Integer> lca (
			BinaryTreeNode<Integer> root,
			BinaryTreeNode<Integer> firstNode,
			BinaryTreeNode<Integer> secondNode) {
		
		ArrayList<BinaryTreeNode<Integer>> firstNodeList = findAncestors(root, firstNode);
		ArrayList<BinaryTreeNode<Integer>> secondNodeList = findAncestors(root, secondNode);
		
		for (int i = firstNodeList.size() - 1; i >= 0; i--) {
			if (secondNodeList.get(i) != firstNodeList.get(i)) {
				return firstNodeList.get(i + 1);
			}
		}
		return null;
	}
	
	public static ArrayList<BinaryTreeNode<Integer>> findAncestors (BinaryTreeNode<Integer> root,
			BinaryTreeNode<Integer> toBeFoundNode) {
		
		if (root == null) {
			return null;
		}
		
		ArrayList<BinaryTreeNode<Integer>> ancestorList = new ArrayList<BinaryTreeNode<Integer>>();
		
		if (root.data == toBeFoundNode.data) {
			ancestorList.add(toBeFoundNode);
			return ancestorList;
		}
		
		ArrayList<BinaryTreeNode<Integer>> leftAncestorList = findAncestors(root.left, toBeFoundNode);
		if (leftAncestorList != null) {
			leftAncestorList.add(root);
			return leftAncestorList;
		}
		
		ArrayList<BinaryTreeNode<Integer>> rightAncestorList = findAncestors(root.right, toBeFoundNode);
		if (rightAncestorList != null) {
			rightAncestorList.add(root);
			return rightAncestorList;
		}
		return null;
	}
	
	public static BinaryTreeNode<Integer> lcaBST (
			BinaryTreeNode<Integer> root,
			BinaryTreeNode<Integer> firstNode,
			BinaryTreeNode<Integer> secondNode) {
		
		if (root == null) {
			return null;
		}
		
		if (firstNode.data < root.data && secondNode.data < root.data) {
			return lcaBST(root.left, firstNode, secondNode);
		} 
		
		else if (firstNode.data > root.data && secondNode.data > root.data) {
			return lcaBST(root.right, firstNode, secondNode);
		}
		
		else {
			return root;
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTree.takeIntegerInput();
//		BinaryTreeNode<Integer> ancestor = lca(root, root.left.left, root.left.right);
//		System.out.println(ancestor.data);
		BinaryTreeNode<Integer> ancestor = lcaBST(root, root.left, root.right);
		System.out.println(ancestor.data);
	}
}
