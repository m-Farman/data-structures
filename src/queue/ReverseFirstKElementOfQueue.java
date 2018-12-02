package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementOfQueue {

	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= 10; i++) {
			queue.offer(i);
		}
		System.out.println(" queue :\n" + queue);
		queue = reverseFirstKElement(queue, 7);
		System.out.println(" reverse k queue :\n" + queue);
	}

	private static Queue<Integer> reverseFirstKElement(Queue<Integer> queue, int k) {

		if (k <= 0) {
			return queue;
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < k; i++) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
		int size = queue.size();
		for (int i = 0; i < size - k; i++) {
			queue.offer(queue.poll());
		}

		return queue;
	}
}


/*output
  queue :
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 reverse k queue :
[7, 6, 5, 4, 3, 2, 1, 8, 9, 10]
 
 * */
 