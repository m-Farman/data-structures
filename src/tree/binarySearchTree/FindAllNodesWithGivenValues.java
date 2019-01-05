package tree.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;
import tree.TreeUtil;

public class FindAllNodesWithGivenValues {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createBstFromInput(1, 3, 6, 7, 8, 9, 12, 23, 56, 89);
		List<Integer> nodes = new ArrayList<>();
		findNodes(root, 2, 25, nodes);
		System.out.println("Nodes between given range are : " + nodes);
	}

	private static void findNodes(TreeNode<Integer> root, int start, int end, List<Integer> nodes) {

		if (root == null) {
			return;
		}

		if (root.getData() > start) {
			findNodes(root.getLeft(), start, end, nodes);
		}

		if (root.getData() >= start && root.getData() <= end) {
			nodes.add(root.getData());
		}
		if (root.getData() < end) {
			findNodes(root.getRight(), start, end, nodes);
		}
	}
}

/*output
 * 
Nodes between given range are : [3, 6, 7, 8, 9, 12, 23]
 * */
