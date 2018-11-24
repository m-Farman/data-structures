package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Implement2StackInSingleArray {

	public static void main(String[] args) {
		ArrayWithTwoStack<Character> twoStack = new ArrayWithTwoStack<>(26);
		for (char i = 65; i <= 90; i++) {
			if (i % 2 != 0) {
				twoStack.push(1, i);
			} else {
				twoStack.push(2, i);
			}
		}
		System.out.println(" Character stack \n" + twoStack);
		System.out.println("------------------------------------------------------");
		ArrayWithTwoStack<Integer> withTwoStack = new ArrayWithTwoStack<>(20);
		int i = 1;
		while (i <= 20) {
			withTwoStack.push(1, i++);
			withTwoStack.push(2, i++);
		}
		System.out.println(" Integer stack \n" + withTwoStack);
	}
}

class ArrayWithTwoStack<T> {
	private T[] array;
	private int firstTop;
	private int secondTop;

	@SuppressWarnings("unchecked")
	public ArrayWithTwoStack(int size) {
		if (size < 2) {
			throw new IllegalArgumentException();
		}
		array = (T[]) new Object[size];
		firstTop = -1;
		secondTop = size;
	}

	public T push(int stackId, T value) {
		if (firstTop + 1 >= secondTop) {
			throw new StackOverflowError();
		}
		switch (stackId) {
		case 1:
			array[++firstTop] = value;
			break;
		case 2:
			array[--secondTop] = value;
			break;
		default:
			throw new IllegalArgumentException(" stackId can either be 1 or 2");
		}
		return value;
	}

	public T pop(int stackId) {
		switch (stackId) {
		case 1:
			if (firstTop == -1) {
				throw new EmptyStackException();
			}
			return array[firstTop--];
		case 2:
			if (secondTop == array.length) {
				throw new EmptyStackException();
			}
			return array[secondTop++];
		default:
			throw new IllegalArgumentException(" stackId can either be 1 or 2");
		}
	}

	public T peek(int stackId) {
		switch (stackId) {
		case 1:
			if (firstTop == -1) {
				throw new EmptyStackException();
			}
			return array[firstTop];
		case 2:
			if (secondTop == array.length) {
				throw new EmptyStackException();
			}
			return array[secondTop];
		default:
			throw new IllegalArgumentException(" stackId can either be 1 or 2");
		}
	}

	public boolean isEmpty(int stackId) {
		switch (stackId) {
		case 1:
			if (firstTop == -1) {
				return true;
			}
			break;
		case 2:
			if (secondTop == array.length) {
				return true;
			}
			break;
		default:
			throw new IllegalArgumentException(" stackId can either be 1 or 2");
		}
		return false;
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}
}

/*Output
  Character stack 
[A, C, E, G, I, K, M, O, Q, S, U, W, Y, Z, X, V, T, R, P, N, L, J, H, F, D, B]
------------------------------------------------------
 Integer stack 
[1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 20, 18, 16, 14, 12, 10, 8, 6, 4, 2]

 * */
