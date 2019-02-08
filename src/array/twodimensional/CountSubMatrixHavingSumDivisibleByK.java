package array.twodimensional;

import java.util.Arrays;

public class CountSubMatrixHavingSumDivisibleByK {

	public static void main(String[] args) {

		int[][] matrix = { { 5, -1, 6 }, { -2, 3, 8 }, { 7, 4, -9 } };
		int output = count(matrix, 3, 3, 4);
		System.out.println("Number of sub matrix divisible by k are " + output);

	}

	private static int count(int[][] matrix, int m, int n, int k) {

		int[] tmp = new int[m];
		int total = 0;

		for (int i = 0; i < n; i++) {
			Arrays.fill(tmp, 0);
			for (int j = i; j < n; j++) {

				for (int l = 0; l < m; l++) {
					tmp[l] += matrix[l][j];
				}
				total += findSubArrayaCount(tmp, k);
			}
		}

		return total;
	}

	private static int findSubArrayaCount(int[] array, int k) {

		int[] mod = new int[k];

		int sum = 0, output = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			mod[((sum % k) + k) % k]++;
		}

		for (int i = 0; i < mod.length; i++) {
			if (mod[i] > 1) {
				output += (mod[i] * mod[i] - 1) / 2;
			}
		}

		output += mod[0];
		return output;
	}

}

/*
 * output
 *
 * Number of sub matrix divisible by k are 6
 */
