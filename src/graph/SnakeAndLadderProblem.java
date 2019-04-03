package graph;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/snake-ladder-problem-2/
public class SnakeAndLadderProblem {

	public static void main(String[] args) {
		int n = 30;
		int moves[] = new int[n];
		for (int i = 0; i < n; i++)
			moves[i] = -1;

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;

		int output = findMinDiceThrows(n, moves);
		System.out.println(output);
	}

	private static int findMinDiceThrows(int n, int[] moves) {

		boolean[] visited = new boolean[n];
		Queue<GraphNode> queue = new LinkedList<>();
		GraphNode graphNode = new GraphNode(0, 0);

		queue.add(graphNode);
		visited[0] = true;

		while (!queue.isEmpty()) {

			graphNode = queue.poll();

			if (graphNode.vertexValue == n - 1) {
				break;
			}

			for (int i = graphNode.vertexValue + 1; i <= (graphNode.vertexValue + 6) && i < n; i++) {

				if (!visited[i]) {

					GraphNode adj = new GraphNode();
					adj.distance = graphNode.distance + 1;
					visited[i] = true;

					if (moves[i] != -1) {
						adj.vertexValue = moves[i];
					} else {
						adj.vertexValue = i;
					}

					queue.offer(adj);
				}

			}

		}

		return graphNode.distance;
	}
}

class GraphNode {

	int vertexValue;
	int distance;

	public GraphNode() {
		super();
	}

	public GraphNode(int vertexValue, int distance) {
		super();
		this.vertexValue = vertexValue;
		this.distance = distance;
	}

}
