package tree.binarytree;

import java.util.ArrayList;

import tree.TreeNode;
import tree.TreeUtil;

public class LeastCommonAncestorOfTwoNodes {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		TreeNode<Integer> lca = getLCA(root, 4, 6);
		System.out.println("LCA is: " + lca.getData());

		System.out.println("-----Second way------");
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		getpathTill(root, 4, left);
		getpathTill(root, 6, right);
		System.out.println("One node path  " + left);
		System.out.println("Other node path  " + right);
		int n = 0;
		while (n < left.size() && n < right.size() && left.get(n).equals(right.get(n))) {
			n++;
		}
		System.out.println(left.get(n - 1));
	}

	private static boolean getpathTill(TreeNode<Integer> root, int i, ArrayList<Integer> path) {
		if (root == null)
			return false;
		path.add(root.getData());
		if (root.getData() == i) {
			return true;
		}
		if (getpathTill(root.getLeft(), i, path) || getpathTill(root.getRight(), i, path)) {
			return true;
		}
		path.remove(root.getData());

		return false;
	}

	private static TreeNode<Integer> getLCA(TreeNode<Integer> root, int i, int j) {
		if (root == null)
			return null;

		if (root.getData() == i || root.getData() == j) {
			return root;
		}

		TreeNode<Integer> left = getLCA(root.getLeft(), i, j);
		TreeNode<Integer> right = getLCA(root.getRight(), i, j);

		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

}


/*output
 * 
LCA is: 1
-----Second way------
One node path  [1, 2, 4]
Other node path  [1, 3, 6]
1
 * */
