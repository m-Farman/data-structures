package array;

public class FindMissingNumberBetweenArray {

	public static void main(String[] args) {

		int[] a = { 2, 4, 2, 5, 67, 8, 79 };
		int[] b = { 2, 4, 5, 67, 8, 79 };
		int output = findMissingNumber(a, b);
		System.out.println("Missing number is " + output);

	}

	private static int findMissingNumber(int[] a, int[] b) {

		int[] tmp = a.length > b.length ? a : b;
		int output = 0;
		for (int i = 0; i < tmp.length; i++) {
			output ^= a[i];
		}
		tmp = a.length > b.length ? b : a;
		for (int i = 0; i < tmp.length; i++) {
			output ^= b[i];
		}

		return output;
	}

}


/*output
 *
Missing number is 2
 * */
 