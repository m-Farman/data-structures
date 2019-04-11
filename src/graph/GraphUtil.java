package graph;

public abstract class GraphUtil {

	public static int[][] getAdjacencyMatrix() {
		int m, n;
		m = n = 5;
		int[][] matrix = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					matrix[i][j] = 1;
				}
			}
		}
		return null;
	}

	public static Graph<Integer> getGraph() {
		Graph<Integer> g = new Graph<>(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		return g;
	}

	public static Graph<Integer> getDAG() {
		Graph<Integer> g = new Graph<>(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		return g;
	}

	public static Graph<Character> getCharGraph() {
		Graph<Character> g = new Graph<Character>(4);
		g.addEdge('a', 'b');
		g.addEdge('a', 'c');
		g.addEdge('b', 'c');
		g.addEdge('c', 'a');
		g.addEdge('c', 'd');
		g.addEdge('d', 'd');
		g.addEdge('d', 'e');
		return g;
	}

}
