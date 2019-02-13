package array;

/*https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
*/
public class MaximumDifferenceSuchThatLargerAppearLater {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 10, 6, 4, 8, 1 };
		int output = getMaxDiff(arr);
		System.out.println("Required Output is : " + output);
	}

	private static int getMaxDiff(int[] arr) {

		int maxDiff = Integer.MIN_VALUE, minElement = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] - minElement > maxDiff) {
				maxDiff = arr[i] - minElement;
			}

			if (arr[i] < minElement) {
				minElement = arr[i];
			}
		}

		return maxDiff;
	}
}


/*output
 *
Required Output is : 8
 * */
 