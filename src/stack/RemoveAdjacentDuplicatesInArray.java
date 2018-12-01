package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class RemoveAdjacentDuplicatesInArray {

	public static void main(String[] args) {
		int[] a = new int[20];
		int[] b = { 1, 5, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5 };
		int[] c = { 1, 9, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5 };
		for (int i = 0; i < 20; i++) {
			a[i] = ThreadLocalRandom.current().nextInt(1, 5);
		}
		System.out.println("Input array is : " + Arrays.toString(a));
		System.out.println("Output array is : " + Arrays.toString(removeAdjacent(a)));
		System.out.println("Output array is : " + Arrays.toString(removeAdjacent(b)));
		System.out.println("Output array is : " + Arrays.toString(removeAdjacent(c)));
	}

	private static Integer[] removeAdjacent(int[] a) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while (i < a.length) {
			if (stack.isEmpty() || stack.peek() != a[i]) {
				stack.push(a[i]);
			} else {
				while (i < a.length && stack.peek() == a[i]) {
					i++;
				}
				stack.pop();
				continue;
			}
			i++;
		}

		return new ArrayList<>(stack).toArray(new Integer[stack.size()]);
	}

}

/*output
 * 
Input array is : [4, 4, 3, 3, 1, 2, 4, 4, 4, 3, 3, 1, 3, 2, 2, 4, 1, 4, 3, 4]
Output array is : [1, 2, 1, 3, 4, 1, 4, 3, 4]
Output array is : [1]
Output array is : [1, 9, 5]
 * */
