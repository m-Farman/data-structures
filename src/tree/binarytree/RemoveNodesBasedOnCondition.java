package tree.binarytree;

import tree.LevelOrderTreeTraversal;
import tree.TreeNode;
import tree.TreeUtil;

public class RemoveNodesBasedOnCondition {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		LevelOrderTreeTraversal.printLevelWise(root);
		TreeNode<Integer> rootLeavesRemoved = removeLeaves(root);
		System.out.println("After removing leaves");
		LevelOrderTreeTraversal.printLevelWise(rootLeavesRemoved);

		
		System.out.println("Half Nodes starts");
		root = TreeUtil.createBstFromInput(4, 7, 3, 5, 1, 19);
		LevelOrderTreeTraversal.printLevelWise(root);
		TreeNode<Integer> rootHalfNodesRemoved = removeHaldNodes(root);
		System.out.println("After Half Nodes");
		LevelOrderTreeTraversal.printLevelWise(rootHalfNodesRemoved);
	}

	private static TreeNode<Integer> removeHaldNodes(TreeNode<Integer> root) {

		if (root == null) {
			return null;
		}

		root.setLeft(removeHaldNodes(root.getLeft()));
		root.setRight(removeHaldNodes(root.getRight()));

		if (root.getRight() == null && root.getLeft() == null) {
			return root;
		}
		if (root.getLeft() == null) {
			return root.getRight();
		}
		if (root.getRight() == null) {
			return root.getLeft();
		}

		return root;
	}

	private static TreeNode<Integer> removeLeaves(TreeNode<Integer> root) {

		if (root == null) {
			return null;
		}

		if (root.getRight() == null && root.getLeft() == null) {
			return null;
		}

		root.setLeft(removeLeaves(root.getLeft()));
		root.setRight(removeLeaves(root.getRight()));
		return root;
	}
}

/*output
 * 
Element at level 0  are [1]
Element at level 1  are [2, 3]
Element at level 2  are [4, 5, 6, 7]
After removing leaves
Element at level 0  are [1]
Element at level 1  are [2, 3]
Half Nodes starts
Element at level 0  are [4]
Element at level 1  are [3, 7]
Element at level 2  are [1, 5, 19]
After Half Nodes
Element at level 0  are [4]
Element at level 1  are [1, 7]
Element at level 2  are [5, 19]
 * 
 * */
