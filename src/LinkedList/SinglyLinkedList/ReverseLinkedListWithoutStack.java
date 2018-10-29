package LinkedList.SinglyLinkedList;

import LinkedList.LinkedListUtil;
import LinkedList.Node;

public class ReverseLinkedListWithoutStack {

	public static void main(String[] args) {
		Node head = LinkedListUtil.createDummyLinkedList(10);
		System.out.println("Before Reversing\n" + LinkedListUtil.toString(head));
		head = reverseList(head);
		System.out.println("After Reversing\n" + LinkedListUtil.toString(head));
	}

	private static Node reverseList(Node head) {

		Node current = head, prev = null;
		while (current != null) {
			Node next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
}

/*output
 *
	Before Reversing
	[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
	After Reversing
	[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
 * 
 * */
