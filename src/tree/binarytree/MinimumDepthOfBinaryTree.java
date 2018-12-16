package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;
import tree.TreeUtil;

public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(8);
		int depth = getMinDepth(root);
		System.out.println("Min depth of the tree is :" + depth);
	}

	private static int getMinDepth(TreeNode<Integer> root) {
		if (root == null) {
			return -1;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		int count = 0;
		while (!queue.isEmpty()) {
			TreeNode<Integer> tmp = queue.poll();
			if (tmp != null) {
				if (tmp.getLeft() == null && tmp.getRight() == null) {
					break;
				}
				if (tmp.getLeft() != null) {
					queue.offer(tmp.getLeft());
				}
				if (tmp.getRight() != null) {
					queue.offer(tmp.getRight());
				}
			} else {
				if (!queue.isEmpty()) {
					count++;
					queue.offer(null);
				}

			}
		}

		return count;
	}
}



/*output
 *
Min depth of the tree is :2
 * */
 