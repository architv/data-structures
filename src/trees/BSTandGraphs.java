package trees;

import trees.BinaryTree;

public class BSTandGraphs {
	
	public static BinaryTreeNode<Integer> BSTfromSortedArrayHelp (int[] input, int startIndex, int endIndex) {
		
		if (startIndex > endIndex) {
			return null;
		}
		
		int mid = (startIndex + endIndex)/2;
		BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>();
		rootNode.data = input[mid];
		
		rootNode.left = BSTfromSortedArrayHelp(input, startIndex, mid - 1);
		rootNode.right = BSTfromSortedArrayHelp(input, mid + 1, endIndex);
	
		return rootNode;
	}
	
	public static BinaryTreeNode<Integer> BSTfromSortedArray (int[] input) {
		return BSTfromSortedArrayHelp(input, 0, input.length - 1);
	}

	public static void main(String[] args) {
		BinaryTree.printTree(BSTfromSortedArray(new int[] {1,2,3,4,5,6,7}));
	}

}
