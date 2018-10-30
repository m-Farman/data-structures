package linkedList.singlyLinkedList;

import linkedList.LinkedListUtil;
import linkedList.Node;

public class ReverseBlockOfKNodesUsingRecursion {

	public static void main(String[] args) {
		Node head = LinkedListUtil.createDummyLinkedList(10);
		System.out.println("Before Reversing\n" + LinkedListUtil.toString(head));
		head = reverseKNode(head, 4);
		System.out.println("After Reversing\n" + LinkedListUtil.toString(head));
	}

	private static Node reverseKNode(Node head, int k) {

		Node current = head, prev = null, next = null;
		int blockSize = k;
		while (current != null && blockSize > 0) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
			blockSize--;

		}
		if (next != null) {
			head.setNext(reverseKNode(next, k));
		}

		return prev;
	}
}

/*output
 *
	Before Reversing
	[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
	After Reversing
	[4, 3, 2, 1, 8, 7, 6, 5, 10, 9]

 * */
 