
public class DepthFirstSearch<Item> {
	
	int v;// to see if there is a path to all vertices from given source
	public DepthFirstSearch(Graph<Item> graph,Item source){
		//marked=new boolean[graph.numOfVertices()];
		v=0;
		dfs(graph,source);
	}
	void dfs(Graph<Item> graph,Item source){
		Vertex<Item> vertex=graph.vertexDictionary().get(source);
		vertex.setVisited();
		System.out.println(source);
		for(Item item:vertex.adjList()){
			vertex=graph.vertexDictionary().get(item);
			if(!vertex.isVisited()){
				dfs(graph,item);
			}
		}
	}
	
	public static void main(String args[]){
		Graph<String> graph=new Graph<String>(5);
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("C", "D");
		graph.addEdge("A", "D");
		graph.addEdge("B", "D");
		graph.addEdge("B", "E");
		graph.addEdge("D", "E");
		graph.printGraph();
		DepthFirstSearch<String> search=new DepthFirstSearch<String>(graph, "A");
		
		
		
	}

}
