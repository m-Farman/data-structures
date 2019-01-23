package array;

public class PrintLeftArrayRotation {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7, 9 };
		leftRotation(arr, 3);
		leftRotation(arr, 17);
	}

	private static void leftRotation(int[] arr, int k) {

		k = k % arr.length;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[(k + i) % arr.length] + " ");
		}
		System.out.println();

	}
}


/*output
 *
7 9 1 3 5 
5 7 9 1 3 
 * */
 