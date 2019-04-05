package tree.binarySearchTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import tree.InOrderTreeTraversal;
import tree.TreeNode;

public class ConstructBSTGivenLevelOrder {

	public static void main(String[] args) {

		int arr[] = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
		TreeNode<Integer> root = contructBst(arr);
		InOrderTreeTraversal.inOrderTraversalIterative(root);
	}

	private static TreeNode<Integer> contructBst(int[] arr) {

		if (arr == null || arr.length == 0) {
			return null;
		}
		int index = 0;
		HashMap<TreeNode<Integer>, MaxMinOfNode> processedNode = new HashMap<>();
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		TreeNode<Integer> node = new TreeNode<Integer>(arr[index++], null, null);
		queue.offer(node);
		processedNode.put(node, new MaxMinOfNode(Integer.MIN_VALUE, Integer.MAX_VALUE));

		TreeNode<Integer> root = node;

		while (index < arr.length) {
			TreeNode<Integer> tmp = queue.poll();
			MaxMinOfNode minMax = processedNode.get(tmp);
			if (index < arr.length && (arr[index] < tmp.getData() && arr[index] > minMax.min)) {
				node = new TreeNode<Integer>(arr[index++], null, null);
				queue.offer(node);
				processedNode.put(node, new MaxMinOfNode(minMax.min, tmp.getData()));
				tmp.setLeft(node);
			}

			if (index < arr.length && (arr[index] > tmp.getData() && arr[index] < minMax.max)) {
				node = new TreeNode<Integer>(arr[index++], null, null);
				queue.offer(node);
				processedNode.put(node, new MaxMinOfNode(tmp.getData(), minMax.max));
				tmp.setRight(node);
			}
		}

		return root;
	}
}

class MaxMinOfNode {

	int min;
	int max;

	public MaxMinOfNode(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

}



/*output
 * 1 3 4 5 6 7 8 10 12 
 * */
