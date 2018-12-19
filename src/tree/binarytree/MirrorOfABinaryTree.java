package tree.binarytree;

import tree.LevelOrderTreeTraversal;
import tree.TreeNode;
import tree.TreeUtil;

public class MirrorOfABinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		LevelOrderTreeTraversal.printLevelWise(root);
		TreeNode<Integer> node = getMirrorImage(root);
		LevelOrderTreeTraversal.printLevelWise(node);
	}

	public static TreeNode<Integer> getMirrorImage(TreeNode<Integer> root) {

		if (root == null) {
			return null;
		}

		getMirrorImage(root.getLeft());
		getMirrorImage(root.getRight());
		TreeNode<Integer> tmp = root.getRight();
		root.setRight(root.getLeft());
		root.setLeft(tmp);
		return root;
	}

}
