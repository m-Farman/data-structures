package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class TopologicalSort {

	public static void main(String[] args) {
		Graph<Integer> graph = GraphUtil.getDAG();
		sort(graph);
	}

	private static void sort(Graph<Integer> graph) {

		List<Integer> vertices = graph.getVertices();
		HashSet<Integer> visited = new HashSet<>(graph.size());
		Stack<Integer> visitedOrder = new Stack<>();
		for (Integer vertex : vertices) {
			if (!visited.contains(vertex)) {
				visit(vertex, graph, visited, visitedOrder);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!visitedOrder.isEmpty()) {
			sb.append(visitedOrder.pop() + " ");
		}
		// String output =
		// visitedOrder.stream().map(String::valueOf).collect(Collectors.joining(","));
		System.out.println(sb.toString());
	}

	private static void visit(Integer vertex, Graph<Integer> graph, HashSet<Integer> visited,
			Stack<Integer> visitedOrder) {

		visited.add(vertex);
		for (Integer adj : graph.getAdjacentVertices(vertex)) {

			if (!visited.contains(adj)) {
				visit(adj, graph, visited, visitedOrder);
			}
		}

		visitedOrder.push(vertex);

	}
}
