import java.util.HashMap;

/**
 * @author sureshbvn
 *
 * @param <Item>
 *            Generic graph class
 *            
 *            
 *            
 */

public class Graph<Item> {
	private int numberOfVertices;
	private HashMap<Item, Vertex<Item>> listarray;

	

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
		Vertex<Item> vertex1=listarray.get(vertex1_id);
		Vertex<Item> vertex2=listarray.get(vertex2_id);
		vertex1.addNeighbour(vertex2_id);
		//vertex2.addNeighbour(vertex1_id);//uncomment this line for undirected graph
		vertex1.setOutDegre(vertex1.getOutDegree()+1);
		vertex2.setIndegree(vertex2.getIndegree()+1);
		System.out.println("The indegree of vertex"+vertex2+"is"+vertex2.getIndegree());
		

	}

	/**
	 * Printing the contents of the graph.
	 */
	public void printGraph() {
		for (Item item : listarray.keySet()) {
			System.out.println(listarray.get(item).stringRepresentation());

		}

	}
	public Vertex<Item> getVertex(Item vertexId){
		return this.vertexDictionary().get(vertexId);
		
	}
	public HashMap<Item, Vertex<Item>> vertexDictionary(){
		return listarray;
	} 
	public int numOfVertices(){
		return this.numberOfVertices;
	}

	public static void main(String args[]) {
		Graph<String> graph = new Graph<String>(4);
		graph.addVertex("A");
		graph.addEdge("A", "B");
		graph.addEdge("B", "C");
		graph.printGraph();

	}
}
