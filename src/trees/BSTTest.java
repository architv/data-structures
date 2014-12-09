package trees;

public class BSTTest {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println(bst.size());
		
		BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>();
		rootNode.data = 4;
		bst.setRoot(rootNode);
		
		BinaryTreeNode<Integer> element = new BinaryTreeNode<Integer>();
		element.data = 2;
		bst.addElement(rootNode, element);
		
		BinaryTreeNode<Integer> element1 = new BinaryTreeNode<Integer>();
		element1.data = 6;
		bst.addElement(rootNode, element1);
		
		BinaryTreeNode<Integer> element2 = new BinaryTreeNode<Integer>();
		element2.data = 1;
		bst.addElement(rootNode, element2);
		
		BinaryTreeNode<Integer> element3 = new BinaryTreeNode<Integer>();
		element3.data = 3;
		bst.addElement(rootNode, element3);
		
		BinaryTreeNode<Integer> element4 = new BinaryTreeNode<Integer>();
		element4.data = 5;
		bst.addElement(rootNode, element4);
		
		BinaryTreeNode<Integer> element5 = new BinaryTreeNode<Integer>();
		element5.data = 7;
		bst.addElement(rootNode, element5);
		
		BinaryTreeNode<Integer> element6 = new BinaryTreeNode<Integer>();
		element6.data = 8;
		bst.addElement(rootNode, element6);
		
		BinaryTree.printTree(rootNode);
		System.out.println(bst.size());
//		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>();
//		newNode.data = 3;
//		rootNode = newNode;
//		BinaryTree.printTree(newNode);

		try {
		System.out.println(bst.root().data);
		} catch (BSTEmptyException BS) {
			System.out.println("Exception");
		}
		
		try {
			bst.removeElement(element5);
		} catch (BSTEmptyException BS) {
			System.out.println("Exception");
		}
		
		try {
			BinaryTree.printTree(bst.root());
		} catch (BSTEmptyException BS) {
			System.out.println("Exception");
		}
		
	}

}
