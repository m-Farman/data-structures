package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleavingElementInQueueUsingStack {

	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= 10; i++) {
			queue.offer(i);
		}
		System.out.println(" queue :\n" + queue);
		queue = interleaveQueue(queue);
		System.out.println(" interleave queue :\n" + queue);
	}

	private static Queue<Integer> interleaveQueue(Queue<Integer> queue) {

		if (queue.size() % 2 != 0) {
			throw new IllegalArgumentException();
		}
		int half = queue.size() / 2;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < half; i++) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
		for (int i = 0; i < half; i++) {
			queue.offer(queue.poll());
		}
		for (int i = 0; i < half; i++) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			queue.offer(stack.pop());
			queue.offer(queue.poll());
		}
		return queue;
	}
}

/*output
 * 
 queue :
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 interleave queue :
[1, 6, 2, 7, 3, 8, 4, 9, 5, 10]
 * */
 