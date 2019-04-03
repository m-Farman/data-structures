package tree.binarytree;

import tree.TreeNode;
import tree.TreeUtil;

/*https://stackoverflow.com/questions/52787803/given-a-node-how-long-will-it-take-to-burn-the-whole-binary-tree

*the solution does not consider only burning the leave node rather than you can burn and node which will be the source 
*and output the time taken to burn down the whole tree. 
*/
public class TimeTakenToBurnTree {

	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {

		TreeNode<Integer> root = TreeUtil.createTreeOfSize(12);
		int output = find(root, 9, 0);
		System.out.println("Time taken to burn the whole tree is " + max);

	}

	private static int find(TreeNode<Integer> root, int source, int sourceDepth) {

		if (root == null) {
			return -1;
		}

		if (root.getData() == source) {
			sourceDepth = getDepth(root);
			return 0;
		}

		int left = find(root.getLeft(), source, sourceDepth);
		if (left != -1) {
			int rightDepth = getDepth(root.getRight()) + 1;
			max = Math.max(rightDepth + left + 1, sourceDepth);
			return left + 1;
		}

		int right = find(root.getRight(), source, sourceDepth);
		if (right != -1) {
			int leftDepth = getDepth(root.getRight()) + 1;
			max = Math.max(leftDepth + right + 1, sourceDepth);
			return right + 1;
		}

		return -1;
	}

	private static int getDepth(TreeNode<Integer> root) {

		if (root == null) {
			return -1;
		}

		return Math.max(getDepth(root.getLeft()), getDepth(root.getRight())) + 1;
	}
}

/*
 * output Time taken to burn the whole tree is 6
 */
