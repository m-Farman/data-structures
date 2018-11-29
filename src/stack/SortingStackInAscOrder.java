package stack;

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class SortingStackInAscOrder {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 10; i++) {
			stack.push(ThreadLocalRandom.current().nextInt(1, 20));
		}
		System.out.println("Input stack is : "+stack);
		stack = sortStackUsingStackOperation(stack);
		System.out.println("Sorted stack is : "+stack);
	}

	private static Stack<Integer> sortStackUsingStackOperation(Stack<Integer> stack) {

		Stack<Integer> tmp = new Stack<>();
		while (!stack.isEmpty()) {
			int topElement = stack.pop();
			while (!tmp.isEmpty() && tmp.peek() > topElement) {
				stack.push(tmp.pop());
			}
			tmp.push(topElement);
		}

		return tmp;
	}
}

/*output
 
Input stack is : [19, 14, 4, 10, 4, 9, 10, 8, 19, 7]
Sorted stack is : [4, 4, 7, 8, 9, 10, 10, 14, 19, 19]
 
 * */
 