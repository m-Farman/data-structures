package stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class FindingOfSpan {

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = ThreadLocalRandom.current().nextInt(1, 20);
		}
		System.out.println("Stock prices are : \n" + Arrays.toString(a));
		System.out.println("Spanning of the prices are : \n" + Arrays.toString(findSpanFromArray(a)));
	}

	private static int[] findSpanFromArray(int[] a) {
		Stack<Integer> stack = new Stack<>();
		int gtElement = -1;
		int[] span = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
				stack.pop();
			}
			gtElement = stack.isEmpty() ? -1 : stack.peek();
			span[i] = i - gtElement;
			stack.push(i);
		}
		return span;
	}
}

/*output
Stock prices are : 
[18, 4, 19, 18, 10, 4, 1, 17, 13, 15]
Spanning of the prices are : 
[1, 1, 3, 1, 1, 1, 1, 4, 1, 2]

 * */
