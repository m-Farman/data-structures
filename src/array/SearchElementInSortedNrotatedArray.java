package array;

public class SearchElementInSortedNrotatedArray {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int n = arr.length;
		int key = 6;
		int index = search(arr, 0, n - 1, key);
		System.out.println("Found at index " + index);

	}

	/* Complexity O(log n) */
	private static int search(int[] arr, int start, int end, int key) {

		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;
		if (arr[mid] == key) {
			return mid;
		}

		if (arr[start] <= arr[mid]) {
			if (arr[mid] > key) {
				return search(arr, start, mid - 1, key);
			} else {
				return search(arr, mid + 1, end, key);
			}
		}

		if (arr[mid] <= arr[end] && arr[mid] > key) {
			return search(arr, mid + 1, end, key);
		}

		return search(arr, start, mid - 1, key);
	}
}

/*output
 *
Found at index 2
 * */
