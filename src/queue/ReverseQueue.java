package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= 10; i++) {
			queue.offer(i);
		}
		System.out.println(" queue :\n" + queue);
		queue = reverseQueue(queue);
		System.out.println(" reverse queue :\n" + queue);
	}

	private static Queue<Integer> reverseQueue(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();
		while (!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
		return queue;
	}

}

/*output
 * 
  queue :
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 reverse queue :
[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
 
 * */
 