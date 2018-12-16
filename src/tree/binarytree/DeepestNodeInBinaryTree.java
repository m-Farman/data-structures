package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;
import tree.TreeUtil;

public class DeepestNodeInBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(9);
		TreeNode<Integer> node = getDeepestNode(root);
		System.out.println("Deepest Node of the tree is :" + node.getData());
	}

	private static TreeNode<Integer> getDeepestNode(TreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode<Integer> tmp = null;
		while (!queue.isEmpty()) {
			tmp = queue.poll();
			if (tmp.getLeft() != null) {
				queue.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				queue.offer(tmp.getRight());
			}

		}
		return tmp;
	}
}

/*output
 *
Deepest Node of the tree is :9
* */
 