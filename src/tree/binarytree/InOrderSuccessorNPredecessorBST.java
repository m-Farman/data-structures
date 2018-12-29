package tree.binarytree;

import tree.TreeNode;
import tree.TreeUtil;

public class InOrderSuccessorNPredecessorBST {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createBstFromInput(4, 7, 3, 5, 1, 19);
		System.out.println(root);
		System.out.println(" Successor of 5: " + getSuccessor(root, 5));
		System.out.println(" Successor of 7: " + getSuccessor(root, 7));
		System.out.println(" Predecessor of 5: " + getPredecessor(root, 5));
	}

	private static Integer getSuccessor(TreeNode<Integer> root, int node) {

		if (root == null) {
			return null;
		}

		if (root.getData() == node) {
			TreeNode<Integer> tmp = root.getRight();
			while (tmp != null && tmp.getLeft() != null) {
				tmp = tmp.getLeft();
			}
			return tmp == null ? null : tmp.getData();
		}

		if (root.getData() > node) {
			Integer tmp = getSuccessor(root.getLeft(), node);
			return tmp != null ? tmp : root.getData();
		} else {
			return getSuccessor(root.getRight(), node);
		}

	}

	private static Integer getPredecessor(TreeNode<Integer> presentNode, int node) {

		if (presentNode == null) {
			return null;
		}

		if (presentNode.getData() == node) {
			TreeNode<Integer> tmp = presentNode.getLeft();
			if (tmp != null) {
				while (tmp.getRight() != null) {
					tmp = tmp.getRight();
				}
			}
			return tmp == null ? null : tmp.getData();
		}

		if (presentNode.getData() > node) {
			return getPredecessor(presentNode.getLeft(), node);
		} else {
			Integer tmp = getPredecessor(presentNode.getRight(), node);
			return tmp != null ? tmp : presentNode.getData();
		}

	}

}
