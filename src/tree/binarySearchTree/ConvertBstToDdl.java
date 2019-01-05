package tree.binarySearchTree;

import linkedList.DoublyLinkedNode;
import tree.TreeNode;
import tree.TreeUtil;

public class ConvertBstToDdl {

	private static DoublyLinkedNode<Integer> prev = null;

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createBstFromInput(4, 7, 3, 5, 1, 19);
		DoublyLinkedNode<Integer> head = createDdl(root);
		while (head.getPrev() != null) {
			head = head.getPrev();
		}
		while (head != null) {
			System.out.println(head.getData());
			head = head.getNext();
		}

	}

	private static DoublyLinkedNode<Integer> createDdl(TreeNode<Integer> root) {

		if (root == null) {
			return null;
		}

		createDdl(root.getLeft());
		DoublyLinkedNode<Integer> head = new DoublyLinkedNode<Integer>();
		head.setData(root.getData());
		head.setPrev(prev);
		if (prev != null) {
			prev.setNext(head);
		}
		prev = head;
		createDdl(root.getRight());

		return head;
	}
}


/*output
1
3
4
5
7
19
 * */
