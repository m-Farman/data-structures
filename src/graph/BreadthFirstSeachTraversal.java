package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSeachTraversal {

	public static void main(String[] args) {
		Graph<Integer> graph = GraphUtil.getGraph();
		List<Integer> output = traverse(graph, 2);
		System.out.println("Bfs traversal of the graph is : " + output);
		System.out.println(traverse(GraphUtil.getCharGraph(), 'b'));
	}

	private static <V> List<V> traverse(Graph<V> graph, V source) {

		/* will contain the out bsf traversal */
		List<V> bfs = new ArrayList<>();
		/*
		 * visited will contain the vertex visited .ArrayList or LinkedList can also be
		 * used but verifying in that case will not be constant.
		 */
		HashSet<V> visited = new HashSet<>();
		/* queue store all the vertex at next level */
		Queue<V> queue = new LinkedList<>();
		queue.add(source);
		visited.add(source);

		while (!queue.isEmpty()) {
			V vertex = queue.poll();
			bfs.add(vertex);
			for (V w : graph.getAdjacentVertices(vertex)) {
				/* check if vertex has been visited and also the level in case of duplicate */
				if (!visited.contains(w)) {
					visited.add(w);
					queue.add(w);
				}
			}
		}

		return bfs;
	}
}

/*output
Bfs traversal of the graph is : [2, 0, 3, 1]
[b, c, a, d, e]
 * */
