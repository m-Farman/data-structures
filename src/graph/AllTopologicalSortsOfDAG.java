package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class AllTopologicalSortsOfDAG {

	public static void main(String[] args) {
		Graph<Integer> graph = GraphUtil.getDAG();
		printAll(graph);
	}

	private static void printAll(Graph<Integer> graph) {

		HashMap<Integer, Integer> indegree = new HashMap<>(graph.size());
		graph.getVertices().stream().forEach(v -> indegree.put(v, 0));

		for (Integer vertex : graph.getVertices()) {
			for (Integer adj : graph.getAdjacentVertices(vertex)) {
				indegree.put(adj, indegree.get(adj) + 1);
			}
		}

		Stack<Integer> sortOrder = new Stack<>();
		HashSet<Integer> visited = new HashSet<>();
		findSortOrder(visited, graph, indegree, sortOrder);

	}

	private static void findSortOrder(HashSet<Integer> visited, Graph<Integer> graph,
			HashMap<Integer, Integer> indegree, Stack<Integer> sortOrder) {

		for (Integer vertex : graph.getVertices()) {

			if (!visited.contains(vertex) && indegree.get(vertex) == 0) {

				visited.add(vertex);
				sortOrder.push(vertex);
				for (Integer adj : graph.getAdjacentVertices(vertex)) {
					indegree.put(adj, indegree.get(adj) - 1);
				}

				findSortOrder(visited, graph, indegree, sortOrder);
				
				visited.remove(vertex);
				sortOrder.pop();
				for (Integer adj : graph.getAdjacentVertices(vertex)) {
					indegree.put(adj, indegree.get(adj) + 1);
				}

			}
		}

		if (sortOrder.size() == graph.size()) {
			System.out.println(sortOrder);
		}
	}
}



/*output
 * 
 * 
 * 
[4, 5, 0, 2, 3, 1]
[4, 5, 2, 0, 3, 1]
[4, 5, 2, 3, 0, 1]
[4, 5, 2, 3, 1, 0]
[5, 2, 3, 4, 0, 1]
[5, 2, 3, 4, 1, 0]
[5, 2, 4, 0, 3, 1]
[5, 2, 4, 3, 0, 1]
[5, 2, 4, 3, 1, 0]
[5, 4, 0, 2, 3, 1]
[5, 4, 2, 0, 3, 1]
[5, 4, 2, 3, 0, 1]
[5, 4, 2, 3, 1, 0]
 * 
 * 
 * */
