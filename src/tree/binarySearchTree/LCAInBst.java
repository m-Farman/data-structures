package tree.binarySearchTree;

import tree.TreeNode;
import tree.TreeUtil;

public class LCAInBst {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createBstFromInput(4, 7, 3, 5, 1, 19);
		System.out.println(" LCA of 1 and 5: " + getLCA(root, 1, 5));
		System.out.println(" LCA of 3 and 19: " + getLCA(root, 3, 19));
		System.out.println(" LCA of 4 and 5: " + getLCA(root, 4, 5));
		System.out.println(" LCA of 5 and 19: " + getLCA(root, 5, 19));
		System.out.println(" LCA of 1 and 3: " + getLCA(root, 1, 3));

	}

	private static Integer getLCA(TreeNode<Integer> root, int node1, int node2) {
		if (root == null) {
			return null;
		}

		if ((root.getData() > node1 && root.getData() < node2) || (root.getData() > node2 && root.getData() < node1)
				|| root.getData() == node1 || root.getData() == node2) {
			return root.getData();
		}

		if (root.getData() > node1 && root.getData() > node2) {
			return getLCA(root.getLeft(), node1, node2);
		} else {
			return getLCA(root.getRight(), node1, node2);
		}
	}
}

/*output
 *
 LCA of 1 and 5: 4
 LCA of 3 and 19: 4
 LCA of 4 and 5: 4
 LCA of 5 and 19: 7
 LCA of 1 and 3: 3

 * */
 