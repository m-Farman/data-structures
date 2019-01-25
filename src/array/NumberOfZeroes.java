package array;

/*Given an array of 1s and 0s which has all 1s first followed by all 0s. 
 * Find the number of 0s. 
 * Count the number of zeroes in the given array.
*/
public class NumberOfZeroes {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 1, 0, 0, 0, 0, 0 };
		int index = findZeroIndex(arr, 0, arr.length - 1);
		System.out.println("First one index " + index);
		System.out.println("No of Ones " + (index == -1 ? 0 : arr.length - index));

	}

	private static int findZeroIndex(int[] arr, int start, int end) {

		int low = start, high = end;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] == 0 && (mid == 0 || arr[mid - 1] == 1)) {
				return mid;
			}

			if (arr[mid] == 1) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}
}
/*output
 * 
First one index 3
No of Ones 5
 * 
 * */
