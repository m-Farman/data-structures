package tree.binarytree;

import tree.TreeNode;
import tree.TreeUtil;

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(8);
		int diameter = getDiameter(root);
		System.out.println(diameter);
	}

	private static int getDiameter(TreeNode<Integer> root) {

		if (root == null) {
			return 0;
		}
		int lHeight = getHeight(root.getLeft());
		int rHeight = getHeight(root.getRight());
		int ldiameter = getDiameter(root.getLeft());
		int rdiameter = getDiameter(root.getRight());

		return Math.max(Math.max(ldiameter, rdiameter), lHeight + rHeight + 1);
	}

	private static int getHeight(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
	}
}
