package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/
public class PythagoreanTripletInAnArray {

	public static void main(String[] args) {

		int arr[] = { 3, 1, 4, 6, 5, 13, 12 };

		List<List<Integer>> alltriplets = findAllTriplets(arr);
		System.out.println("All Pythagorean Triplet In The Given Array Are");
		System.out.println(alltriplets);

	}

	private static List<List<Integer>> findAllTriplets(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * arr[i];
		}
		Arrays.sort(arr);
		int left = 0, right = 0;
		List<List<Integer>> output = new ArrayList<>();

		for (int i = arr.length - 1; i > 0; i--) {

			left = 0;
			right = i - 1;
			while (left < right) {
				if (arr[i] == arr[left] + arr[right]) {
					output.add(Arrays.asList(sqrt(arr[i]), sqrt(arr[left]), sqrt(arr[right])));
					break;
				} else if (arr[i] < arr[left] + arr[right]) {
					right--;
				} else {
					left++;
				}
			}

		}

		return output;
	}

	public static int sqrt(int input) {

		return (int) Math.sqrt(input);
	}
}

/*output*
 * 
All Pythagorean Triplet In The Given Array Are
[[13, 5, 12], [5, 3, 4]]
 * /
 */