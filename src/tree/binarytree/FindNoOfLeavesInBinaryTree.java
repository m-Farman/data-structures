package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;
import tree.TreeUtil;

public class FindNoOfLeavesInBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		int height = findLeaves(root);
		System.out.println("No Of leaves in the given tree is :" + height);
		System.out.println("No Of leaves in the given tree NonRecursive way is  : " + findLeavesNonRecursive(root));
	}

	private static int findLeaves(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		if (root.getLeft() == null && root.getRight() == null) {
			return 1;
		}
		return findLeaves(root.getLeft()) + findLeaves(root.getRight());
	}

	private static int findLeavesNonRecursive(TreeNode<Integer> root) {

		if (root == null) {
			return 0;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while (!queue.isEmpty()) {
			TreeNode<Integer> tmp = queue.poll();
			if (tmp.getLeft() == null && tmp.getRight() == null) {
				++count;
			}
			if (tmp.getLeft() != null) {
				queue.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				queue.offer(tmp.getRight());
			}
		}

		return count;
	}
}

/*output
 * 
No Of leaves in the given tree is :4
No Of leaves in the given tree NonRecursive way is  : 4
 * */
 