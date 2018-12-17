package tree.binarytree;

import tree.TreeNode;
import tree.TreeUtil;

public class DiameterOfBinaryTree {

	private static int diameter = Integer.MIN_VALUE;

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(8);
		int dia = getDiameter(root);
		System.out.println(dia);
		System.out.println("Global diameter before " + diameter);
		getDiameterOpimised(root);
		System.out.println("Global diameter after " + diameter);
		System.out.println("OpimisedNoGlobalVariable " + getDiameterOpimisedNoGlobalVariable(root, new Height(0)));
	}

	public static int getDiameter(TreeNode<Integer> root) {

		if (root == null) {
			return 0;
		}
		int lHeight = getHeight(root.getLeft());
		int rHeight = getHeight(root.getRight());
		int ldiameter = getDiameter(root.getLeft());
		int rdiameter = getDiameter(root.getRight());

		return Math.max(Math.max(ldiameter, rdiameter), lHeight + rHeight + 1);
	}

	private static int getHeight(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
	}

	private static int getDiameterOpimised(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}

		int left = getDiameterOpimised(root.getLeft());
		int right = getDiameterOpimised(root.getRight());
		diameter = Math.max(left + right - 1, diameter);

		return left + right + 1;
	}

	private static int getDiameterOpimisedNoGlobalVariable(TreeNode<Integer> root, Height h) {
		if (root == null) {
			return 0;
		}
		Height hl = new Height(0);
		Height hr = new Height(0);
		int left = getDiameterOpimisedNoGlobalVariable(root.getLeft(), hl);
		int right = getDiameterOpimisedNoGlobalVariable(root.getRight(), hr);
		h.setHeight(Math.max(hl.getHeight(), hr.getHeight()) + 1);

		return Math.max(Math.max(left, right), hl.getHeight() + hr.getHeight() + 1);
	}
}

class Height {
	private int height;

	public Height(int h) {
		this.height = h;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}

/*output
6
Global diameter before -2147483648
Global diameter after 6
OpimisedNoGlobalVariable 6
 * */
