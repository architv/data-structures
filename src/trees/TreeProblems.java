package trees;

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
		if (root.)
	}
	
	public static void main(String[] args) {

	}

}
