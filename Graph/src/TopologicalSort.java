import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort<Item> {
	int topoCount;// number of element in the topological order

	public void topologicalSort(Graph<Item> graph) {
		Map<Item, Vertex<Item>> map = graph.vertexDictionary();
		Queue<Vertex> queue = new LinkedList<Vertex>();
		for (Vertex<Item> vertex : map.values()) {
			if (vertex.getIndegree() == 0) {
				queue.add(vertex);
			}
		}
		while (!queue.isEmpty()) {
			Vertex<Item> vertex = queue.remove();
			System.out.println(vertex);
			for (Item item : vertex.adjList()) {
				Vertex<Item> vertexObject = graph.getVertex(item);

				vertexObject.setIndegree(vertexObject.getIndegree() - 1);
				if (vertexObject.getIndegree() == 0)
					queue.add(vertexObject);

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
		TopologicalSort<String> topSortObject = new TopologicalSort<String>();
		topSortObject.topologicalSort(graph);
	}
}
