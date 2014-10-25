package assignment;

public class BSTBinaryTreeAssignmentBeginner {
	
	public static BinaryTreeNode<Integer> removeLeaves (BinaryTreeNode<Integer> root) {
		
		if (root == null) {
			return null;
		}
		
		if (root.left != null && root.left.left == null && root.left.right == null) {
			root.left = null;
		}
		
		if (root.right != null && root.right.left == null && root.right.right == null) {
			root.right = null;
		}
		
		if (root != null) {
			removeLeaves(root.left);
		}
		
		if (root != null) {
			removeLeaves(root.right);
		}
		
		return root;
	}
	
	public static int countLeaves(BinaryTreeNode<Integer> root) {
		
		if (root == null) {
			return 0;
		}
		
		int count = 0;
		
		if (root.left == null && root.right == null) {
			count++;
		}
		
		count += countLeaves(root.left);
		count += countLeaves(root.right);
		return count;
	}
	
	public static void printAncestors(BinaryTreeNode<Integer> root, int data) {
		
		if (root == null) {
			return;
		}
		
		if (root.data > data) {
			if (root.left.data == data) {
				System.out.println(root.data);
			}
			printAncestors(root.left, data);
		} else if (root.data < data) {
			if (root.right.data == data) {
				System.out.println(root.data);
			}
			printAncestors(root.right, data);
		} else {
			return;
		}	
	}
	
	public static BinaryTreeNode<Integer> secondLargestNode(BinaryTreeNode<Integer> root) {
		
		if (root == null) {
			return null;
		}
		
		int max = root.data;
		int secondLargest = 0;
		BinaryTreeNode<Integer> secondLargestNode = root;
		
		BinaryTreeNode<Integer> leftNode = secondLargestNode(root.left);
		if (leftNode != null && leftNode.data < max && leftNode.data > secondLargest) {
			secondLargest = leftNode.data;
			secondLargestNode = leftNode;
		} else if (leftNode != null && leftNode.data > max) {
			max = leftNode.data;
		}
		
		BinaryTreeNode<Integer> rightNode = secondLargestNode(root.right);
		if (rightNode != null && rightNode.data < max && rightNode.data > secondLargest) {
			secondLargest = rightNode.data;
			secondLargestNode = rightNode;
		} else if (rightNode != null && rightNode.data > max) {
			max = rightNode.data;
		}
		return secondLargestNode;
	}
	
	public static void main (String args[]) {
//		BinaryTreeNode<Integer> root = BinaryTreeHelp.takeIntegerInput();
		//BinaryTreeHelp.printTree(removeLeaves(root));
//		System.out.println(countLeaves(root));
//		System.out.println(secondLargestNode(root).data);
//		printAncestors(root, 3);
	}
}
