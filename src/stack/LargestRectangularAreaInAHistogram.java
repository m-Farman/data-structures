package stack;

import java.util.Stack;

public class LargestRectangularAreaInAHistogram {

	public static void main(String[] args) {
		int[] height = { 1, 2, 6, 2, 2, 2, 7, 1 };
		int output = findMaxArea(height, height.length);
		System.out.println(output);
		height = new int[] { 6, 2, 5, 4, 5, 1, 6 };
		output = findMaxArea(height, height.length);
		System.out.println(output);
	}

	private static int findMaxArea(int[] height, int length) {

		Stack<Integer> stack = new Stack<>();
		int maxArea = 0, tmpArea = 0, i = 0, top = 0;

		while (i < length) {

			if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
				stack.push(i++);
				continue;
			}

			top = stack.pop();
			tmpArea = height[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
			if (tmpArea > maxArea) {
				maxArea = tmpArea;
			}
		}

		while (!stack.isEmpty()) {
			top = stack.pop();
			tmpArea = height[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
			if (tmpArea > maxArea) {
				maxArea = tmpArea;
			}
		}

		return maxArea;
	}
}
