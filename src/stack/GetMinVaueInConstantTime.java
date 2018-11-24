package stack;

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class GetMinVaueInConstantTime {

	public static void main(String[] args) {
		AdvacedStack stack = new AdvacedStack();
		for (int i = 1; i <= 10; i++) {
			stack.push(ThreadLocalRandom.current().nextInt(1, 50));
		}
		System.out.println(stack);
	}

}

class AdvacedStack extends Stack<Integer> {
	Stack<Integer> valueStack;
	Stack<Integer> minStack;

	public AdvacedStack() {
		valueStack = new Stack<>();
		minStack = new Stack<>();
	}

	@Override
	public Integer push(Integer item) {
		valueStack.push(item);
		minStack.push(minStack.isEmpty() || minStack.peek() >= item ? item : minStack.peek());
		return item;
	}

	@Override
	public synchronized Integer pop() {
		minStack.pop();
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
 * 
Value Stack : [16, 5, 42, 35, 7, 14, 23, 20, 30, 19]
Min Stack : [16, 5, 5, 5, 5, 5, 5, 5, 5, 5]
 */
