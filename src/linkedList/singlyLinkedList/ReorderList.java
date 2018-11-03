package linkedList.singlyLinkedList;

import linkedList.LinkedListUtil;
import linkedList.Node;

public class ReorderList {

	public static void main(String[] args) {

		Node head = LinkedListUtil.createDummyLinkedList(18);
		System.out.println("Linked List \n" + LinkedListUtil.toString(head));
		System.out.println("Linked After Rearraging \n" + LinkedListUtil.toString(reorderList(head)));
		head = LinkedListUtil.createDummyLinkedList(17);
		System.out.println("Linked List \n" + LinkedListUtil.toString(head));
		System.out.println("Linked After Rearraging \n" + LinkedListUtil.toString(reorderList(head)));

	}

	private static Node reorderList(Node head) {

		Node firstHalf = head;
		Node middle = findMiddleNode(head);
		Node secondHalf = reversList(middle.getNext());
		middle.setNext(null);
		while (firstHalf != middle && secondHalf != null) {
			Node tmp = firstHalf.getNext();
			firstHalf.setNext(secondHalf);
			secondHalf = secondHalf.getNext();
			firstHalf.getNext().setNext(tmp);
			firstHalf = tmp;
		}

		return head;
	}

	private static Node reversList(Node head) {

		Node prev = null, current = head, next = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}

		return prev;
	}

	private static Node findMiddleNode(Node head) {
		if (head == null) {
			return null;
		}
		Node slowPtr = head, fastPtr = head.getNext();
		while (fastPtr != null && fastPtr.getNext() != null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}

		return slowPtr;
	}
}

/*
 * output
Linked List 
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]
Linked After Rearraging 
[1, 18, 2, 17, 3, 16, 4, 15, 5, 14, 6, 13, 7, 12, 8, 11, 9]
Linked List 
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17]
Linked After Rearraging 
[1, 17, 2, 16, 3, 15, 4, 14, 5, 13, 6, 12, 7, 11, 8, 10, 9]
 
 */
