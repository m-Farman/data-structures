package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPathInUnWeightedGraph {

	public static void main(String[] args) {
		Graph<Integer> graph = GraphUtil.getGraph();
		findShortestPath(graph, 0);
	}

	private static void findShortestPath(Graph<Integer> graph, Integer source) {

		Map<Integer, Integer> predecessor = new HashMap<>();
		Set<Integer> visited = new HashSet<>();

		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		visited.add(source);
		predecessor.put(source, null);
		while (!queue.isEmpty()) {
			Integer vertex = queue.poll();

			for (Integer adj : graph.getAdjacentVertices(vertex)) {
				if (!visited.contains(adj)) {
					queue.add(adj);
					predecessor.put(adj, vertex);
					visited.add(adj);
				}
			}

		}

		int pathLen = 0;
		for (Integer vertex : graph.getVertices()) {
			if (vertex.equals(source)) {
				continue;
			}

			System.out.println("Shorted path from " + source + " to " + vertex);
			pathLen = 0;
			System.out.print(vertex + " ");
			while (predecessor.get(vertex) != null) {
				pathLen++;
				vertex = predecessor.get(vertex);
				System.out.print(vertex + " ");
			}
			System.out.println("Path length is " + pathLen);

		}

	}

}
/*output
 * 
Shorted path from 0 to 1
1 0 Path length is 1
Shorted path from 0 to 2
2 0 Path length is 1
Shorted path from 0 to 3
3 2 0 Path length is 2
 
 * */
