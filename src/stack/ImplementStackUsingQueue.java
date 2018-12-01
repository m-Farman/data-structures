package stack;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

	public static void main(String[] args) {
		StackUsingQueue<Integer> stack = new StackUsingQueue<>();
		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}
		System.out.println(" Structure of Stack is : \n" + stack);
		System.out.println(" Now Poping an element " + stack.pop());
		System.out.println(" Final structure of Stack is : \n" + stack);
	}
}

class StackUsingQueue<E> {

	private Queue<E> queue1st = new LinkedList<>();
	private Queue<E> queue2nd = new LinkedList<>();

	public int size() {
		return queue1st.size() + queue2nd.size();
	}

	public boolean push(E element) {
		if (!queue1st.isEmpty()) {
			return queue1st.offer(element);
		} else {
			return queue2nd.offer(element);
		}
	}

	public E pop() {
		if (queue1st.isEmpty() && queue2nd.isEmpty()) {
			throw new EmptyStackException();
		}

		if (queue1st.isEmpty()) {
			return reverseTheQueueNGiveLast(queue1st, queue2nd);
		} else {
			return reverseTheQueueNGiveLast(queue2nd, queue1st);
		}
	}

	private E reverseTheQueueNGiveLast(Queue<E> q1, Queue<E> q2) {
		int size = q2.size() - 1;
		for (int i = 0; i < size; i++) {
			q1.offer(q2.poll());
		}
		return q2.poll();
	}

	public E top() {
		if (queue1st.isEmpty() && queue2nd.isEmpty()) {
			throw new EmptyStackException();
		}
		E e = null;
		if (queue1st.isEmpty()) {
			e = reverseTheQueueNGiveLast(queue1st, queue2nd);
			queue1st.offer(e);
		} else {
			e = reverseTheQueueNGiveLast(queue2nd, queue1st);
			queue2nd.offer(e);
		}
		return e;
	}

	@Override
	public String toString() {
		System.out.println(queue1st);
		System.out.println(queue2nd);
		StringBuilder sb = new StringBuilder();
		Object[] arr = new Object[size()];
		if (queue1st.isEmpty()) {
			int size = queue2nd.size();
			for (int i = 0; i < size; i++) {
				E e = queue2nd.poll();
				arr[i] = e;
				queue1st.offer(e);
			}
		} else {
			int size = queue1st.size();
			for (int i = 0; i < size; i++) {
				E e = queue1st.poll();
				arr[i] = e;
				queue2nd.offer(e);
			}
		}
		sb.append("[");
		for (int i = 0; i < arr.length - 1; i++) {
			sb.append(arr[i] + ", ");

		}
		sb.append(arr[arr.length - 1]);
		sb.append("]");

		return sb.toString();
	}
	
}

/*output
[]
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 Structure of Stack is : 
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 Now Poping an element 10
[]
[1, 2, 3, 4, 5, 6, 7, 8, 9]
 Final structure of Stack is : 
[1, 2, 3, 4, 5, 6, 7, 8, 9]

 * */
 