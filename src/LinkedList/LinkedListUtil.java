package LinkedList;

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
			Node node = new Node();
			node.setData(i);
			node.setNext(null);
			if (i == 1) {
				head = tmp = node;
			} else {
				tmp.setNext(node);
				tmp=tmp.getNext();
			}
		}

		return head;
	}

}
