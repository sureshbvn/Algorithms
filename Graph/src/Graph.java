import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author sureshbvn
 *
 * @param <Item>
 *            Generic graph class
 */
public class Graph<Item> {
	private int numberOfVertices;
	private HashMap<Item, Vertex<Item>> listarray;

	public class Vertex<Item> {
		
		private Item vertexId;
		private int inDegree;
		private int outDegree;
		
		private boolean visited;
		private ArrayList<Item> adjList;
		private int distance = Integer.MAX_VALUE;
		private Vertex<Item> previous;

		public Vertex(Item vertexId) {
			this.vertexId = vertexId;
			this.inDegree = 0;
			this.adjList = new ArrayList<Item>();
			this.visited = false;
			this.previous = null;

		}

		/**
		 * @return the indegree of the vertex
		 */
		public int getIndegree() {
			return this.inDegree;
		}

		/**
		 * @return the outdegree of the vertex
		 */
		public int getOutDegree() {
			return this.outDegree;
		}

		/**
		 * make the specific vertex visited.
		 */
		public void setVisited() {
			this.visited = true;
		}

		/**
		 * @param distance
		 *            variable is used when we are calculating distance from
		 *            specific vertex
		 */
		public void setDistance(int distance) {
			this.distance = distance;
		}

		/**
		 * @return the distance from specific vertex
		 */
		public int getDistance() {
			return this.distance;
		}

		/**
		 * @param set
		 *            the parent vertex for a vertex
		 */
		public void setPrevious(Vertex<Item> previous) {
			this.previous = previous;
		}

		/**
		 * @return get the previous element of the vertex in the Visited Path
		 */
		public Vertex<Item> getPrevious() {
			return previous;

		}

		/**
		 * add the adjacent vertices to the list
		 * 
		 * @param vertex
		 *            is the adjacent vertex
		 * 
		 */
		public void addNeighbour(Item vertexid) {
			adjList.add(vertexid);
		}

		public String toString() {
			StringBuilder stringOutput = new StringBuilder();
			stringOutput.append((String) vertexId);

			return stringOutput.toString();

		}

		/**
		 * @return the vertex representation in the following format. vertex:
		 *         neighbours of the Vertex
		 */
		public String stringRepresentation() {
			StringBuilder stringOutput = new StringBuilder();
			stringOutput.append((String) vertexId + ":");
			for (Item w : adjList) {
				stringOutput.append(w + " ");
			}

			return stringOutput.toString();
		}

	}

	/**
	 * @param numberOfVertices
	 *            with which the graph has to be constructed.
	 */
	public Graph(int numberOfVertices) {
		listarray = new HashMap<Item, Vertex<Item>>();

	}

	/**
	 * @param vertexId
	 *            Add a vertex to the Graph with given VertexId
	 */
	public void addVertex(Item vertexId) {
		Vertex<Item> vertex = new Vertex<Item>(vertexId);
		this.numberOfVertices += 1;
		listarray.put(vertexId, vertex);
		// System.out.println(vertex.stringRepresentation());

	}

	/**
	 * @param vertex1_id
	 * @param vertex2_id
	 *            The function addEdge takes to parameters.They are id's of the
	 *            vertices. An edge is formed between them.
	 */
	public void addEdge(Item vertex1_id, Item vertex2_id) {
		if (!listarray.containsKey(vertex1_id))
			addVertex(vertex1_id);
		if (!listarray.containsKey(vertex2_id))
			addVertex(vertex2_id);
		listarray.get(vertex1_id).addNeighbour(vertex2_id);
		listarray.get(vertex2_id).addNeighbour(vertex1_id);

	}

	/**
	 * Printing the contents of the graph.
	 */
	public void printGraph() {
		for (Item item : listarray.keySet()) {
			System.out.println(listarray.get(item).stringRepresentation());

		}

	}

	public static void main(String args[]) {
		Graph<String> graph = new Graph<String>(4);
		graph.addVertex("A");
		graph.addEdge("A", "B");
		graph.addEdge("B", "C");
		graph.printGraph();

	}
}
