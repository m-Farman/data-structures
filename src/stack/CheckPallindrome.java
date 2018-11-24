package stack;

import java.util.Stack;

public class CheckPallindrome {
	public static void main(String[] args) {
		boolean check = isPallindrome("abcXcba");
		System.out.println(" expression isPallindrome : " + check);
	}

	private static boolean isPallindrome(String string) {

		Stack<Character> stack = new Stack<>();
		boolean insert = true;
		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			if (ch == 'X') {
				insert = false;
				continue;
			}
			if (insert) {
				stack.push(ch);
			} else {
				if (stack.isEmpty() || stack.pop() != ch) {
					return false;
				}
			}
		}
		return stack.isEmpty() ? true : false;
	}
}

/*output
 * 
  expression isPallindrome : true
 *
 * */
 