package linkedList.singlyLinkedList;

import linkedList.LinkedListUtil;
import linkedList.Node;

public class ModularNode {

	public static void main(String[] args) {

		Node head = LinkedListUtil.createDummyLinkedList(19);
		System.out.println("Linked List \n" + LinkedListUtil.toString(head));
		Node m1 = findLastModularNodeFromFront(head, 3);
		System.out.println(" Modular Node from Begining : " + (m1 != null ? m1.getData() : m1));
		Node m2 = findModularNodeFromEnd(head, 3);
		System.out.println(" Modular Node from End is : " + (m2 != null ? m2.getData() : m2));
	}

	/*
	 * if listSize=19 and mod =3 then answer should be 18th node from the begining
	 */
	private static Node findLastModularNodeFromFront(Node head, int mod) {
		Node modularNode = null;
		int nodeNumber = 0;
		while (head != null) {
			if (++nodeNumber % mod == 0) {
				modularNode = head;
			}
			head = head.getNext();
		}

		return modularNode;
	}

	/*
	 * if listSize=19 and mod =3 then answer should be 16th node . Solution to this
	 * is same as finding the kth node from the end in a linked list
	 */
	private static Node findModularNodeFromEnd(Node head, int mod) {
		Node modularNode = head;
		while (mod-- > 0 && head != null) {
			head = head.getNext();
		}

		while (head != null) {
			modularNode = modularNode.getNext();
			head = head.getNext();
		}

		return modularNode;
	}
}
