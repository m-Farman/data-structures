package tree.binarytree;

import java.util.TreeMap;

import tree.TreeNode;
import tree.TreeUtil;

public class VerticalSumOfBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		TreeMap<Integer, Integer> sum = new TreeMap<>();
		calcVerticalSum(root, sum, 0);
		for (Integer key : sum.keySet()) {
			System.out.println(" Verticla : " + key + " sum : " + sum.get(key));
		}
	}

	private static void calcVerticalSum(TreeNode<Integer> root, TreeMap<Integer, Integer> sum, int vertical) {

		if (root == null)
			return;

		int s = 0;
		if (sum.containsKey(vertical)) {
			s = sum.get(vertical);
		}
		s += root.getData();
		sum.put(vertical, s);
		calcVerticalSum(root.getLeft(), sum, vertical - 1);
		calcVerticalSum(root.getRight(), sum, vertical + 1);
	}
}
