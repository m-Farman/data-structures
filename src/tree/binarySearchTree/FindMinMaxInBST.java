package tree.binarySearchTree;

import tree.TreeNode;
import tree.TreeUtil;

public class FindMinMaxInBST {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createBstFromInput(4, 7, 3, 5, 1, 19);

		System.out.println("Minimum node is " + getMinElement(root));
		System.out.println("Maximum node is " + getMaxElement(root));
		System.out.println("findMin node is " + findMin(root));
		System.out.println("findMax node is " + findMax(root));
	}

	private static TreeNode<Integer> getMaxElement(TreeNode<Integer> root) {

		if (root == null) {
			return null;
		}

		if (root.getRight() == null) {
			return root;
		}
		return getMaxElement(root.getRight());
	}

	private static TreeNode<Integer> getMinElement(TreeNode<Integer> root) {

		if (root == null) {
			return null;
		} 

		if (root.getLeft() == null) {
			return root;
		} else {
			return getMinElement(root.getLeft());
		}
	}

	private static TreeNode<Integer> findMin(TreeNode<Integer> root) {

		if (root == null) {
			return null;
		}
		while (root.getLeft() != null) {
			root = root.getLeft();
		}

		return root;
	}

	private static TreeNode<Integer> findMax(TreeNode<Integer> root) {

		if (root == null) {
			return null;
		}
		while (root.getRight() != null) {
			root = root.getRight();
		}

		return root;
	}
}


/*output
 * 
Minimum node is TreeNode [data=1, left=null, right=null]
Maximum node is TreeNode [data=19, left=null, right=null]
findMin node is TreeNode [data=1, left=null, right=null]
findMax node is TreeNode [data=19, left=null, right=null]
 * */
