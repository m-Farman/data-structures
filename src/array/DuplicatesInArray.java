package array;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicatesInArray {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 1, 1, 10, 4, 6, 4, 5, 5, 8, 8, 6, 7, 56, 56, 45 };
		Map<Integer, Integer> count = getDuplicatesCount(a);
		count.keySet().stream().forEach(k -> System.out.println("Integer " + k + " with count : " + count.get(k)));
	}

	private static Map<Integer, Integer> getDuplicatesCount(int[] a) {
		HashMap<Integer, Integer> count = new HashMap<>();
		int data = 1;
		for (int i = 0; i < a.length; i++) {
			data = 1;
			if (count.containsKey(a[i])) {
				data = count.get(a[i]) + 1;
			}
			count.put(a[i], data);
		}

		return count.keySet().stream().filter(k -> count.get(k) > 1)
				.collect(Collectors.toMap(k -> k, k -> count.get(k)));
	}
}

/*output
 * 
Integer 1 with count : 3
Integer 4 with count : 2
Integer 5 with count : 2
Integer 6 with count : 2
Integer 56 with count : 2
Integer 8 with count : 2
 
 * */
 