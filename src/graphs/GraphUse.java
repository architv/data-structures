package graphs;

import java.util.ArrayList;

import trees.GenericsQueues;

public class GraphUse {
	
	public static void bfs (Graph g, Vertex start, String toBeFound) {
		GenericsQueues<Vertex> q = new GenericsQueues<Vertex>();
		ArrayList<Vertex> visited = new ArrayList<Vertex>();
		q.enqueue(start);
		
		while (!q.isEmpty()) {
			Vertex vertexNode = q.dequeue();
			visited.add(vertexNode);
			if (toBeFound.equals(vertexNode.name)) {
				System.out.println("Found");
				break;
			}
			for (int j = 0; j < g.adjacencyMatrix.length; j++) {
				if (g.isAdjacent(g.getVertex(vertexNode.index), g.getVertex(j)) && !visited.contains(g.getVertex(j))) {
					q.enqueue(g.getVertex(j));
				}
			}
			System.out.println("Not Found");
		}
	}
	
	private static void dfsHelp (Graph g, Vertex start, String toBeFound, ArrayList<Vertex> visited) {
		
		if (start == null) {
			return;
		}
		
		if (start.name.equals(toBeFound)) {
			System.out.println("Found");
			return;	
		}
		
		visited.add(start);
		
		for (int j = 0; j < g.adjacencyMatrix.length; j++) {
			if (g.isAdjacent(g.getVertex(start.index), g.getVertex(j)) && !visited.contains(g.getVertex(j))) {
				dfsHelp(g, g.getVertex(j), toBeFound, visited);
			}
		}
	}

	public static void dfs (Graph g, Vertex start, String toBeFound) {
		ArrayList<Vertex> visited = new ArrayList<Vertex>();
		dfsHelp(g, start, toBeFound, visited);
	}
	
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex("D");
		g.addVertex("G");
		g.addVertex("F");
		g.addVertex("N");
		
		Vertex D = g.findVertex("D");
		Vertex G = g.findVertex("G");
		Vertex F = g.findVertex("F");
		Vertex N = g.findVertex("N");
		
		g.addEdge(D, G);
		g.addEdge(D, F);
		g.addEdge(D, N);
		g.addEdge(G, F);
		g.addEdge(F, N);
		
		bfs(g, D, "F");
		dfs(g, D, "F");
	}
}
