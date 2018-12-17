package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;
import tree.TreeUtil;

public class HeightOfBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		int height = getHeight(root);
		System.out.println("height of the tree is :" + height);
		System.out.println("getHeightLevelTraversal : " + getHeightLevelTraversal(root));
	}

	public static int getHeight(TreeNode<Integer> root) {
		if (root == null) {
			return -1;
		}

		return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
	}

	public static int getHeightLevelTraversal(TreeNode<Integer> root) {

		if (root == null) {
			return -1;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		int count = -1;
		while (!queue.isEmpty()) {
			TreeNode<Integer> tmp = queue.poll();
			if (tmp != null) {
				if (tmp.getLeft() != null) {
					queue.offer(tmp.getLeft());
				}
				if (tmp.getRight() != null) {
					queue.offer(tmp.getRight());
				}
			} else {
				if (!queue.isEmpty()) {
					queue.offer(null);
				}
				count++;
			}
		}

		return count;
	}
}
