package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTreeTraversal {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(7);
		System.out.println("Level Order Traversal is :");
		List<ArrayList<TreeNode<Integer>>> level = levelOrderTraversal(root);

		for (int i = 0; i < level.size(); i++) {
			System.out.println("Element at level " + i + "  are " + TreeUtil.toString(level.get(i)));
		}
	}

	private static <E> List<ArrayList<TreeNode<E>>> levelOrderTraversal(TreeNode<E> root) {
		if (root == null) {
			return null;
		}
		List<ArrayList<TreeNode<E>>> list = new ArrayList<>();
		Queue<TreeNode<E>> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		ArrayList<TreeNode<E>> level = new ArrayList<>();
		while (!queue.isEmpty()) {
			TreeNode<E> tmp = queue.poll();
			if (tmp != null) {
				level.add(tmp);
				if (tmp.getLeft() != null)
					queue.offer(tmp.getLeft());
				if (tmp.getRight() != null)
					queue.offer(tmp.getRight());
			} else {
				list.add(level);
				level = new ArrayList<>();
				if (!queue.isEmpty()) {
					queue.offer(null);
				}
			}
		}

		return list;
	}
}


/*output
 * 
Level Order Traversal is :
Element at level 0  are [1]
Element at level 1  are [2, 3]
Element at level 2  are [4, 5, 6, 7]
*
 * */
 