package tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import tree.TreeNode;
import tree.TreeUtil;

public class PrintNodeAsTheyBecomeLeaves {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		TreeMap<Integer, List<Integer>> nodes = new TreeMap<>();
		getChildWeight(root, nodes);
		nodes.keySet().stream().forEach(key -> System.out.println("Leaves " + key + " " + nodes.get(key)));
	}

	private static int getChildWeight(TreeNode<Integer> root, Map<Integer, List<Integer>> nodes) {

		if (root == null) {
			return 0;
		}

		int left = getChildWeight(root.getLeft(), nodes);
		int right = getChildWeight(root.getRight(), nodes);

		int current = Math.max(left, right) + 1;
		if (!nodes.containsKey(current)) {
			nodes.put(current, new ArrayList<>());
		}
		nodes.get(current).add(root.getData());
		return current;
	}
}


/*output 
 * 
 * 
Leaves 1 [4, 5, 6, 7]
Leaves 2 [2, 3]
Leaves 3 [1]
 * */
