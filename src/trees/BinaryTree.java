package trees;

import java.util.Scanner;

public class BinaryTree {

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

	public static BinaryTreeNode<Integer> takeIntegerInput2() {
		
		Scanner console = new Scanner(System.in);
		GenericsQueues<BinaryTreeNode<Integer>> q = new GenericsQueues<BinaryTreeNode<Integer>>();
		
		System.out.println("Enter the root");
		int data = console.nextInt();
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
		root.data = data;
		q.enqueue(root);
		
		while (!q.isEmpty()) {
			
			BinaryTreeNode<Integer> temp = q.dequeue();
			
			System.out.println("Enter left child for " + temp.data);
			int newData = console.nextInt();
			if (newData  != -1) {
				BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>();
				left.data = newData;
				temp.left = left;
				q.enqueue(left);
			}
			
			
			System.out.println("Enter right child for " + temp.data);
			newData = console.nextInt();
			if (newData != -1) {
				BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>();
				right.data = newData;
				temp.right = right;
				q.enqueue(right);
			}
		}
		return root;
	}
	
	public static int height2(BinaryTreeNode<Integer> root) {
		
		if (root == null) {
			return 0;
		}
		
		if (root.left == null && root.right == null) {
			return 1;
		}
		
		int maxHeight = 0;
		int height = 0;
		
		height += height2(root.left);
		
		height += height2(root.right);
		
		if (height > maxHeight) {
			maxHeight = height;
		}
		return height;
	}
	
	public static void printTree2(BinaryTreeNode<Integer> root) {
		
		System.out.println(root.data);
		
		if (root.left != null) {
			printTree(root.left);
		}
		
		if (root.right != null) {
			printTree(root.right);
		}
	}
	
	private static BinaryTreeNode<Integer> postorderPreorderTreeHelp (int[] postOrder, int[] preOrder, int preStart, int preEnd, int postStart, int postEnd) {
		
		if (preStart > preEnd) {
			return null;
		}
		
		BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>();
		rootNode.data = preOrder[preStart];
		int leftSubTreeIndexInPostOrder = -1;
		if (preStart < preOrder.length - 1) {
			int leftSubTreeRootInPreOrder = preOrder[preStart + 1];
			
			for (int i = 0; i <= postEnd; i++) {
				if (postOrder[i] == leftSubTreeRootInPreOrder) {
					leftSubTreeIndexInPostOrder = i;
					break;
				}
			}
		}
		
		int leftSubTreeElements = leftSubTreeIndexInPostOrder - postStart + 1;
		
		if (leftSubTreeElements < 0) {
			leftSubTreeElements = 0;
		}
		
		int leftPreStart = preStart + 1;
		int leftPreEnd = preStart + leftSubTreeElements;
		int leftPostStart = postStart;
		int leftPostEnd = leftSubTreeIndexInPostOrder;
		
		BinaryTreeNode<Integer> leftNode = postorderPreorderTreeHelp(postOrder, preOrder, leftPreStart, leftPreEnd, leftPostStart, leftPostEnd);
		
		int rightPreStart = leftPreEnd + 1;
		int rightPreEnd = preEnd;
		int rightPostStart = leftPostEnd + 1;
		int rightPostEnd = postEnd - 1;
		
		BinaryTreeNode<Integer> rightNode = postorderPreorderTreeHelp(postOrder, preOrder, rightPreStart, rightPreEnd, rightPostStart, rightPostEnd);
		
		rootNode.left = leftNode;
		rootNode.right = rightNode;
		
		return rootNode;		
	}
	
	public static BinaryTreeNode<Integer> postorderPreorderTree (int[] postOrder, int[] preOrder) {
		return postorderPreorderTreeHelp(postOrder, preOrder, 0, postOrder.length - 1, 0, preOrder.length - 1);
	}
	
