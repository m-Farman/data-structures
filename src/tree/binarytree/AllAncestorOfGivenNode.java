package tree.binarytree;

import java.util.ArrayList;

import tree.TreeNode;
import tree.TreeUtil;

public class AllAncestorOfGivenNode {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		ArrayList<Integer> arrayList = new ArrayList<>();
		System.out.println("Parent to node path : ");
		getAllAncestors(root, 7, arrayList);
		System.out.println("Node ancestors ");
		getAllAncestor(root, 7);
	}

	private static void getAllAncestors(TreeNode<Integer> root, int node, ArrayList<Integer> path) {

		if (root == null) {
			return;
		}
		path.add(root.getData());
		if (root.getData() == node) {
			System.out.println(path);
			return;
		}
		getAllAncestors(root.getLeft(), node, path);
		getAllAncestors(root.getRight(), node, path);
		path.remove(root.getData());
	}

	private static boolean getAllAncestor(TreeNode<Integer> root, int node) {

		if (root == null) {
			return false;
		}
		if ((root.getLeft() != null && (Integer) root.getLeft().getData() == node)
				|| (root.getRight() != null && (Integer) root.getRight().getData() == node)
				|| getAllAncestor(root.getLeft(), node) || getAllAncestor(root.getRight(), node)) {
			System.out.print(root.getData() + " ");
			return true;
		}
		return false;
	}
}

/*
output
Parent to node path : 
[1, 3, 7]
Node ancestors 
3 1 
*/
