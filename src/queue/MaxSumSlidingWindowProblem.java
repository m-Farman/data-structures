package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class MaxSumSlidingWindowProblem {

	public static void main(String[] args) {
		int a[] = new int[10];
		for (int i = 0; i < 10; i++) {
			a[i] = ThreadLocalRandom.current().nextInt(1, 10);
		}
		System.out.println("Input arrays is :\n" + Arrays.toString(a));
		int max = findMaxSumInWindow(a, 3);
		System.out.println("Max sum is :\n" + max);
	}

	private static int findMaxSumInWindow(int[] a, int window) {
		Queue<Integer> queue = new LinkedList<>();
		int maxSum = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < window; i++) {
			queue.offer(a[i]);
			sum += a[i];
		}
		maxSum = Math.max(maxSum, sum);
		for (int i = window; i < a.length; i++) {
			sum += a[i] - queue.poll();
			queue.offer(a[i]);
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}
}


/*output
Input arrays is :
[9, 8, 6, 4, 8, 2, 3, 6, 2, 8]
Max sum is :
23
 * */
