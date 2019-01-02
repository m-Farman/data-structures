package tree.binarySearchTree;

import tree.TreeNode;
import tree.TreeUtil;

public class FindKthSmallestElementInBst {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createBstFromInput(1, 3, 6, 7, 8, 9, 12, 23, 56, 89);
		Integer data = findKthSmallest(root, 5);
		System.out.println(data);
		present = 0;
		TreeNode<Integer> root2 = TreeUtil.createBstFromInput(3, 6, 35, 7, 24, 2, 56, 5);
		System.out.println(findKthSmallest(root2, 3));
	}

	private static int present = 0;

	private static Integer findKthSmallest(TreeNode<Integer> root, int k) {

		if (root == null) {
			return null;
		}

		Integer left = findKthSmallest(root.getLeft(), k);
		if (left != null) {
			return left;
		}
		if (++present == k) {
			return root.getData();
		}

		return findKthSmallest(root.getRight(), k);
	}
}

/*output

8
5
 
 * */
 