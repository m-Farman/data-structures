package array;

import java.util.Arrays;

public class ReverseAnArray {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		System.out.println(Arrays.toString(arr));
		reverse(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void reverse(int[] arr) {

		int start = 0, end = arr.length - 1;

		while (start < end) {

			int tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;

			start++;
			end--;
		}

	}
}

/*
 * output
 * 
 * [4, 5, 6, 7, 8, 9, 1, 2, 3] 
 * [3, 2, 1, 9, 8, 7, 6, 5, 4]
 * 
 */
