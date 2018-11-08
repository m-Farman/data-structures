package stack;

import java.util.Stack;

public class BalancedBrackets {

	public static void main(String[] args) {

		boolean check = ischeckBalancedBrackets("()(()[()])");
		System.out.println("Is given expression balanced : " + check);
	}

	private static boolean ischeckBalancedBrackets(String string) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);

			if (ch == ')' || ch == '}' || ch == ']') {
				if (stack.isEmpty()) {
					return false;
				}
				char last = stack.peek();
				if ((ch == ')' && last == '(') || (ch == '}' && last == '{') || (ch == ']' && last == '[')) {
					stack.pop();
				}
			} else {
				stack.push(ch);
			}
		}

		return stack.isEmpty() ? true : false;
	}
}
