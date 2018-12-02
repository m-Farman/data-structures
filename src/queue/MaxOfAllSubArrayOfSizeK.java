package queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class MaxOfAllSubArrayOfSizeK {

	public static void main(String[] args) {
		int a[] = new int[10];
		for (int i = 0; i < 10; i++) {
			a[i] = ThreadLocalRandom.current().nextInt(1, 10);
		}
		System.out.println("Input arrays is :\n" + Arrays.toString(a));
		a = findMaxInWindow(a, 3);
		System.out.println("Max sum is :\n" + Arrays.toString(a));

	}

	private static int[] findMaxInWindow(int[] a, int k) {
		Deque<Integer> deque = new LinkedList<>();
		int[] output = new int[a.length - k + 1];
		int j = 0;
		for (; j < k; j++) {
			while (!deque.isEmpty() && a[deque.peekLast()] <= a[j]) {
				deque.removeLast();
			}
			deque.addLast(j);
		}
		for (; j < a.length; j++) {
			output[j - k] = a[deque.peek()];
			while (!deque.isEmpty() && deque.peek() <= j - k) {
				deque.pollFirst();
			}

			while (!deque.isEmpty() && a[deque.peekLast()] <= a[j]) {
				deque.removeLast();
			}
			deque.addLast(j);
		}
		output[j - k] = deque.peek();
		return output;
	}

}

/*output
Input arrays is :
[5, 5, 4, 9, 2, 5, 7, 7, 1, 4]
Max sum is :
[5, 9, 9, 9, 7, 7, 7, 7]
 * */
