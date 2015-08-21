import java.util.ArrayList;



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
		
		public boolean isVisited(){
			return this.visited;
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
		public Iterable<Item> adjList(){
			return adjList;
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