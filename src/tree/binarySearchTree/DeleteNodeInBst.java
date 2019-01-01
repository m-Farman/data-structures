package tree.binarySearchTree;

import tree.TreeNode;
import tree.TreeUtil;

public class DeleteNodeInBst {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createBstFromInput(4, 7, 3, 5, 1, 19);
		System.out.println(root);
		root = delete(root, 4);
		System.out.println(root);
	}

	private static TreeNode<Integer> delete(TreeNode<Integer> root, int node) {

		if (root == null) {
			return null;
		}

		if (root.getData() > node) {
			root.setLeft(delete(root.getLeft(), node));
		} else if (root.getData() < node) {
			root.setRight(delete(root.getRight(), node));
		} else {

			if (root.getLeft() == null) {
				return root.getRight();
			} else if (root.getRight() == null) {
				return root.getLeft();
			} else {
				TreeNode<Integer> min = root.getRight();
				while (min.getLeft() != null) {
					min = min.getLeft();
				}

				root.setData(min.getData());
				root.setRight(delete(root.getRight(), min.getData()));
			}

		}
		return root;
	}
}
