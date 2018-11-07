package linkedList.singlyLinkedList;

import linkedList.LinkedListUtil;
import linkedList.Node;

public class PartitionLinkedListGivenPivot {

	public static void main(String[] args) {
		Node head = LinkedListUtil.createRandomLinkedList(10, 50);
		System.out.println("Before Patitioning \n" + LinkedListUtil.toString(head));
		head = partition(head, 25);
		System.out.println("After Patitioning \n" + LinkedListUtil.toString(head));
	}

	private static Node partition(Node head, int pivot) {
		Node before = null, after = null, tmp = head, second = null;

		while (tmp != null) {
			if (tmp.getData() >= pivot) {
				if (after != null) {
					after.setNext(tmp);
					after = after.getNext();
				} else {
					second = after = tmp;
				}
			} else {
				if (before != null) {
					before.setNext(tmp);
					before = before.getNext();
				} else {
					head = before = tmp;
				}
			}
			tmp = tmp.getNext();
		}

		before.setNext(second);
		return head;
	}
}
