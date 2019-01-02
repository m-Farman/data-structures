package tree.binarySearchTree;

import tree.InOrderTreeTraversal;
import tree.TreeNode;

public class CreateBalacedBstFromSortedArray {

	public static void main(String[] args) {
		int[] sorted = { 1, 3, 6, 7, 8, 9, 12, 23, 56, 89 };
		TreeNode<Integer> root = createBalancedBst(sorted, 0, 9);
		System.out.println(root);
		InOrderTreeTraversal.inOrderTraversalIterative(root);
	}

	private static TreeNode<Integer> createBalancedBst(int[] sorted, int start, int end) {

		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode<Integer> leftChild = createBalancedBst(sorted, start, mid - 1);
		TreeNode<Integer> rightChild = createBalancedBst(sorted, mid + 1, end);
		TreeNode<Integer> node = new TreeNode<Integer>(sorted[mid], leftChild, rightChild);

		return node;
	}
}
