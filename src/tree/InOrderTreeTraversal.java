package tree;

import java.util.Stack;

public class InOrderTreeTraversal {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		System.out.println("InOrder Traversion Recursive is :");
		inOrderTraversalRecursive(root);
		System.out.println("\nInOrder Traversion Iterative is :");
		inOrderTraversalIterative(root);
	}

	@SuppressWarnings("rawtypes")
	public static void inOrderTraversalRecursive(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.getData() + " ");
		inOrderTraversalRecursive(root.getLeft());
		inOrderTraversalRecursive(root.getRight());
	}

	@SuppressWarnings("rawtypes")
	public static void inOrderTraversalIterative(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (root != null ) {
			System.out.print(root.getData() + " ");
			if (root.getLeft() != null) {
				root = root.getLeft();
				stack.push(root);
			} else {
				if (!stack.isEmpty()) {
					root = stack.pop();
					while (root.getRight() == null && !stack.isEmpty()) {
						root = stack.pop();
					}
					root = root.getRight();
					if (root!=null) {
						stack.push(root);	
					}
				}
			}
		}

	}
}
