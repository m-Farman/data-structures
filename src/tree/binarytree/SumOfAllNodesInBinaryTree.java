package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;
import tree.TreeUtil;

public class SumOfAllNodesInBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		int sum = getSumOfAllNodes(root);
		System.out.println("Sum of the tree is : " + sum);
		System.out.println("Sum of the tree is using NonRecursive : " + getSumOfAllNodesNonRecursive(root));
	}

	public static int getSumOfAllNodes(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		return (root.getData() + getSumOfAllNodes(root.getLeft()) + getSumOfAllNodes(root.getRight()));
	}

	public static int getSumOfAllNodesNonRecursive(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		int sum = 0;
		while (!queue.isEmpty()) {
			TreeNode<Integer> tmp = queue.poll();
			sum += tmp.getData();

			if (tmp.getLeft() != null) {
				queue.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				queue.offer(tmp.getRight());
			}

		}

		return sum;
	}

}