	public static int height(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public static int diameter(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		
		// diameter if root is included
		int diameter1 = height(root.left) + height(root.right);
		
		// left subtree diameter
		int diameter2 = diameter(root.left);
		
		// right subtree diameter
		int diameter3 = diameter(root.right);
		
		return Math.max(Math.max(diameter1, diameter2), diameter3);
	}
	
	public static int diameter2(BinaryTreeNode<Integer> root) {
		
		if (root == null) {
			return 0;
		}
		
		int rootDia = height(root.left) + height(root.right);
		int leftDia = diameter2(root.left);
		int rightDia = diameter2(root.right);
		
		return Math.max(Math.max(leftDia, rightDia), rootDia);
	}
	
	public static BinaryTreeNode<Integer> findNode(BinaryTreeNode<Integer> root, int data) {
		
		if (root == null) {
			return null;
		}
		
		if (root.data == data) {
			return root;
		}
		
		BinaryTreeNode<Integer> leftNode = findNode(root.left, data);
		if (leftNode != null && leftNode.data == data) {
			return leftNode;
		}
//		
		BinaryTreeNode<Integer> rightNode = findNode(root.right, data);
		if (rightNode != null && rightNode.data == data) {
			return rightNode;
		}
		
		return null;
	}
	
	public static BinaryTreeNode<Integer> mirrorNode (BinaryTreeNode<Integer> root) {
		
		if (root == null) {
			return null;
		}
		
		BinaryTreeNode<Integer> leftNode = mirrorNode(root.left);
		BinaryTreeNode<Integer> rightNode = mirrorNode(root.right);
		
		if (leftNode != null && rightNode != null) {
			BinaryTreeNode<Integer> temp = root.left;
			root.left = root.right;
			root.right = temp;
		} 
		else if (leftNode != null && rightNode == null) {
			root.right = root.left;
			root.left = null;
		}
		else if (leftNode == null && rightNode != null) {
			root.left = root.right;
			root.right = null;
		}
		return root;
	}
	
	public static BinaryTreeNode<Integer> mirrorNode2(BinaryTreeNode<Integer> root) {
	
		if (root == null) { 
			return null;
		}
		
		BinaryTreeNode<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		mirrorNode(root.left);
		mirrorNode(root.right);
		
		return root;
	}
	
	public static void inOrderTraversal (BinaryTreeNode<Integer> root) {
		
		if (root == null) {
			return;
		}
		
		inOrderTraversal(root.left);
		System.out.println(root.data);
		inOrderTraversal(root.right);
	}
	
	public static void printElementsInRange (BinaryTreeNode<Integer> root, int k1, int k2) {
		
		if (root == null) {
			return;
		}
		
		printElementsInRange(root.left, k1, k2);
		if (root.data > k1 && root.data < k2) {
			System.out.println(root.data);
		}
		printElementsInRange(root.right, k1, k2);
	}
	
	private static BinaryTreeNode<Integer> inorderPostorderTreeHelp(int postOrder[], int inOrder[], int postStart, int postEnd, int inStart, 
				int inEnd) {
		
		if (postStart > postEnd) {
			return null;
		}
		
		int root = postOrder[postEnd];
		int rootIndexInOrder = -1;
		
		for (int i = 0; i <= inEnd; i++) {
			if (inOrder[i] == root) {
				rootIndexInOrder = i;
				break;
			}
		}
		
		int leftSubTreeElements = rootIndexInOrder - inStart;
		
		BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>();
		rootNode.data = root;
		
		int leftPostStart = postStart;
		int leftPostEnd = postStart + leftSubTreeElements - 1;
		int leftInStart = inStart;
		int leftInEnd = rootIndexInOrder - 1;
		
		BinaryTreeNode<Integer> leftNode = inorderPostorderTreeHelp(postOrder, inOrder, leftPostStart, leftPostEnd, leftInStart, leftInEnd);
		
		int rightPostStart = leftPostEnd + 1;
		int rightPostEnd = postEnd - 1;
		int rightInStart = rootIndexInOrder + 1;
		int rightInEnd = inEnd;
		
		BinaryTreeNode<Integer> rightNode = inorderPostorderTreeHelp(postOrder, inOrder, rightPostStart, rightPostEnd, rightInStart, rightInEnd);
		
		rootNode.left = leftNode;
		rootNode.right = rightNode;
		
		return rootNode;
	}
	
	public static BinaryTreeNode<Integer> inorderPostorderTree(int postOrder[], int inOrder[]) {
		return inorderPostorderTreeHelp( postOrder, inOrder, 0, postOrder.length - 1, 0, inOrder.length -1);
	}
	
	private static BinaryTreeNode<Integer> inorderPreorderTreeHelp(int preOrder[], int inOrder[],
			int preStart, int preEnd, int inStart, int inEnd) {
		
		if (preStart > preEnd) {
			return null;
		}
		
		int root = preOrder[preStart];
		int rootIndexInOrder = -1;
		
		for (int i = 0; i <= inEnd; i++) {
			if (inOrder[i] == root) {
				rootIndexInOrder = i;
				break;
			}
		}
		
		int leftSubTreeElements = rootIndexInOrder - inStart;
		
		BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>();
		rootNode.data = root;
		
		int leftPreStart = preStart + 1;
		int leftPreEnd = preStart + leftSubTreeElements;
		int leftInStart = inStart;
		int leftInEnd = rootIndexInOrder - 1;
		
		BinaryTreeNode<Integer> leftNode = inorderPreorderTreeHelp(preOrder, inOrder, leftPreStart, leftPreEnd, leftInStart, leftInEnd);
		
		int rightPreStart = leftPreEnd + 1;
		int rightPreEnd = preEnd;
		int rightInStart = rootIndexInOrder + 1;
		int rightInEnd = inEnd;
		
		BinaryTreeNode<Integer> rightNode = inorderPreorderTreeHelp(preOrder, inOrder, rightPreStart, rightPreEnd, rightInStart, rightInEnd);
		
		rootNode.left = leftNode;
		rootNode.right = rightNode;
		
		return rootNode;
	}
	
	public static BinaryTreeNode<Integer> inorderPreorderTree(int preOrder[], int inOrder[]) {
		return inorderPreorderTreeHelp(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
	}
	
	public static void levelOrderTraversal(BinaryTreeNode<Integer> root) {
		
		GenericsQueues<BinaryTreeNode<Integer>> q = new GenericsQueues<BinaryTreeNode<Integer>>();
		q.enqueue(root);
		q.enqueue(null);
		
		while (q.front() != null && !q.isEmpty()) {
			
			BinaryTreeNode<Integer> temp = q.dequeue();
			while (temp != null) {
				System.out.print(temp.data);
				if (temp.left != null) {
					q.enqueue(temp.left);
				}
				if (temp.right != null) {
					q.enqueue(temp.right);
				}
				temp = q.dequeue();
			}
			
			System.out.println();
			if (temp == null) {
				q.enqueue(null);
			}
		}
	}
	
	public static BinaryTreeNode<Integer> maxParentNode(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		
		int maxSum = root.data;
		BinaryTreeNode<Integer> maxNode = root;
		int sum = root.data;
		if (root.left != null && root.right != null) {
			sum += root.right.data + root.left.data;
		} else if (root.left != null && root.right == null) {
			sum += root.left.data;
		} else if (root.left == null && root.right != null) {
			sum += root.right.data;
		}
		 
		if (sum > maxSum) {
			maxSum = sum;
			maxNode = root;
		}
		
		BinaryTreeNode<Integer> leftTemp = maxParentNode(root.left);
		if (leftTemp != null && leftTemp.left != null && leftTemp.right != null) {
			sum = leftTemp.data + leftTemp.right.data + leftTemp.left.data;
			if (sum > maxSum) {
				maxSum = sum;
				maxNode = leftTemp;
			}
		} else if (leftTemp != null && leftTemp.left != null && leftTemp.right == null) {
			sum = leftTemp.data + leftTemp.left.data;
			if (sum > maxSum) {
				maxSum = sum;
				maxNode = leftTemp;
			}
		} else if (leftTemp != null && leftTemp.left == null && leftTemp.right != null) {
			sum = leftTemp.data + leftTemp.right.data;
			if (sum > maxSum) {
				maxSum = sum;
				maxNode = leftTemp;
			} 
		} else if (leftTemp != null && leftTemp.left == null && leftTemp.right == null) {
			sum = leftTemp.data;
			if (sum > maxSum) {
				maxSum = sum;
				maxNode = leftTemp;
			}
		} 
		
		BinaryTreeNode<Integer> rightTemp = maxParentNode(root.right);
		if (rightTemp != null && rightTemp.left != null && rightTemp.right != null) {
			sum = rightTemp.data + rightTemp.right.data + rightTemp.left.data;
			if (sum > maxSum) {
				maxSum = sum;
				maxNode = rightTemp;
			}
		} else if (rightTemp != null && rightTemp.left != null && rightTemp.right == null) {
			sum = rightTemp.data + rightTemp.left.data;
			if (sum > maxSum) {
				maxSum = sum;
				maxNode = rightTemp;
			}
		} else if (rightTemp != null && rightTemp.left == null && rightTemp.right != null) {
			sum = rightTemp.data + rightTemp.right.data;
			if (sum > maxSum) {
				maxSum = sum;
				maxNode = rightTemp;
			}
		} else if (rightTemp != null && rightTemp.left == null && rightTemp.right == null) {
			sum = rightTemp.data;
			if (sum > maxSum) {
				maxSum = sum;
				maxNode = rightTemp;
			}
		} 
		return maxNode;
	}
	
	private static int nodesGreaterThanRootHelp(BinaryTreeNode<Integer> root, int max) {
		
		if (root == null) {
			return 0;
		}
		
		int count = 0;
		if (root.data > max) {
			count++;
		}
		
		count += nodesGreaterThanRootHelp(root.left, max);
		count += nodesGreaterThanRootHelp(root.right, max);
		
		return count;
	}
	
	public static int nodesGreaterThanRoot(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		return nodesGreaterThanRootHelp(root, root.data);
	}
	
	public static GenericDoubleNode<Integer> linkedListFromBST (BinaryTreeNode<Integer> root) {
		
		if (root == null) {
			return null;
		}
		
		GenNode<Integer> rootNode = new GenNode<Integer>();
		rootNode.data = root.data;
		GenericDoubleNode<Integer> doubleNode = new GenericDoubleNode<Integer>();
		doubleNode.head = rootNode;
		doubleNode.tail = rootNode;
		
		GenericDoubleNode<Integer> leftSubTree = linkedListFromBST(root.left);			
		GenericDoubleNode<Integer> rightSubTree = linkedListFromBST(root.right);
		
		if (leftSubTree != null && leftSubTree.tail != null) {
			leftSubTree.tail.next = rootNode;
		}
		
		if (rightSubTree != null && rightSubTree.head != null) {
			rootNode.next = rightSubTree.head;
		}
		
		
		if (leftSubTree == null && rightSubTree == null) {
			GenericDoubleNode<Integer> linkedList = new GenericDoubleNode<Integer>();
			linkedList.head = rootNode;
			linkedList.tail = rootNode;
			return linkedList;
		}
		
		else if (leftSubTree == null && rightSubTree != null) {
			GenericDoubleNode<Integer> linkedList = new GenericDoubleNode<Integer>();
			linkedList.head = rootNode;
			linkedList.tail = rightSubTree.tail;
			return linkedList;
		}
		
		else if (leftSubTree != null && rightSubTree == null) {
			GenericDoubleNode<Integer> linkedList = new GenericDoubleNode<Integer>();
			linkedList.head = leftSubTree.head;
			linkedList.tail = rootNode;
			return linkedList;
		}
		else {
			GenericDoubleNode<Integer> linkedList = new GenericDoubleNode<Integer>();
			linkedList.head = leftSubTree.head;
			linkedList.tail = rightSubTree.tail;
			return linkedList;
		}
	}
	
	public static void elementsAtDepthK(BinaryTreeNode<Integer> root, int k) {
		
		if (root == null) {
			return;
		}
		
		if (k == 0) {
			System.out.println(root.data);
		}
		
		elementsAtDepthK(root.left, k - 1);
		elementsAtDepthK(root.right, k - 1);
	}
	
	public static BinaryTreeNode<Integer> search (BinaryTreeNode<Integer> root, int numberToBeFound) {
		
		if (root == null) {
			return null;
		}
		
		else if (root.data > numberToBeFound) {
			return search(root.left, numberToBeFound);
		}
		
		else if (root.data < numberToBeFound) {
			return search(root.right, numberToBeFound);
		}
		
		else {
			return root;
		}
		
	}
	
	public static void printElementsInRangeBST (BinaryTreeNode<Integer> root, int k1, int k2) {
		
		if (root == null) {
			return;
		}
		
		if (root.data >= k1 && root.data <= k2) {
			System.out.println(root.data);
			printElementsInRange(root.right, k1, k2);
			printElementsInRange(root.left, k1, k2);
		}
		
		if (root.data <= k1) {
			printElementsInRange(root.right, k1, k2);
		}
		
		if (root.data >= k2) {
			printElementsInRange(root.left, k1, k2);
		}
		
	}

	public static boolean isBST (BinaryTreeNode<Integer> root, int min, int max) {
		
		if (root == null) {
			return true;
		}
		
		if (!(root.data >= min && root.data <= max)) {
			return false;
		} 
		
		return (isBST(root.left, min, root.data) && isBST(root.right, root.data, max));
	}

	public static BinaryTreeNode<Integer> replaceNodeValueWithDepth (BinaryTreeNode<Integer> root) {
		
		
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = takeIntegerInput2();
//		printTree(root);
////		System.out.println("diameter: " + diameter(root));
//		BinaryTreeNode<Integer> node = findNode(root, 5);
//		System.out.println(node.data);
//		BinaryTreeNode<Integer> node = mirrorNode(root);
//		printTree(node);
//		inOrderTraversal(root);
		
//		int[] inOrder = {4,2,5,7,6,1,10,8,3,9};
//		int[] postOrder = {4,7,6,5,2,10,8,9,3,1};
		
//		int[] postOrder = {2,4,6,7,5,3,1};
//		int[] preOrder = {1,2,3,4,5,6,7};
//		
////		BinaryTreeNode<Integer> root = inorderPostorderTree(postOrder, inOrder);
//		BinaryTreeNode<Integer> root = postorderPreorderTree(postOrder, preOrder);
//		printTree(root);
//		BinaryTreeNode<Integer> root = takeIntegerInput2();
//		printTree2(root);
//		System.out.println(height(root));
//		System.out.println(diameter2(root));
//		printTree(mirrorNode2(root));
//		int[] inOrder = {4,2,5,1,6,3,7};
//		int[] preOrder = {1,2,4,5,3,6,7};
//		BinaryTreeNode<Integer> root1 = inorderPreorderTree(preOrder, inOrder);
//		printTree(root1);
//		System.out.println(maxParentNode(root).data);
//		levelOrderTraversal(root);
//		printElementsInRange(root, 1, 7);
//		GenericDoubleNode<Integer> node = new GenericDoubleNode<Integer>();
//		GenNode<Integer> rootNode = new GenNode<Integer>();
//		rootNode.data = root.data;
//		node.head = rootNode;
//		node.tail = rootNode;
//		GenericDoubleNode<Integer> myNode = linkedListFromTree(root);
//		GenNode<Integer> temp = myNode.head;
//		
//		while (temp != myNode.tail.next) {
//			System.out.println(temp.data);
//			temp = temp.next;
//		}
		
//		System.out.println(linkedListFromTree(root).head.data);
//		System.out.println(search(root, 5).data);
//		printElementsInRangeBST(root, 1, 7);
//		System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
//		System.out.println(nodesGreaterThanRoot(root));
//		elementsAtDepthK(root, 2);
	}

}
