package linkedList.singlyLinkedList;

import linkedList.LinkedListUtil;
import linkedList.Node;

public class ReorderList {

	public static void main(String[] args) {

		Node head = LinkedListUtil.createDummyLinkedList(19);
		System.out.println("Linked List \n" + LinkedListUtil.toString(head));
		Node m1 = reorderList(head);
		System.out.println(" Modular Node from End is : " + (m2 != null ? m2.getData() : m2));

	}

	private static Node reorderList(Node head, int n) {

		Node middle = findMiddleNode(head, n);

		return null;
	}

	private static Node findMiddleNode(Node head, int n) {
		if (head==null) {
			return null;
		}
		Node slowPtr = head, fastPtr = head.getNext();
		while (fastPtr != null && fastPtr.getNext()!=null) {
			slowPtr=slowPtr.getNext();
			fastPtr=fastPtr.getNext().getNext();
		}

		return null;
	}
}
