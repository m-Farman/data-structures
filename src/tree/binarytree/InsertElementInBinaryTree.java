package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.LevelOrderTreeTraversal;
import tree.TreeNode;
import tree.TreeUtil;

public class InsertElementInBinaryTree {
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		LevelOrderTreeTraversal.printLevelWise(root);
		TreeNode<Integer> node = insertInBinaryTree(root, 90);
		LevelOrderTreeTraversal.printLevelWise(node);
	}

	private static TreeNode<Integer> insertInBinaryTree(TreeNode<Integer> root, int data) {
		if (root == null) {
			return new TreeNode<Integer>(data, null, null);
		} 
		if (root.getData() < data) {
			root.setLeft(insertInBinaryTree(root.getLeft(), data));
		} else if (root.getData() > data) {
			root.setRight(insertInBinaryTree(root.getRight(), data));
		}

		return root;
	}

	private static TreeNode<Integer> insertInBinaryTreeNonRecursive(TreeNode<Integer> root, int data) {
		if (root == null) {
			return new TreeNode<Integer>(data, null, null);
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode<Integer> tmp = queue.poll();
			if (tmp.getLeft() == null) {
				tmp.setLeft(new TreeNode<Integer>(data, null, null));
				break;
			} else {
				queue.offer(tmp.getLeft());
			}
			if (tmp.getRight() == null) {
				tmp.setRight(new TreeNode<Integer>(data, null, null));
				break;
			} else {
				queue.offer(tmp.getRight());
			}
		}
		return root;
	}
}


/*output
 * 
Element at level 0  are [1]
Element at level 1  are [2, 3]
Element at level 2  are [4, 5, 6, 7]
Element at level 0  are [1]
Element at level 1  are [2, 3]
Element at level 2  are [4, 5, 6, 7]
Element at level 3  are [90]
 * */
