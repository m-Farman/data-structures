package array;

import java.util.Arrays;

public class MoveAllZeroesToEnd {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 0, 0, 0, 3, 6 };
		System.out.println(Arrays.toString(arr));
		move(arr);
		System.out.println(Arrays.toString(arr));

	}

	private static void move(int[] arr) {

		int start = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[start++] = arr[i];
			}
		}

		while (start < arr.length) {
			arr[start++] = 0;
		}

	}
}

/*output
 *
[1, 2, 0, 0, 0, 3, 6]
[1, 2, 3, 6, 0, 0, 0]
 * */
 