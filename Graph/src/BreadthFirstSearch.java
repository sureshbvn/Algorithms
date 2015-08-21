import java.util.LinkedList;

import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch<Item> {
	public void BFS(Graph<Item> graph) {
		Map<Item, Vertex<Item>> map = graph.vertexDictionary();
		for (Vertex<Item> vertex : map.values()) {
			if (!vertex.isVisited()) {
				BFSTraversal(graph, vertex);
			}

		}

	}

	public void BFSTraversal(Graph<Item> graph, Vertex<Item> vertex) {
		vertex.setDistance(0);
		vertex.setPrevious(null);
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(vertex);
		while (queue.size() > 0) {
			vertex = queue.remove();
			
			System.out.println(vertex);
			for (Item v : vertex.adjList()) {
				Vertex<Item> vertexObject = graph.getVertex(v);
				if (!vertexObject.isVisited()) {
					vertexObject.setVisited();
					vertexObject.setDistance(vertexObject.getDistance() + 1);
					vertexObject.setPrevious(vertex);
					queue.add(vertexObject);
				}

			}
		}

	}

	public static void main(String args[]) {

		Graph<String> graph = new Graph<String>(5);
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("C", "D");
		graph.addEdge("A", "D");
		graph.addEdge("B", "D");
		graph.addEdge("B", "E");
		graph.addEdge("D", "E");
		// graph.printGraph();
		BreadthFirstSearch<String> searchObject = new BreadthFirstSearch<>();

		searchObject.BFS(graph);

	}
}
