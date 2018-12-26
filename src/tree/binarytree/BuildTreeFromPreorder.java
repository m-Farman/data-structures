package tree.binarytree;

import tree.LevelOrderTreeTraversal;
import tree.TreeNode;

/*tree has special property that either it can have 0 or 2 child only*/
public class BuildTreeFromPreorder {

	public static void main(String[] args) {
		String preorder = "ILILL";
		TreeNode<Character> root = buildTree(preorder, 0);
		LevelOrderTreeTraversal.printLevelWise(root);
	}

	private static TreeNode<Character> buildTree(String preorder, int position) {
		if (preorder == null) {
			return null;
		}

		if (preorder.length() <= position) {
			return null;
		}
		TreeNode<Character> node = new TreeNode<Character>(preorder.charAt(position), null, null);
		if (preorder.charAt(position) == 'L') {
			return node;
		}
		position += 1;
		node.setLeft(buildTree(preorder, position));
		position += 1;
		node.setRight(buildTree(preorder, position));
		return node;
	}

}
