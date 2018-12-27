package tree.binarySearchTree;

import tree.TreeNode;
import tree.TreeUtil;

public class FindAnElementInTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createBstFromInput(4, 7, 3, 5);

		System.out.println(isElementPresentInBST(root, 3));
		System.out.println(isElementPresentInBST(root, 19));
		System.out.println(isElementPresentInBST(root, 4));
		System.out.println("----------------------------------------\nNon Recursive way");
		System.out.println(isElementPresentInBst2(root, 3));
		System.out.println(isElementPresentInBst2(root, 19));
		System.out.println(isElementPresentInBst2(root, 4));
	}

	private static boolean isElementPresentInBST(TreeNode<Integer> root, int node) {

		if (root == null) {
			return false;
		}

		if (root.getData() > node) {
			return isElementPresentInBST(root.getLeft(), node);
		} else if (root.getData() < node) {
			return isElementPresentInBST(root.getRight(), node);
		}

		return true;
	}

	private static boolean isElementPresentInBst2(TreeNode<Integer> root, int node) {

		if (root == null) {
			return false;
		}

		while (root != null) {

			if (root.getData() == node) {
				return true;
			}
			if (root.getData() > node) {
				root = root.getLeft();
			} else if (root.getData() < node) {
				root = root.getRight();
			}

		}

		return false;
	}
}


/*output
 * 
true
false
true
----------------------------------------
Non Recursive way
true
false
true
 * */
