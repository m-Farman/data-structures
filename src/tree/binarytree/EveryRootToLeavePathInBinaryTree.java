package tree.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import tree.TreeNode;
import tree.TreeUtil;

public class EveryRootToLeavePathInBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.createTreeOfSize(12);
		Integer[] path = new Integer[10];
		pritPath(root, path, 0);
		pritPath(root, new ArrayList<>(), 0);
	}

	public static <E> void pritPath(TreeNode<E> root, E[] path, int index) {

		if (root == null) {
			return;
		}
		path[index] = root.getData();
		if (root.getLeft() == null && root.getRight() == null) {
			System.out.println(printArray(path));
		} else {
			pritPath(root.getLeft(), path, index + 1);
			pritPath(root.getRight(), path, index + 1);
		}
		path[index] = null;

	}

	public static <E> String printArray(E[] path) {
		return Stream.of(path).filter(Objects::nonNull).map(String::valueOf)
				.collect(Collectors.joining(", ", "[", "]"));
	}

	public static <E> void pritPath(TreeNode<E> root, ArrayList<E> path, int index) {

		if (root == null) {
			return;
		}
		path.add(root.getData());
		if (root.getLeft() == null && root.getRight() == null) {
			System.out.println(path);
		} else {
			pritPath(root.getLeft(), path, index + 1);
			pritPath(root.getRight(), path, index + 1);
		}
		path.remove(index);

	}

}
