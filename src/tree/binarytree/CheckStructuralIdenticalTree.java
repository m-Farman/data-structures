package tree.binarytree;

import tree.TreeNode;
import tree.TreeUtil;

public class CheckStructuralIdenticalTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(4);
		TreeNode<Integer> root1 = TreeUtil.createTreeOfSize(4);
		boolean isIdentical = checkIfStructuralIdentical(root, root1);
		System.out.println("No Of half nodes in the given tree is :" + isIdentical);
	}

	private static boolean checkIfStructuralIdentical(TreeNode<Integer> root, TreeNode<Integer> root1) {
		if (root == null && root1 == null) {
			return true;
		}
		if ((root != null && root1 == null) || (root == null && root1 != null)) {
			return false;
		}
		return checkIfStructuralIdentical(root.getLeft(), root1.getLeft())
				&& checkIfStructuralIdentical(root.getRight(), root1.getRight());
	}
}
