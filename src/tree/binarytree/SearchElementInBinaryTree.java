package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;
import tree.TreeUtil;

public class SearchElementInBinaryTree {
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		System.out.println("Does 9 Exits in tree : " + searchElementFomTree(root, 9));
		System.out.println("Does 5 Exits in tree : " + searchElementFomTree(root, 5));
		System.out.println("Does 9 Exits in tree NonRecursive : " + searchElementFomTreeNonRecursive(root, 9));
		System.out.println("Does 5 Exits in tree NonRecursive : " + searchElementFomTreeNonRecursive(root, 5));
	}

	private static boolean searchElementFomTree(TreeNode<Integer> root, Integer search) {
		if (root == null) {
			return false;
		}
		if (root.getData().equals(search)) {
			return true;
		}

		return searchElementFomTree(root.getLeft(), search) || searchElementFomTree(root.getRight(), search);
	}

	private static boolean searchElementFomTreeNonRecursive(TreeNode<Integer> root, Integer search) {
		if (root == null) {
			return false;
		}

		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode<Integer> tmp = queue.poll();
			if (tmp.getData().equals(search)) {
				return true;
			}
			if (tmp.getLeft() != null) {
				queue.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				queue.offer(tmp.getRight());
			}
		}
		return false;
	}
}

/*
 * output 

Does 9 Exits in tree : false
Does 5 Exits in tree : true
Does 9 Exits in tree NonRecursive : false
Does 5 Exits in tree NonRecursive : true

 * 
 */
