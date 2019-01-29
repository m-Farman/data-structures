package array;

import java.util.Arrays;

/*Rearrange an array such that arr[i] = i*/
public class RearrangeArray {

	public static void main(String[] args) {

		int[] arr = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
		System.out.println(Arrays.toString(arr));
		arrange(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void arrange(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] >= 0 && arr[i] != i) {
				int ele = arr[arr[i]];
				arr[arr[i]] = arr[i];
				arr[i] = ele;
			} else {
				i++;
			}

		}

	}

}

/*output
[-1, -1, 6, 1, 9, 3, 2, -1, 4, -1]
[-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
 * */
