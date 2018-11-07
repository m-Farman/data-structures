package linkedList.singlyLinkedList;

import java.util.HashSet;

import linkedList.LinkedListUtil;
import linkedList.Node;

public class RemoveDuplicateFromLinkedList {

	public static void main(String[] args) {
		Node head = LinkedListUtil.createDuplicateDataLinkedList(10);
		System.out.println("Before Removing Duplicates \n" + LinkedListUtil.toString(head));
		head = removeDuplicate(head);
		System.out.println("After Removing Duplicates \n" + LinkedListUtil.toString(head));
	}

	private static Node removeDuplicate(Node head) {
		HashSet<Integer> uniqueNode = new HashSet<>();
		Node tmp = head, next = null;
		uniqueNode.add(head.getData());
		while (tmp.getNext() != null) {
			next = tmp.getNext();
			if (uniqueNode.add(next.getData())) {
				tmp = tmp.getNext();
			} else {
				tmp.setNext(next.getNext());
			}
		}
		return head;
	}

}

/*output
 * 
Before Removing Duplicates 
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
After Removing Duplicates 
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 
 * */
 