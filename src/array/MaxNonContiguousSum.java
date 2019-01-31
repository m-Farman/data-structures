package array;

public class MaxNonContiguousSum {

	public static void main(String[] args) {
		int[] arr = { 3, 5, -7, 8, 10 };
		int output = findMaxSum(arr);
		System.out.println("Max sum is " + output);
		System.out.println("Max sum is " + findMaxSum(new int[] { -2, 1, 3, -4, 5 }));
	}

	private static int findMaxSum(int[] arr) {

		int[] maxSum = new int[arr.length];

		for (int i = 0; i < maxSum.length; i++) {
			maxSum[i] = arr[i];
			if (i == 0) {
				continue;
			}
			maxSum[i] = Math.max(maxSum[i], maxSum[i - 1]);
			if (i == 1) {
				continue;
			}
			maxSum[i] = Math.max(maxSum[i], maxSum[i - 2] + arr[i]);

		}

		return maxSum[arr.length - 1];
	}
}

/*output
 *
Max sum is 15
Max sum is 8

 * */
 