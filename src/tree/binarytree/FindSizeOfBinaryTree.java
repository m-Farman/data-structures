package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;
import tree.TreeUtil;

public class FindSizeOfBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		int size = findSize(root);
		System.out.println("Size of the tree is : " + size);
		System.out.println("Size of the tree using NonRecursive is : " + findSizeNonRecursive(root));
	}

	private static int findSize(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		return 1 + findSize(root.getLeft()) + findSize(root.getRight());
	}

	private static int findSizeNonRecursive(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while (!queue.isEmpty()) {
			TreeNode<Integer> tmp = queue.poll();
			++count;
			if (tmp.getLeft() != null) {
				queue.add(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				queue.add(tmp.getRight());
			}
		}
		return count;
	}
}


/*output
 * 
Size of the tree is : 7
Size of the tree using NonRecursive is : 7
 * */
 