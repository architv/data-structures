package assignment;
import org.omg.PortableInterceptor.INACTIVE;

import trees.*;
import trees.GenericsQueues;

public class BinaryTreeAssignment {

	public static void printZigZagTree(trees.BinaryTreeNode<Integer> root) {
		
		GenericStack<trees.BinaryTreeNode<Integer>> oddStack = new GenericStack<trees.BinaryTreeNode<Integer>>();
		GenericStack<trees.BinaryTreeNode<Integer>> evenStack = new GenericStack<trees.BinaryTreeNode<Integer>>();
		
		int level = 1;
		
		oddStack.push(null);
//		oddStack.push(root);
		evenStack.push(null);
		System.out.print(root.data);
		if (root.left != null) {
			evenStack.push(root.left);
		}
		if (root.right != null) {
			evenStack.push(root.right);
		}
		level++;
		System.out.println();
		
		while (!(oddStack.top() == null && evenStack.top() == null)) {
			
			if (level % 2 == 1) {
				trees.BinaryTreeNode<Integer> currentNode = oddStack.pop();
//				evenStack.push(null);
				while (currentNode != null) {
					System.out.print(currentNode.data);
					if (currentNode.left != null) {
						evenStack.push(currentNode.left);
					}
					if (currentNode.right != null) {
						evenStack.push(currentNode.right);
					}
					currentNode = oddStack.pop();
				}
				if (currentNode == null) {
					System.out.println();
					oddStack.push(null);
					level++;
				}
			}
			else {
				trees.BinaryTreeNode<Integer> currentNode = evenStack.pop();
//				oddStack.push(null);
				while (currentNode != null) {
					System.out.print(currentNode.data);
					if (currentNode.right != null) {
						oddStack.push(currentNode.right);
					}
					if (currentNode.left != null) {
						oddStack.push(currentNode.left);
					}
					currentNode = evenStack.pop();
				}
				if (currentNode == null) {
					System.out.println();
					evenStack.push(null);
					level++;
				}
			}
		}
	}
	
	public static boolean isBalanced(trees.BinaryTreeNode<Integer> root) {
		
		if (root == null) {
			return true;
		}
		
		if (root.left != null && root.right == null && 
				(root.left.left != null || root.left.right != null)) {
			return false;
		}
		
		if (root.left == null && root.right != null && 
				(root.right.left != null || root.right.right != null)) {
			return false;
		}
		
		
		boolean leftBalance = isBalanced(root.left);
		boolean rightBalance = isBalanced(root.right);
		
		return leftBalance && rightBalance;
	}
	
	public static trees.BinaryTreeNode<Integer> findNextToMax (trees.BinaryTreeNode<Integer> root, int n) {
		
		GenericsQueues<trees.BinaryTreeNode<Integer>> q = new GenericsQueues<trees.BinaryTreeNode<Integer>>();
		q.enqueue(root);
		trees.BinaryTreeNode<Integer> max = null;
		
		while (!q.isEmpty()) {
			
			trees.BinaryTreeNode<Integer> temp = q.dequeue();
			if (temp.data > n) {
				if (max == null || (max != null && max.data > temp.data)) {
					max = temp;
				}
			}
			if (temp.left != null) {
				q.enqueue(temp.left);
			}
			if (temp.right != null) {
				q.enqueue(temp.right);
			}
		}
		return max;
	}
	
	public static boolean identicalNodes (trees.BinaryTreeNode<Integer> root1, trees.BinaryTreeNode<Integer> root2) {
		GenericsQueues<trees.BinaryTreeNode<Integer>> treeOne = new GenericsQueues<trees.BinaryTreeNode<Integer>>();
		GenericsQueues<trees.BinaryTreeNode<Integer>> treeTwo = new GenericsQueues<trees.BinaryTreeNode<Integer>>();
		treeOne.enqueue(root1);
		treeTwo.enqueue(root2);
		
		while (!treeOne.isEmpty() && !treeTwo.isEmpty()) {
			
			trees.BinaryTreeNode<Integer> nodeOne = treeOne.dequeue();
			trees.BinaryTreeNode<Integer> nodeTwo = treeTwo.dequeue();
			if (nodeOne.data != nodeTwo.data) {
				return false;
			}
			if (nodeOne.left != null) {
				treeOne.enqueue(nodeOne.left);
			}
			if (nodeOne.right != null) {
				treeOne.enqueue(nodeOne.right);
			}
			if (nodeTwo.left != null) {
				treeTwo.enqueue(nodeTwo.left);
			}
			if (nodeTwo.right != null) {
				treeTwo.enqueue(nodeTwo.right);
			}
		}
		return true;
	}
	
	public static boolean isIdentical(trees.BinaryTreeNode<Integer> root1, 
			trees.BinaryTreeNode<Integer> root2) {
		
		if (root1 == null && root2 == null) {
			return true;
		}
		
		boolean leftNodes = isIdentical(root1.left, root2.left);
		boolean rightNodes = isIdentical(root1.right, root2.right);
		
		return leftNodes && rightNodes && (root1.data == root2.data);
	}
	
	public static void main(String[] args) {
//		printZigZagTree(BinaryTree.takeIntegerInput());
		System.out.println(isIdentical(trees.BinaryTree.takeIntegerInput(), trees.BinaryTree.takeIntegerInput()));
//		System.out.println(isBalanced(trees.BinaryTree.takeIntegerInput()));
//		System.out.println(findNextToMax(trees.BinaryTree.takeIntegerInput(), 8).data);
//		System.out.println(identicalNodes(trees.BinaryTree.takeIntegerInput(), trees.BinaryTree.takeIntegerInput()));
	}
}
