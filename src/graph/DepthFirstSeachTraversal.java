package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class DepthFirstSeachTraversal {

	public static void main(String[] args) {
		Graph<Integer> graph = GraphUtil.getGraph();
		List<Integer> output = traverse(graph, 2);
		System.out.println("Dfs traversal of the graph is : " + output);
		System.out.println(traverse(GraphUtil.getCharGraph(), 'b'));
	}

	private static <V> List<V> traverse(Graph<V> graph, V source) {

		Stack<V> stack = new Stack<>();
		HashSet<V> visited = new HashSet<>();
		List<V> traversalOrder = new ArrayList<>();

		stack.push(source);
		visited.add(source);
		while (!stack.isEmpty()) {
			V vertex = stack.pop();
			traversalOrder.add(vertex);
			for (V adjacent : graph.getAdjacentVertices(vertex)) {
				if (!visited.contains(adjacent)) {
					visited.add(adjacent);
					stack.push(adjacent);
				}

			}
		}
		return traversalOrder;
	}
}



/*output
 * 
Dfs traversal of the graph is : [2, 3, 0, 1]
[b, c, d, e, a]
 * */
