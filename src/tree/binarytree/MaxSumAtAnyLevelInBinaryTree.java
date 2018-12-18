package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;
import tree.TreeUtil;

public class MaxSumAtAnyLevelInBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(10);
		int maxSum = getMaxSum(root);
		System.out.println("Max Sum at any level in the tree is : " + maxSum);
	}

	private static int getMaxSum(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		TreeNode<Integer> tmp;
		int max = Integer.MIN_VALUE, current = 0;
		while (!queue.isEmpty()) {
			tmp = queue.poll();
			if (tmp != null) {
				current += tmp.getData();
				if (tmp.getLeft() != null) {
					queue.offer(tmp.getLeft());
				}
				if (tmp.getRight() != null) {
					queue.offer(tmp.getRight());
				}

			} else {
				max = Math.max(max, current);
				current = 0;
				if (!queue.isEmpty()) {
					queue.offer(null);
				}
			}
		}
		return max;
	}
}


/*output
Max Sum at any level in the tree is : 27
 * */
