package array;

import java.util.Arrays;

public class ArrayRotation {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(arr));
//		arr = rotate(arr, 3);
		rotationUsingReversal(arr, 3);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] rotate(int[] arr, int times) {

		int gcd = gcd(arr.length, times);
		int tmp, j, k, n = arr.length;
		for (int i = 0; i < arr.length; i++) {
			tmp = arr[i];
			j = i;
			while (true) {
				k = j + times;
				if (k >= n) {
					k = k - n;
				}
				if (k == i) {
					break;
				}
				arr[j] = arr[k];
				j = k;
			}
			arr[k] = tmp;
		}

		return arr;
	}
	/*output
	 * 
	[1, 2, 3, 4, 5, 6, 7, 8, 9]
	[7, 8, 9, 7, 8, 9, 1, 2, 3]

	 * */

	public static int gcd(int a, int b) {

		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}
	
	public static int[] rotationUsingReversal(int[] arr, int times) {
		reverseArray(arr, 0, times - 1);
		reverseArray(arr, times, arr.length - 1);
		reverseArray(arr, 0, arr.length - 1);
		return arr;
	}

	private static void reverseArray(int[] arr, int start, int end) {

		int tmp;
		while (start < end) {
			tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
	}
}

