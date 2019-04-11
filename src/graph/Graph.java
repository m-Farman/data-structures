package graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<V> {

	private int vertexCount;
	private Set<V> vertices;
	private Map<V, LinkedList<V>> adj;

	public Graph(int size) {
		vertexCount = size;
		vertices = new HashSet<>(size);
		adj = new HashMap<>(size);
	}

	public Graph<V> addEdge(V u, V w) {
		if (!adj.containsKey(u)) {
			adj.put(u, new LinkedList<>());
			vertices.add(u);
			vertices.add(w);
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

	public Set<V> getVertices() {
		return Collections.unmodifiableSet(vertices);
	}
}
