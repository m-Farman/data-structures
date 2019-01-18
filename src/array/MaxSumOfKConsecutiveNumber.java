package array;

public class MaxSumOfKConsecutiveNumber {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int output = findSumUsingSlidingWindow(arr, 3);
		System.out.println(output);
		System.out.println(findSumUsingSlidingWindow(new int[] { 1, 4, 2, 10, 2, 3, 1, 0, 20 }, 4));

	}

	private static int findSumUsingSlidingWindow(int[] arr, int k) {

		int sum = 0, j = 0, n = arr.length;
		for (; j < k; j++) {
			sum += arr[j];
		}

		int maxSum = sum;
		while (j < n) {
			sum = sum - arr[j - k] + arr[j];
			maxSum = Math.max(sum, maxSum);
			j++;
		}
		return maxSum;
	}
}


/*output
 *
24
24
 * */
 