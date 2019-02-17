package array;

/*https://www.geeksforgeeks.org/find-subarray-least-average/
*/
public class FindSubarrayWithLeastAverage {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 7, 90, 20, 10, 50, 40 };
		findSubArray(arr, 3);
	}

	private static void findSubArray(int[] arr, int k) {

		int sum = 0, minSum = 0, index = 0;
		for (int i = 0; i < k; i++)
			sum += arr[i];
		minSum = sum;
		for (int i = k; i < arr.length; i++) {
			sum += arr[i] - arr[i - k];

			if (sum < minSum) {
				minSum = sum;
				index = (i - k + 1);
			}
		}

		System.out.println("Subarray between [" + index + ", " + (index + k - 1) + "] has minimum average");
	}
}
