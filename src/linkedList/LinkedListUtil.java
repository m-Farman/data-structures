package linkedList;

import java.util.concurrent.ThreadLocalRandom;

public class LinkedListUtil {

	public static String toString(Node head) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		boolean first = true;
		while (head != null) {
			if (first) {
				first = false;
			} else {
				sb.append(", ");
			}
			sb.append(head.getData());
			head = head.getNext();
		}
		sb.append("]");
		return sb.toString();
	}

	public static Node createDummyLinkedList(int size) {

		Node head = null, tmp = null;
		for (int i = 1; i <= size; i++) {
			Node node = new Node(i, null);
			if (i == 1) {
				head = tmp = node;
			} else {
				tmp.setNext(node);
				tmp = tmp.getNext();
			}
		}

		return head;
	}

	public static Node createRandomLinkedList(int size, int dataMaxValue) {
		dataMaxValue = dataMaxValue == 0 ? size : dataMaxValue;
		Node head = null, tmp = null;
		for (int i = 1; i <= size; i++) {
			Node node = new Node(ThreadLocalRandom.current().nextInt(1, dataMaxValue), null);
			if (i == 1) {
				head = tmp = node;
			} else {
				tmp.setNext(node);
				tmp = tmp.getNext();
			}
		}

		return head;
	}

	public static Node createDuplicateDataLinkedList(int size) {

		Node head = createDummyLinkedList(size);
		Node tmp = head;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
		}
		tmp.setNext(createDummyLinkedList(size));

		return head;
	}

	public static Node createCircularLinkedList(int size) {

		Node head = null, tmp = null;
		for (int i = 1; i <= size; i++) {
			Node node = new Node(i, null);
			if (i == 1) {
				head = tmp = node;
			} else {
				tmp.setNext(node);
				tmp = tmp.getNext();
			}
		}
		tmp.setNext(head);

		return head;
	}

	public static Node findMiddleNode(Node head) {
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
