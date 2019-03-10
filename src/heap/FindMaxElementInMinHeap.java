package heap;

import java.util.Arrays;

public class FindMaxElementInMinHeap {

	public static void main(String[] args) {
		int[] minHeap = HeapUtil.getRandomMinHeap(10, 4, 20);
		System.out.println("Min Heap is : " + Arrays.toString(minHeap));
		int output = findMaxElement(minHeap);
		System.out.println("Max Element In Given Min Heap is " + output);
	}

	private static int findMaxElement(int[] minHeap) {

		int firstChildNode = (minHeap.length - 1) / 2;
		int max = Integer.MIN_VALUE;
		for (int i = firstChildNode; i < minHeap.length; i++) {
			max = Math.max(minHeap[i], max);
		}

		return max;
	}
}
