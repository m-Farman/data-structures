package linkedList.singlyLinkedList;

import linkedList.LinkedListUtil;
import linkedList.Node;

public class AddindNoAsLinkedList {

	public static void main(String[] args) {
		Node list1 = LinkedListUtil.createRandomLinkedList(5, 9);
		Node list2 = LinkedListUtil.createRandomLinkedList(7, 9);
		System.out.println("First Number : " + LinkedListUtil.toString(list1));
		System.out.println("Second Number : " + LinkedListUtil.toString(list2));
		Node head = addTwoLinkedList(list1, list2);
		System.out.println("Resultant : " + LinkedListUtil.toString(head));
	}

	private static Node addTwoLinkedList(Node list1, Node list2) {
		Node result = null, head = null;
		int carry = 0, add = 0, sum = 0;
		while (list1 != null && list2 != null) {
			sum = list1.getData() + list2.getData() + carry;
			add = sum % 10;
			carry = sum / 10;
			if (head == null) {
				head = result = new Node(add, null);
			} else {
				result.setNext(new Node(add, null));
				result = result.getNext();
			}
			list1 = list1.getNext();
			list2 = list2.getNext();
		}
		if (list1 != null) {
			list1.setData(list1.getData() + carry);
			result.setNext(list1);
		} else if (list2 != null) {
			list2.setData(list2.getData() + carry);
			result.setNext(list2);
		} else if (carry > 0) {
			result.setNext(new Node(carry, null));
		}
		return head;
	}
}

/*
 * output
First Number : [2, 1, 6, 8, 4]
Second Number : [1, 2, 5, 4, 3, 5, 4]
Resultant : [3, 3, 1, 3, 8, 5, 4] 
 */
