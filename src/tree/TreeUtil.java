package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class TreeUtil {

	/*
	 * if n=7 output will be below tree structure 
	 * 
	 * 
 							  tree
						      ----
						       1    <-- root
						     /   \
						    2      3  
						  /   \  /   \
						 4     5 6    7    <-- leaves
	 */

	public static TreeNode<Integer> createTreeOfSize(int n) {
		int i = 1;
		TreeNode<Integer> root = new TreeNode<>(i++, null, null);
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);

		while (i <= n && !q.isEmpty()) {
			TreeNode<Integer> left = new TreeNode<>(i, null, null);
			TreeNode<Integer> node = q.poll();
			node.setLeft(left);
			if (i == n) {
				break;
			}
			i++;
			TreeNode<Integer> right = new TreeNode<>(i++, null, null);
			node.setRight(right);
			q.offer(left);
			q.offer(right);
		}
		return root;
	}
	
	public static <E> String toString(List<TreeNode<E>> list) {
		return list.stream().map(n -> String.valueOf(n.getData())).collect(Collectors.joining(", ", "[", "]"));
	}

	public static TreeNode<Integer> createRandomBST(int size, int maxValue, int minValue) {
		TreeNode<Integer> root = null;
		for (int i = 1; i <= size; i++) {
			int data = ThreadLocalRandom.current().nextInt(minValue, maxValue);
			TreeNode<Integer> node = new TreeNode<Integer>(data, null, null);
			if (i == 1) {
				root = node;
				continue;
			}
			insertIntoBST(root, node);
		}

		return root;
	}

	public static TreeNode<Integer> createBstFromInput(Integer... nodes) {
		if (nodes.length == 0) {
			return null;
		}
		TreeNode<Integer> root = new TreeNode<Integer>(nodes[0], null, null);
		for (int i = 1; i < nodes.length; i++) {
			TreeNode<Integer> node = new TreeNode<Integer>(nodes[i], null, null);
			insertIntoBST(root, node);
		}

		return root;
	}

	private static TreeNode<Integer> insertIntoBST(TreeNode<Integer> root, TreeNode<Integer> node) {
		if (root == null) {
			root = node;
			return root;
		} else {
			if (node.getData() < root.getData()) {
				root.setLeft(insertIntoBST(root.getLeft(), node));
			} else if (node.getData() > root.getData()) {
				root.setRight(insertIntoBST(root.getRight(), node));
			}
		}
		return root;
	}

}
