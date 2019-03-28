package tree.binarytree;

import java.util.HashSet;
import java.util.Set;

import tree.TreeNode;
import tree.TreeUtil;

public class FindAllNodeDistanceKFromLeaf {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(12);
		Set<Integer> result = new HashSet<>();
		find(root, 2, result);
		System.out.println("Nodes are : " + result);

		result = new HashSet<>();
		find(root, 1, result);
		System.out.println("Nodes are : " + result);
	}

	private static int find(TreeNode<Integer> root, int k, Set<Integer> result) {

		if (root == null) {
			return -1;
		}

		if (root.getLeft() == null && root.getRight() == null) {
			return 1;
		}
		int left = find(root.getLeft(), k, result);
		if (left == k)
			result.add(root.getData());

		int right = find(root.getRight(), k, result);
		if (right == k)
			result.add(root.getData());

		return left != -1 && right != -1 ? Math.min(left, right) + 1 : (left == -1 ? right : left) + 1;

	}
}


/*output
 * 
Nodes are : [1, 2, 3]
Nodes are : [3, 4, 5, 6]
 * */
