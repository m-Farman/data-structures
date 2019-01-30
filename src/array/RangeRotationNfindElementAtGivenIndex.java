package array;

import java.util.Arrays;

public class RangeRotationNfindElementAtGivenIndex {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(arr));
		int[][] ranges = { { 0, 2 }, { 0, 3 } };

		int output = findElementAtIndex(arr, ranges, 2, 3);
		System.out.println(output);

	}

	private static int findElementAtIndex(int[] arr, int[][] ranges, int noOfRotation, int index) {

		for (int i = noOfRotation - 1; i >= 0; i--) {

			int l = ranges[i][0];
			int r = ranges[i][1];

			if (l <= index && r >= index) {
				if (index == l) {
					index = r;
				} else {
					index--;
				}

			}

		}

		return arr[index];
	}

}


/*output
 * 
[1, 2, 3, 4, 5, 6, 7, 8, 9]
2
 * 
 * */
