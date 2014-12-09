package trees;

public class BinarySearchTree {

	private BinaryTreeNode<Integer> root;
	private int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}
	
	public BinaryTreeNode<Integer> findElement(BinaryTreeNode<Integer> element) {
	
		if (root == null) {
			return null;
		}
		
		if (root.data == element.data) {
			return root;
		}
		
		else if (root.data > element.data) {
			return findElement(root.left);
		}
		
		else {
			return findElement(root.right);
		}
	}
	
	public BinaryTreeNode<Integer> root() throws BSTEmptyException {
		if (root == null) {
			throw new BSTEmptyException();
		}
		return root;
	}
	
	public void setRoot(BinaryTreeNode<Integer> rootNode) {
		root = rootNode;
		size++; 
	}
	
	public void addElement(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> element) {
		
		if (root.data > element.data) {
			if (root.left == null) {
				root.left = element;
				size++;
			} else {
				addElement(root.left, element);
			}
		}
		
		else {
			if (root.right == null) {
				root.right = element;
				size++;
			} else {
				addElement(root.right, element);
			}
		}
	}
	
	public void removeElement(BinaryTreeNode<Integer> element) throws BSTEmptyException {
		
		if (root == null) {
			throw new BSTEmptyException();
		}
		
		if (root.data == element.data) {
			// find the smallest element in the right subtree
			BinaryTreeNode<Integer> smallest = smallestElementInRightSubTree(element.right);
			// replace root by that element
			smallest.left = root.left;
			smallest.right = root.right;
			root = smallest;
		}
		
		// case 1: the element to be removed has no child
		else if (element.left == null && element.right == null) {
			// set the parent's left or right child to null
			BinaryTreeNode<Integer> elementParent = getParent(root, element);
			if (elementParent.left == element) {
				elementParent.left = null;
			} else {
				elementParent.right = null;
			}
		}
		
		// case 2a: the element to be removed has only left child
		else if (element.left != null && element.right == null) {
			// set the parent's left or right child to element's left child
			BinaryTreeNode<Integer> elementParent = getParent(root, element);
			if (elementParent.left == element) {
				elementParent.left = element.left;
			} else {
				elementParent.right = element.left;
			}
		}
		
		// case 2b: the element to be removed has only right child
		else if (element.left == null && element.right != null) {
			// set the parent's left or right child to element's right child
			BinaryTreeNode<Integer> elementParent = getParent(root, element);
			if (elementParent.left == element) {
				elementParent.left = element.right;
			} else {
				elementParent.right = element.right;
			}
		}
		
		// case 3: the element has both the children
		else {
			// find the smallest element in the right subtree
			BinaryTreeNode<Integer> smallest;
			// special case if the right subtree of the element has only one node
			if (element.right.left == null) {
				smallest = element.right;
				element.right = null;
			} 
			
			// usual case
			else {
				smallest = smallestElementInRightSubTree(element.right);
			}
			
			// replace the the element with the smallest element
			smallest.left = element.left;
			smallest.right = element.right;
			BinaryTreeNode<Integer> elementParent = getParent(root, element);
			if (elementParent.left == element) {
				elementParent.left = smallest;
			} else {
				elementParent.right = smallest;
			}
		}
	}
	
	private BinaryTreeNode<Integer> getParent(BinaryTreeNode<Integer> root,
			BinaryTreeNode<Integer> element) {
		
		if (root.left.data == element.data || root.right.data == element.data) {
			return root;
		}
		 
		else if (root.data > element.data) {
			return getParent(root.left, element);
		}
		
		else {
			return getParent(root.right, element);
		}
	}
	
	private BinaryTreeNode<Integer> smallestElementInRightSubTree(BinaryTreeNode<Integer> rootNode) {
		
		if (rootNode.left.left != null) {
			return smallestElementInRightSubTree(rootNode.left);
		} 
		else {
			// set the left child of the parent element to null
			BinaryTreeNode<Integer> smallest = rootNode.left;
			rootNode.left = null;
			return smallest;
		}
	}
}