package stack;

import java.util.HashMap;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvaluatePostfixExpression {

	private static HashMap<String, BiFunction<Integer, Integer, Integer>> evaluator = new HashMap<>();

	static {
		evaluator.put("+", (i1, i2) -> i1 + i2);
		evaluator.put("-", (i1, i2) -> i2 - i1);
		evaluator.put("*", (i1, i2) -> i1 * i2);
		evaluator.put("/", (i1, i2) -> i2 / i1);
	}

	public static void main(String[] args) {
		int check = evaluatePostfix("123*+5-");
		System.out.println("Result of the expression is : " + check);
	}

	private static int evaluatePostfix(String exp) {
		Stack<Integer> stack = new Stack<>();
		for (String s : exp.split("")) {
			if (evaluator.containsKey(s)) {
				int result = evaluator.get(s).apply(stack.pop(), stack.pop());
				stack.push(result);
			} else {
				stack.push(Integer.parseInt(s));
			}
		}
		return stack.pop();
	}

}

/*output
 * 
Result of the expression is : 2
 * */
