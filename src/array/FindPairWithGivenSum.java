package array;

import java.util.Arrays;
import java.util.HashSet;

public class FindPairWithGivenSum {

	public static void main(String[] args) {
		int arr[] = { 4, 12, 11, 7, 5, 9, 1, 8, 3 };
		int[] output = findPair(arr, 6);
		System.out.println(Arrays.toString(output));
		System.out.println(Arrays.toString(findPair2(new int[] { 4, 12, 11, 7, 5, 9, 1, 8, 3 }, 6)));

	}

	private static int[] findPair(int[] arr, int sum) {

		Arrays.sort(arr);
		int l = 0, r = arr.length - 1;

		while (l != r) {

			if (arr[l] + arr[r] == sum) {
				break;
			} else if (arr[l] + arr[r] < sum) {
				l += 1;
			} else {
				r -= 1;
			}

		}

		if (l != r) {
			int[] output = { arr[l], arr[r] };
			return output;
		}

		return null;
	}

	private static int[] findPair2(int[] arr, int sum) {

		HashSet<Integer> integers = new HashSet<>();
		int[] output = new int[2];

		for (int i = 0; i < arr.length; i++) {
			if (integers.contains(sum - arr[i])) {
				output[0] = sum - arr[i];
				output[1] = arr[i];
			} else {
				integers.add(arr[i]);
			}
		}

		return output;
	}
}

/*output
 * 
[1, 5]
[5, 1]
 * */
