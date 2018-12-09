package tree;

import java.util.Stack;

public class PreOrderTreeTraversal {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		System.out.println("preOrder Traversal Recursive is :");
		preOrderTraversalRecursive(root);
		System.out.println("\npreOrder Traversal Iterative is :");
		preOrderTraversalIterative(root);
		System.out.println("\npreOrder Traversal Iterative Simplified is :");
		preOrderTraversalIterativeSimplified(root);

	}

	@SuppressWarnings("rawtypes")
	public static void preOrderTraversalRecursive(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.getData() + " ");
		preOrderTraversalRecursive(root.getLeft());
		preOrderTraversalRecursive(root.getRight());
	}

	@SuppressWarnings("rawtypes")
	public static void preOrderTraversalIterative(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (root != null) {
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
					if (root != null) {
						stack.push(root);
					}
				}
			}
		}
	}

	public static void preOrderTraversalIterativeSimplified(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.getData() + " ");
			if (root.getRight() != null) {
				stack.push(root.getRight());
			}
			if (root.getLeft() != null) {
				stack.push(root.getLeft());
			}
		}
	}
}

/*output
 * 
	preOrder Traversal Recursive is :
	1 2 4 5 3 6 7 
	preOrder Traversal Iterative is :
	1 2 4 5 3 6 7 
	preOrder Traversal Iterative Simplified is :
	1 2 4 5 3 6 7 
 * */
