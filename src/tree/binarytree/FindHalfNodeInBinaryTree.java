package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;
import tree.TreeUtil;

public class FindHalfNodeInBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(4);
		int height = findHalfNodes(root);
		System.out.println("No Of half nodes in the given tree is :" + height);
		System.out.println("No Of half nodes using NonRecursive way is  : " + findHalfNodesNonRecursive(root));
	}

	private static int findHalfNodes(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		if (root.getLeft() != null && root.getRight() == null) {
			return 1;
		}
		if (root.getLeft() == null && root.getRight() != null) {
			return 1;
		}
		return findHalfNodes(root.getLeft()) + findHalfNodes(root.getRight());
	}

	private static int findHalfNodesNonRecursive(TreeNode<Integer> root) {

		if (root == null) {
			return 0;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while (!queue.isEmpty()) {
			TreeNode<Integer> tmp = queue.poll();
			if ((tmp.getLeft() != null && tmp.getRight() == null)
					|| (tmp.getLeft() == null && tmp.getRight() != null)) {
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
No Of half nodes in the given tree is :1
No Of half nodes using NonRecursive way is  : 1
 * */
