package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;
import tree.TreeUtil;

public class FindFullNodesInBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		int height = findFullNodes(root);
		System.out.println("No Of full nodes in the given tree is :" + height);
		System.out.println(
				"No Of full nodes in the given tree NonRecursive way is  : " + findFullNodesNonRecursive(root));
	}

	private static int findFullNodes(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		if (root.getLeft() != null && root.getRight() != null) {
			return findFullNodes(root.getLeft()) + findFullNodes(root.getRight()) + 1;
		} else {
			return 0;
		}
	}

	private static int findFullNodesNonRecursive(TreeNode<Integer> root) {

		if (root == null) {
			return 0;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while (!queue.isEmpty()) {
			TreeNode<Integer> tmp = queue.poll();
			if (tmp.getLeft() != null && tmp.getRight() != null) {
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
No Of full nodes in the given tree is :3
No Of full nodes in the given tree NonRecursive way is  : 3
 * */
 