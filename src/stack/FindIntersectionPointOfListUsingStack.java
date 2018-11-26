package stack;

import java.util.Stack;

import linkedList.LinkedListUtil;
import linkedList.Node;

public class FindIntersectionPointOfListUsingStack {

	public static void main(String[] args) {
		Node head1 = LinkedListUtil.createRandomLinkedList(15, 50);
		Node head2 = LinkedListUtil.createRandomLinkedList(5, 50);

		Node tmp1 = head1, tmp2 = head2;
		while (tmp2.getNext() != null) {
			tmp2 = tmp2.getNext();
			tmp1 = tmp1.getNext();
		}
		tmp2.setNext(tmp1);
		System.out.println("List One : \n" + LinkedListUtil.toString(head1));
		System.out.println("List Second : \n" + LinkedListUtil.toString(head2));
		Node result = findIntersectingNode(head1, head2);
		System.out.println("Intersecting Node is : " + result.getData());

	}

	private static Node findIntersectingNode(Node head1, Node head2) {
		Stack<Node> stack1 = new Stack<>();
		Node tmp = head1;
		while (tmp != null) {
			stack1.push(tmp);
			tmp = tmp.getNext();
		}
		Stack<Node> stack2 = new Stack<>();
		tmp = head2;
		while (tmp != null) {
			stack2.push(tmp);
			tmp = tmp.getNext();
		}

		while ((!stack1.isEmpty() && !stack2.isEmpty()) && stack1.peek() == stack2.peek()) {
			tmp = stack1.pop();
			stack2.pop();

		}
		return tmp;
	}
}


/*output
List One : 
[38, 3, 9, 39, 5, 40, 43, 2, 17, 49, 10, 45, 21, 2, 48]
List Second : 
[12, 15, 15, 3, 6, 5, 40, 43, 2, 17, 49, 10, 45, 21, 2, 48]
Intersecting Node is : 5
 * */
 