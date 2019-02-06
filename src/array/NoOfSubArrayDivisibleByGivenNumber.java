package array;

import java.util.Arrays;

public class NoOfSubArrayDivisibleByGivenNumber {

	public static void main(String[] args) {

		int[] arr = { 4, 5, 0, -2, -3, 1 };
		int[] arr2 = new int[] { 4, 5, 0, -12, -23, 1 };
		System.out.println(Arrays.toString(arr));
		int output = getSubArrayCount(arr, 5);
		System.out.println(output);
		System.out.println(Arrays.toString(arr2));
		System.out.println(getSubArrayCount(arr2, 5));
		System.out.println("---------Using Optimise way------");
		System.out.println(getSubArrayCountOptimised(arr, 5));
		System.out.println(getSubArrayCountOptimised(arr2, 5));
	}

	/* complexity 0(n^2) */
	private static int getSubArrayCount(int[] arr, int k) {

		int[] sum = new int[arr.length];
		int s = 0, count = 0;
		for (int j = 0; j < sum.length; j++) {
			s = sum[j] = s + arr[j];
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				s = sum[j];
				if (i - 1 >= 0) {
					s -= sum[i - 1];
				}
				if (s % k == 0) {
					count++;
				}
			}
		}
		return count;
	}

	/* complexity 0(n+k) */
	private static int getSubArrayCountOptimised(int[] arr, int k) {

		int[] mod = new int[k];
		int sum = 0, count = 0;
		for (int j = 0; j < arr.length; j++) {
			sum += arr[j];
			mod[((sum % k) + k) % k]++;
		}

		for (int i = 0; i < mod.length; i++) {
			if (mod[i] > 1) {
				count += (mod[i] * (mod[i] - 1)) / 2;
			}
		}
		count += mod[0];
		return count;
	}
}

/*output
 * 
[4, 5, 0, -2, -3, 1]
7
[4, 5, 0, -12, -23, 1]
7
---------Using Optimise way------
7
7
 * 
 * */
