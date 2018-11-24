package stack;

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class GetMinVaueInConstantTimeImproved {

	public static void main(String[] args) {
		AdvacedStack2 stack = new AdvacedStack2();
		for (int i = 1; i <= 10; i++) {
			stack.push(ThreadLocalRandom.current().nextInt(1, 50));
		}
		System.out.println(stack);
	}

}

class AdvacedStack2 extends Stack<Integer> {
	Stack<Integer> valueStack;
	Stack<Integer> minStack;

	public AdvacedStack2() {
		valueStack = new Stack<>();
		minStack = new Stack<>();
	}

	@Override
	public Integer push(Integer item) {
		valueStack.push(item);
		if (minStack.isEmpty() || minStack.peek() >= item) {
			minStack.push(item);
		}
		return item;
	}

	@Override
	public synchronized Integer pop() {
		if (valueStack.peek() == minStack.peek()) {
			minStack.pop();
		}
		return valueStack.pop();
	}

	public Integer minElement() {
		return minStack.peek();
	}

	public Integer top() {
		return valueStack.peek();
	}

	@Override
	public synchronized boolean isEmpty() {
		return valueStack.isEmpty();
	}

	@Override
	public synchronized String toString() {
		return "Value Stack : " + valueStack.toString() + "\nMin Stack : " + minStack.toString();
	}
}

/*output
Value Stack : [18, 12, 22, 3, 28, 2, 34, 42, 32, 37]
Min Stack : [18, 12, 3, 2]
 */
