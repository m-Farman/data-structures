package tree.binarySearchTree;

import tree.TreeNode;
import tree.TreeUtil;

public class CheckIfGivenTreeIsBst {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createBstFromInput(4, 7, 3, 5, 1, 19);
		boolean isBst = isBst1(root);
		System.out.println("isBst : " + isBst);
		System.out.println("isBst : " + isBst2(root));
		System.out.println("isBst : " + isBstUsingMinMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println("isBst : " + isBstUsingInorderTraversal(root));

	}

	/********************************************************************************/
	/*
	 * this soln return wrong result when subchild is greater than grandparent node
	 * complexity =O(n)
	 */
	private static boolean isBst1(TreeNode<Integer> root) {
		if (root == null) {
			return true;
		}

		if (root.getLeft() != null && (Integer) root.getLeft().getData() > root.getData()) {
			return false;
		}
		if (root.getRight() != null && (Integer) root.getRight().getData() < root.getData()) {
			return false;
		}

		if (!isBst1(root.getLeft()) && !isBst1(root.getRight())) {
			return false;
		}

		return true;
	}

	/********************************************************************************/
	/*
	 * this soln check if the current node is max in it leftsubtree and min in its
	 * rightsubtree . this solve the problem which is not addressed by
	 * isBst1(TreeNode<Integer> root) * complexity =O(n^2)
	 */
	private static boolean isBst2(TreeNode<Integer> root) {
		if (root == null) {
			return true;
		}

		if (root.getLeft() != null && (Integer) root.getLeft().getData() > root.getData()
				&& root.getData() >= max(root)) {
			return false;
		}
		if (root.getRight() != null && (Integer) root.getRight().getData() < root.getData()
				&& root.getData() <= min(root)) {
			return false;
		}

		if (!isBst2(root.getLeft()) && !isBst2(root.getRight())) {
			return false;
		}

		return true;
	}

	private static Integer min(TreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		if (root.getRight() == null) {
			return root.getData();
		}
		return min(root.getRight());
	}

	private static Integer max(TreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		if (root.getLeft() == null) {
			return root.getData();
		}
		return max(root.getLeft());
	}

	/********************************************************************************/

	/* No need to explicitly finding finding min and max in below approach */
	private static boolean isBstUsingMinMax(TreeNode<Integer> root, int min, int max) {
		if (root == null) {
			return true;
		}

		return (root.getData() > min && root.getData() < max && isBstUsingMinMax(root.getLeft(), min, root.getData())
				&& isBstUsingMinMax(root.getRight(), root.getData(), max));
	}

	/********************************************************************************/

	/*
	 * below method leverage inorder traversal for checking BST but uses extra
	 * variable to track the previous data for checking
	 */
	private static int previous = 0;

	private static boolean isBstUsingInorderTraversal(TreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		if (!isBstUsingInorderTraversal(root.getLeft())) {
			return false;
		}

		if (root.getData() < previous) {
			return false;
		}
		previous = root.getData();

		return isBstUsingInorderTraversal(root.getRight());
	}

	/********************************************************************************/
}
