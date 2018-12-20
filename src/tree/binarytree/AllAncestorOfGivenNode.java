package tree.binarytree;

import java.util.ArrayList;

import tree.TreeNode;
import tree.TreeUtil;

public class AllAncestorOfGivenNode {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		ArrayList<Integer> arrayList = new ArrayList<>();
		getAllAncestors(root, 7, arrayList);
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

}
