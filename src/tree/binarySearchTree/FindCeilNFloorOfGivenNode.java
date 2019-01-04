package tree.binarySearchTree;

import tree.TreeNode;
import tree.TreeUtil;

public class FindCeilNFloorOfGivenNode {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createBstFromInput(1, 3, 6, 7, 8, 9, 12, 23, 56, 89);
		Integer data = findFloor(root, 5, 0);
		System.out.println(data);
		System.out.println(findCeil(root, 5, 0));

	}

	private static Integer findFloor(TreeNode<Integer> root, int key, int previous) {
		if (root == null) {
			return null;
		}

		if (root.getData() < key) {
			Integer result = findFloor(root.getRight(), key, root.getData());
			if (result != null) {
				return result;
			}
		}

		if (root.getData() == key) {
			return root.getData();
		}
		if (root.getData() > key) {
			return previous;
		}
		previous = root.getData();

		return findFloor(root.getLeft(), key, root.getData());
	}

	private static Integer findCeil(TreeNode<Integer> root, int key, int previous) {
		if (root == null) {
			return null;
		}

		if (root.getData() > key) {
			Integer result = findFloor(root.getLeft(), key, root.getData());
			if (result != null) {
				return result;
			}
		}

		if (root.getData() == key) {
			return root.getData();
		}
		if (root.getData() < key) {
			return previous;
		}
		previous = root.getData();

		return findFloor(root.getRight(), key, root.getData());
	}
}
