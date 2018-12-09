package tree;

import java.util.Stack;

public class InOrderTreeTraversal {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		System.out.println("InOrder Traversal Recursive is :");
		inOrderTraversalRecursive(root);
		System.out.println("\nInOrder Traversal Iterative is :");
		inOrderTraversalIterative(root);
		System.out.println("\nInOrder Traversal Iterative Simplified is :");
		inOrderTraversalRecursiveSimplified(root);

	}

	@SuppressWarnings("rawtypes")
	public static void inOrderTraversalRecursive(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrderTraversalRecursive(root.getLeft());
		System.out.print(root.getData() + " ");
		inOrderTraversalRecursive(root.getRight());
	}

	@SuppressWarnings("rawtypes")
	public static void inOrderTraversalIterative(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (root != null) {
			if (root.getLeft() != null) {
				while (root.getLeft() != null) {
					root = root.getLeft();
					stack.push(root);
				}
			} else {

				root = stack.pop();
				while (root.getRight() == null && !stack.isEmpty()) {
					System.out.print(root.getData() + " ");
					root = stack.pop();
				}

				if (root.getRight() != null) {
					System.out.print(root.getData() + " ");
					root = root.getRight();
					stack.push(root);
				}
				if (stack.isEmpty()) {
					System.out.print(root.getData() + " ");
					root = null;
				}
			}

		}
	}

	@SuppressWarnings("rawtypes")
	public static void inOrderTraversalRecursiveSimplified(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		boolean done = false;
		while (!done) {

			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else {
				if (stack.isEmpty()) {
					done = true;
				} else {
					root = stack.pop();
					System.out.print(root.getData() + " ");
					root = root.getRight();
				}

			}
		}

	}

}



/*output
 * 
InOrder Traversal Recursive is :
4 2 5 1 6 3 7 
InOrder Traversal Iterative is :
4 2 5 1 6 3 7 
InOrder Traversal Iterative Simplified is :
4 2 5 1 6 3 7 
 * */
 