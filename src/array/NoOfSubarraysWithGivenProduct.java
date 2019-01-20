package array;

public class NoOfSubarraysWithGivenProduct {

	public static void main(String[] args) {
		int arr[] = { 4, 2, 12, 0, 11, 7, 5, 9, 1, 8, 3 };
		int output = findNoOfSubArray(arr, 8);
		System.out.println("No of Sub array " + findNoOfSubArray(arr, 8));
	}

	private static int findNoOfSubArray(int[] arr, int product) {

		int p = 1;
		int l = 0, r = 0;
		int subArrays = 0;
		while (r < arr.length) {

			while (p < product && arr[r] != 0) {
				p *= arr[r];
				r++;
			}
			if (arr[r] == 0) {
				p = 1;
				l = r = r + 1;
				continue;
			}

			if (p == product) {
				int count1 = 0;
				while (r + 1 < arr.length && arr[r + 1] == 1) {
					count1++;
					r++;
				}

				subArrays += count1 + 1;

				while (l <= r && arr[l] == 1) {
					subArrays += count1 + 1;
					l++;
				}
				r++;
			}
			p /= arr[l];
			l++;

		}
		return subArrays;
	}
}

/*output
 * 
No of Sub array 3
 * */
