package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.TreeNode;
import tree.TreeUtil;

public class ReverseLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		printReverseLevelOrder(root);

	}

	private static void printReverseLevelOrder(TreeNode<Integer> root) {
		if (root == null) {
			System.out.println("Empty");
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		Stack<TreeNode<Integer>> stack = new Stack<>();
		while (!queue.isEmpty()) {
			TreeNode<Integer> tmp = queue.poll();
			stack.push(tmp);
			if (tmp.getLeft() != null) {
				queue.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				queue.offer(tmp.getRight());
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getData() + " ");
		}

	}
}
