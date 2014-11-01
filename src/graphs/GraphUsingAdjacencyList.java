package graphs;

import java.util.ArrayList;

public class GraphUsingAdjacencyList {
	
	int vertexSize;
	int edgeSize;
	ArrayList<VertexUsingAL> vertices;
	
	
	public GraphUsingAdjacencyList() {
		vertices = new ArrayList<VertexUsingAL>();
	}
	 
	public boolean isEmpty() {
		return vertices.isEmpty();
	}
	
	public int numVertices() {
		return vertices.size();
	}
	
	public int numEdges() {
		int totalEdges = 0;
		for (int i = 0; i < vertices.size(); i++) {
			totalEdges += vertices.get(i).numEdges();
		}
		return totalEdges/2;
	}
	
	public VertexUsingAL findVertex(String name) {
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).name.equals(name)) {
				return vertices.get(i);
			}
		}
		return null;
	}
	
	public VertexUsingAL getVertex(int i) {
		if (i >= numVertices()) {
			return null;
		}
		return vertices.get(i);
	}
	
	public void addVertex (String name) {
		VertexUsingAL v = new VertexUsingAL();
		v.name = name;
		vertices.add(v);
	}
	
	public void addEdge (VertexUsingAL one, VertexUsingAL two) {
		EdgeUsingAL edge = new EdgeUsingAL();
		edge.one = one;
		edge.two = two;
		one.addEdge(edge);
		two.addEdge(edge);
	}
	
	public void deleteVertex (VertexUsingAL v) {
		vertices.remove(v);
		VertexUsingAL[] adjacentList = adjacentList(v);
		for (int i = 0; i < adjacentList.length; i++) {
			adjacentList[i].removeEdgeWithVertex(v);
		}
	}
	
	public void deleteEdge (EdgeUsingAL e) {
		e.one.removeEdgeWithVertex(e.two);
		e.two.removeEdgeWithVertex(e.one);
	}
	
	public VertexUsingAL[] adjacentList (VertexUsingAL v) {
		return v.adjacentList();
	}
	
	public boolean isAdjacent (VertexUsingAL v1, VertexUsingAL v2) {
		return v1.isAdjacent(v2);
	}
}
