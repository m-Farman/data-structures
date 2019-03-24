package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<V> {

	private int vertexCount;
	private List<V> vertices;
	private Map<V, LinkedList<V>> adj;

	public Graph(int size) {
		vertexCount = size;
		vertices = new ArrayList<>(size);
		adj = new HashMap<>(size);
	}

	public Graph<V> addEdge(V u, V w) {
		if (!adj.containsKey(u)) {
			adj.put(u, new LinkedList<>());
			vertices.add(u);
		}
		adj.get(u).add(w);
		return this;
	}

	public List<V> getAdjacentVertices(V vertex) {
		if (!adj.containsKey(vertex) || adj.get(vertex) == null) {
			return Collections.emptyList();
		}

		return Collections.unmodifiableList(adj.get(vertex));
	}

	public int size() {
		return vertexCount;
	}

}
