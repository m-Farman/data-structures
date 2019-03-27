package array;

import java.util.Arrays;

public class FindPairWithGivenSumInSortedArray {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 4, 5, 7, 8, 9, 11, 12 };
		int[] output = findPair(arr, 6);
		System.out.println("Pair with given sum is " + Arrays.toString(output));

	}

	private static int[] findPair(int[] arr, int sum) {

		int left = 0, right = arr.length - 1;
		while (left < right) {

			if (arr[left] + arr[right] == sum) {
				break;
			} else if (arr[left] + arr[right] < sum) {
				left++;
			} else {
				right--;
			}

		}

		if (left != right) {
			return new int[] { arr[left], arr[right] };
		}

		return null;
	}

}



/*output
 * 
 * 
Pair with given sum is [1, 5]
 * 
 * */
