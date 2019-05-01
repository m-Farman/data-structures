package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Stream;

//https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
public class FindOrderOfCharacterOfAlienLanguage {

	public static void main(String[] args) {

		String words[] = { "baa", "abcd", "abca", "cab", "cad" };
		List<Character> order = findOrder(words);
		System.out.println("Alphabetical order of alien language : \n" + order);

	}

	private static List<Character> findOrder(String[] words) {

		int uniqueCharCount = (int) Stream.of(words).flatMap(w -> Stream.of(w.split(""))).distinct().count();
		Graph<Character> graph = new Graph<>(uniqueCharCount);

		int length = 0;
		for (int i = 0; i < words.length - 1; i++) {
			String first = words[i];
			String second = words[i + 1];
			length = Math.min(first.length(), second.length());
			for (int j = 0; j < length; j++) {
				if (first.charAt(j) != second.charAt(j)) {
					graph.addEdge(first.charAt(j), second.charAt(j));
				}
			}
		}

		Stack<Character> topSort = new Stack<>();
		Set<Character> visited = new HashSet<>();
		topologicalSort(graph, words[0].charAt(0), visited, topSort);

		List<Character> output = new ArrayList<>(topSort.size());
		while (!topSort.isEmpty()) {
			output.add(topSort.pop());
		}
		return output;
	}

	private static void topologicalSort(Graph<Character> graph, Character vertex, Set<Character> visited,
			Stack<Character> topSort) {

		visited.add(vertex);
		for (Character adj : graph.getAdjacentVertices(vertex)) {
			if (!visited.contains(adj)) {
				topologicalSort(graph, adj, visited, topSort);
			}
		}

		topSort.push(vertex);
	}

}

/*
 * output
 * 
Alphabetical order of alien language : 
[b, d, a, c]

 */
