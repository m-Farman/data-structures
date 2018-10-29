package LinkedList.SinglyLinkedList;

import java.util.Objects;

import LinkedList.LinkedListUtil;
import LinkedList.Node;

public class ReverseBlockOfKNodesInList {

	public static void main(String[] args) {
		Node head = LinkedListUtil.createDummyLinkedList(10);
		System.out.println("Before Reversing\n" + LinkedListUtil.toString(head));
		head = reverseKNode(head, 4);
		System.out.println("After Reversing\n" + LinkedListUtil.toString(head));
	}

	private static Node reverseKNode(Node head, int k) {

		int reverseSize = k;
		Node current = head, prev = null, subPrev = null, link = null, prevCurrent = head;
		while (current != null) {
			reverseSize = k;
			prev = null;
			while (current != null && reverseSize >= 1) {
				Node next = current.getNext();
				current.setNext(prev);
				prev = current;
				current = next;
				reverseSize--;
			}

			if (subPrev != null) {
				subPrev.setNext(prev);
			} else {
				head = prev;
			}
			subPrev = prevCurrent;
			prevCurrent = current;
		}

		return head;
	}

}
