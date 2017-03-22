import java.util.ArrayList;
import java.util.List;

public class MaximumPathSumI {

	public static void main(String[] args) {
		
		Graph graph = new Graph();
		initializeNodes(graph);
		
		List<Path> paths = new ArrayList<>();
		
		

	}

	private static void initializeNodes(Graph graph) {
		graph.rootNode = new Node();
		
	}
}

class Graph{
	
	Node rootNode;
	
	
}

class Path{
	
	List<Node> nodes = new ArrayList<>();
	
	public long getSum(){
		return nodes.stream().mapToLong(c -> c.value).sum();
	}
}

class Node{
	
	Node leftSon;
	
	Node rightSon;
	
	long value;
}