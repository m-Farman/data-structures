package array;

public class MaxProfitPercentageMadeInSellingStockForGivenRange {

	public static void main(String[] args) {
		double[] arr = { 2, 3, 10, 6, 4, 8, 1 };
		double output = getMaxProfitPercentage(arr);
		System.out.println(output);
	}

	private static double getMaxProfitPercentage(double[] arr) {

		double maxPer = 0;
		double start = arr[0], end = arr[0];
		for (int i = 0; i < arr.length; i++) {

			while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
				start = Math.min(start, arr[i]);
				i++;
			}

			while (i + 1 < arr.length && arr[i] < arr[i + 1]) {
				i++;
			}
			end = arr[i];
			double per = ((end - start) / end) * 100;
			maxPer = Math.max(maxPer, per);

		}

		return maxPer;
	}
}
