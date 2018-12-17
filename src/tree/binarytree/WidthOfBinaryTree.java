package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;
import tree.TreeUtil;

/*width of the tree is the max no of nodes at any level in the given tree */
public class WidthOfBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(8);
		int width = getWidth(root);
		System.out.println("Width of the tree is " + width);
		System.out.println("Width of the tree is not using recursion " + getWidthNonRecursive(root));
	}

	public static int getWidth(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int width = 1;
		int h = HeightOfBinaryTree.getHeight(root);
		for (int i = 1; i <= h; i++) {
			width = Math.max(width, getNodeCountAtdepth(root, i));
		}
		return width;
	}

	private static int getNodeCountAtdepth(TreeNode<Integer> root, int depth) {
		if (root == null) {
			return 0;
		}
		if (depth == 0) {
			return 1;
		}
		return getNodeCountAtdepth(root.getLeft(), depth - 1) + getNodeCountAtdepth(root.getRight(), depth - 1);
	}

	public static <E> int getWidthNonRecursive(TreeNode<E> root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode<E>> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		TreeNode<E> tmp;
		int max = Integer.MIN_VALUE, current = 0;
		while (!queue.isEmpty()) {
			tmp = queue.poll();
			if (tmp != null) {
				current++;
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
