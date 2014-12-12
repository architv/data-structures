package graphs;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	public static void bfsUsingAL (GraphUsingAdjacencyList g, VertexUsingAL start, String toBeFound) {
		GenericsQueues<VertexUsingAL> q = new GenericsQueues<VertexUsingAL>();
		HashMap<VertexUsingAL, Boolean> visited = new HashMap<VertexUsingAL, Boolean>();
		q.enqueue(start);
		visited.put(start, true);
		
		while(!q.isEmpty()) {
			VertexUsingAL v = q.dequeue();
			if (v.name.equals(toBeFound)) {
				System.out.println("found");
				break;
			}
			VertexUsingAL[] adjacent = g.adjacentList(v);
			for (int i = 0; i < adjacent.length; i++) {
				if (!visited.containsKey(adjacent[i])) {
					q.enqueue(adjacent[i]);
				}
			}
			System.out.println("Not found");
		}
	}
	
	public static void dfsUsingAL (GraphUsingAdjacencyList g, VertexUsingAL start, String toBeFound) {
		HashMap<VertexUsingAL, Boolean> visited = new HashMap<VertexUsingAL, Boolean>();
		dfsUsingALHelp(g, start,toBeFound, visited);
	}
	
	private static  void dfsUsingALHelp (GraphUsingAdjacencyList g, VertexUsingAL start, 
			String toBeFound, HashMap<VertexUsingAL, Boolean> visited) {
		
		visited.put(start, true);
		if (start.name.equals(toBeFound)) {
			System.out.println("Found");
			return;
		}
		

		VertexUsingAL[] adjacent = g.adjacentList(start);
		
		for (int i = 0; i < adjacent.length; i++) {
			if (!visited.containsKey(adjacent[i])) {
				dfsUsingALHelp(g, adjacent[i], toBeFound, visited);
			}
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
	
	public static 
	
	public static void main(String[] args) {
//		Graph g = new Graph();
//		g.addVertex("D");
//		g.addVertex("G");
//		g.addVertex("F");
//		g.addVertex("N");
//		
//		Vertex D = g.findVertex("D");
//		Vertex G = g.findVertex("G");
//		Vertex F = g.findVertex("F");
//		Vertex N = g.findVertex("N");
//		
//		g.addEdge(D, G);
//		g.addEdge(D, F);
//		g.addEdge(D, N);
//		g.addEdge(G, F);
//		g.addEdge(F, N);
//		
//		bfs(g, D, "F");
//		dfs(g, D, "F");
		
		GraphUsingAdjacencyList g = new GraphUsingAdjacencyList();
		g.addVertex("D");
		g.addVertex("G");
		g.addVertex("F");
		g.addVertex("N");
		
		VertexUsingAL D = g.findVertex("D");
		VertexUsingAL G = g.findVertex("G");
		VertexUsingAL F = g.findVertex("F");
		VertexUsingAL N = g.findVertex("N");
		
//		System.out.print(D.name);
//		System.out.print(G.name);
//		System.out.print(F.name);
//		System.out.print(N.name);
		
		
		g.addEdge(D, G);
		g.addEdge(D, F);
		g.addEdge(D, N);
		g.addEdge(G, F);
		g.addEdge(F, N);
		
//		bfs(g, D, "F");
//		dfs(g, D, "F");
		
//		bfsUsingAL(g, D, "N");
		dfsUsingAL(g, D, "N");
	}
}
