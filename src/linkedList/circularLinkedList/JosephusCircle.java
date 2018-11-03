package linkedList.circularLinkedList;

import linkedList.LinkedListUtil;
import linkedList.Node;

public class JosephusCircle {

	public static void main(String[] args) {
		Node head = LinkedListUtil.createCircularLinkedList(10);

		int winner = findLastOneRemaining(head, 10, 3);
		System.out.println(" Last one remaining is : " + winner);
	}

	private static int findLastOneRemaining(Node head, int n, int m) {

		Node last = head;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m - 1; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				last = last.getNext();
			}
			last.setNext(last.getNext().getNext());
		}

		return last.getData();
	}
}

/*
 * output
 *  Last one remaining is : 4
 */
