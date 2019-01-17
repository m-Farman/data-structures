package array;

import java.util.Arrays;

public class ArrayRotation {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(arr));
		arr = rotate(arr, 3);
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

	public static int gcd(int a, int b) {

		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}
}

/*output
 * 
[1, 2, 3, 4, 5, 6, 7, 8, 9]
[7, 8, 9, 7, 8, 9, 1, 2, 3]
 * */
