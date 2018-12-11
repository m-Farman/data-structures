package tree;

public class PostOrderTreeTraversal {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		System.out.println("postOrder Traversal Recursive is :");
		postOrderTraversalRecursive(root);
		System.out.println("\npostOrder Traversal Iterative is :");
		postOrderTraversalIterative(root);
		// System.out.println("\npostOrder Traversal Iterative Simplified is :");
		// postOrderTraversalRecursiveSimplified(root);

	}

	private static void postOrderTraversalRecursive(TreeNode root) {
		if (root == null) {
			return;
		}
		postOrderTraversalRecursive(root.getLeft());
		postOrderTraversalRecursive(root.getRight());
		System.out.print(root.getData() + " ");
	}

	private static void postOrderTraversalIterative(TreeNode root) {

	}

}
