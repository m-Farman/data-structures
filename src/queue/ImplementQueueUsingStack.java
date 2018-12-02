package queue;

import java.util.Stack;

public class ImplementQueueUsingStack {

	public static void main(String[] args) throws Exception {
		QueueUsingStack<Integer> queue = new QueueUsingStack<>();
		for (int i = 1; i <= 10; i++) {
			queue.enQueue(i);
		}
		System.out.println("Element of Queue are: ");
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
	}
}

class QueueUsingStack<E> {

	private Stack<E> stack1 = new Stack<>();
	private Stack<E> stack2 = new Stack<>();

	public E enQueue(E element) {
		return stack2.push(element);
	}

	public E deQueue() throws Exception {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			throw new Exception(" Queue Underflow ");
		}
		if (stack1.isEmpty()) {
			int size = stack2.size();
			for (int i = 0; i < size; i++) {
				stack1.push(stack2.pop());
			}

		}
		return stack1.pop();
	}

	public int size() {
		return stack1.size() + stack2.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

}


/*output
Element of Queue are: 
1
2
3
4
5
6
7
8
9
10
 * */
