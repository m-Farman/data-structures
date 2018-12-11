package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;
import tree.TreeUtil;

public class MaxElementInTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		Integer max = getMaxElementFomTree(root);
		System.out.println("Max value in tree is : " + max);
		System.out.println("Using non recursive way we got : "+getMaxElementFomTreeNonRecursive(root));
	}

	private static Integer getMaxElementFomTree(TreeNode<Integer> root) {
		int max = Integer.MIN_VALUE;
		if (root != null) {
			int left = getMaxElementFomTree(root.getLeft());
			int right = getMaxElementFomTree(root.getRight());
			max = Math.max(left, right);
			max = Math.max(max, root.getData());
		}

		return max;
	}

	private static Integer getMaxElementFomTreeNonRecursive(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode<Integer> tmp = queue.poll();
			max = Math.max(max, tmp.getData());
			if (tmp.getLeft() != null) {
				queue.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				queue.offer(tmp.getRight());
			}
		}

		return max;
	}
}


/*output
Max value in tree is : 7
Using non recursive way we got : 7
 * */
