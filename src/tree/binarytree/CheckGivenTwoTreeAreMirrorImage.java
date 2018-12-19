package tree.binarytree;

import tree.LevelOrderTreeTraversal;
import tree.TreeNode;
import tree.TreeUtil;

public class CheckGivenTwoTreeAreMirrorImage {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		TreeNode<Integer> root2 = TreeUtil.createTreeOfSize(7);
		LevelOrderTreeTraversal.printLevelWise(root);
		LevelOrderTreeTraversal.printLevelWise(root2);
		boolean isMirror = areMirrorImage(root, root2);
		System.out.println("Is Mirror Image : " + isMirror);
		root2 = MirrorOfABinaryTree.getMirrorImage(root2);
		LevelOrderTreeTraversal.printLevelWise(root);
		LevelOrderTreeTraversal.printLevelWise(root2);
		System.out.println("Is Mirror Image : " + areMirrorImage(root, root2));
	}

	private static boolean areMirrorImage(TreeNode<Integer> root1, TreeNode<Integer> root2) {

		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.getData() != root2.getData()) {
			return false;
		}

		return areMirrorImage(root1.getLeft(), root2.getRight()) && areMirrorImage(root1.getRight(), root2.getLeft());
	}
}


/*output
 * 
Element at level 0  are [1]
Element at level 1  are [2, 3]
Element at level 2  are [4, 5, 6, 7]
Element at level 0  are [1]
Element at level 1  are [2, 3]
Element at level 2  are [4, 5, 6, 7]
Is Mirror Image : false
Element at level 0  are [1]
Element at level 1  are [2, 3]
Element at level 2  are [4, 5, 6, 7]
Element at level 0  are [1]
Element at level 1  are [3, 2]
Element at level 2  are [7, 6, 5, 4]
Is Mirror Image : true
 * 
 * */
