package array.twodimensional;

//https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
public class SearchInRowColumnWiseSortedMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		int find = 29;
		String output = searchInMatix(matrix, find);
		System.out.println(output);
		System.out.println(searchInMatix(
				new int[][] { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } }, 100));

	}

	private static String searchInMatix(int[][] matrix, int find) {

		int i = 0, j = matrix[0].length - 1;

		while (j >= 0 && i < matrix.length) {

			if (matrix[i][j] == find) {
				return "Found at position (" + i + " ," + j + ")";
			} else if (matrix[i][j] > find) {
				j--;
			} else {
				i++;
			}

		}

		return "Result not found";
	}

}



/*output
 * 
Found at position (2 ,1)
Result not found
 * 
 * */
