package array;

public class FindWaterCollectedBetweenBuildingOfDifferentHeight {

	public static void main(String[] args) {
		int[] height = { 1, 2, 6, 2, 2, 2, 7, 1 };
		int output = findWaterCollected(height, height.length);
		System.out.println("Amount of water collected is " + output);

	}

	private static int findWaterCollected(int[] height, int length) {

		int sindex = 0, sheight = 0;
		int bArea = 0, total = 0, wArea = 0;

		for (int i = 0; i < height.length;) {

			bArea = 0;
			while (i + 1 < length && height[i] < height[i + 1]) {
				i++;
			}
			sheight = height[i];
			sindex = i;

			while (i + 1 < length && sheight > height[++i]) {
				bArea += height[i];
			}
			if (sheight < height[i]) {
				wArea = sheight * (i - sindex - 1) - bArea;
				total = Math.max(total, wArea);
			} else {
				i++;
			}
		}
		return total;
	}
}



/*output
 * 
 * Amount of water collected is 12
 * */
