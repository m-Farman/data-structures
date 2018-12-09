package tree;

import java.util.LinkedList;
import java.util.Queue;

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
}
