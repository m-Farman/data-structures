package tree.binarytree;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;
import tree.TreeUtil;

public class FindAllNodesAtDistanceKFromGivenNode {

	public static void main(String[] args) {

		TreeNode<Integer> root = TreeUtil.createTreeOfSize(12);

		ArrayList<Integer> result = new ArrayList<>();
		find(root, 8, 3, result);
		System.out.println("Source 8 distance 3 : " + result);

		result = new ArrayList<>();
		find(root, 8, 2, result);
		System.out.println("Source 8 distance 2 : " + result);

		result = new ArrayList<>();
		find(root, 8, 4, result);
		System.out.println("Source 8 distance 4 : " + result);

		result = new ArrayList<>();
		find(root, 5, 3, result);
		System.out.println("Source 5 distance 3 : " + result);

	}

	private static int find(TreeNode<Integer> root, int source, int k, ArrayList<Integer> result) {

		if (root == null) {
			return -1;
		}

		if (root.getData() == source) {
			getChildNodeAtDistanceK(root, k, result);
			return 1;
		}

		int left = find(root.getLeft(), source, k, result);

		if (left != -1) {
			if (left == k) {
				result.add(root.getData());
			} else
				getChildNodeAtDistanceK(root.getRight(), k - left - 1, result);
			return left + 1;
		}

		int right = find(root.getRight(), source, k, result);
		if (right != -1) {
			if (right == k) {
				result.add(root.getData());
			} else
				getChildNodeAtDistanceK(root.getLeft(), k - right - 1, result);
			return right + 1;
		}

		return -1;

	}

	public static void getChildNodeAtDistanceK(TreeNode<Integer> root, int distance, List<Integer> result) {

		if (root == null) {
			return;
		}

		if (distance == 0) {
			result.add(root.getData());
		}

		getChildNodeAtDistanceK(root.getLeft(), distance - 1, result);
		getChildNodeAtDistanceK(root.getRight(), distance - 1, result);

	}

}

/*output
 * 
Source 8 distance 3 : [5, 1]
Source 8 distance 2 : [9, 2]
Source 8 distance 4 : [10, 11, 3]
Source 5 distance 3 : [8, 9, 3]

 * */
