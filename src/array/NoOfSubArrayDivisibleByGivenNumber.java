package array;

import java.util.Arrays;

public class NoOfSubArrayDivisibleByGivenNumber {

	public static void main(String[] args) {

		int[] arr = { 4, 5, 0, -2, -3, 1 };
		System.out.println(Arrays.toString(arr));
		int output = getSubArrayCount(arr, 5);
		System.out.println(output);

		System.out.println(getSubArrayCount(new int[] { 4, 5, 0, -12, -23, 1 }, 5));
	}

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

}
