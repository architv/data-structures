package graphs;

public class GraphDirected {
	boolean[][] adjacencyMatrix;
	Vertex[] vertices;
	int vertexSize;
	int edgeSize;
	
	public GraphDirected () {
		adjacencyMatrix = new boolean[50][50];
		vertices = new Vertex[50];
	}
	
	public boolean isEmpty() {
		if (vertexSize == 0) {
			return true;
		}
		return false;
	}
	
	public Vertex findVertex(String name) {
		for (Vertex v : vertices) {
			if (v.name.equals(name)) {
				return v;
			}
		}
		return null;
	}
	
	public int numVertices() {
		return vertexSize;
	}
	
	public int numEdges() {
		return edgeSize;
	}
	
	public Vertex getVertex(int i) {
		return vertices[i];
	}
	
	public void addVertex(String name) {
		Vertex v = new Vertex();
		v.name = name;
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i] == null) {
				v.index = i;
				vertices[i] = v;
				vertexSize++;
				break;
			}
		}
	}
	
	public void addEdge (Vertex v1, Vertex v2, int direction) {
		if (direction == 0) {
			adjacencyMatrix[v1.index][v2.index] = true;
		} else {
			adjacencyMatrix[v2.index][v1.index] = true;
		}
		edgeSize++;
	}
	
	public void deleteVertex (String name) {
		Vertex toBedeleted = findVertex(name);
		if (toBedeleted != null) {
			for (int j = 0; j < adjacencyMatrix.length; j++) {
				adjacencyMatrix[toBedeleted.index][j] = false;
			}
			for (int i = 0; i < adjacencyMatrix[adjacencyMatrix.length].length; i++) {
				adjacencyMatrix[i][toBedeleted.index] = false;
			}
			
			vertices[toBedeleted.index] = null;
			vertexSize--;
		}
	}
	
	public void deleteEdge (Vertex v1, Vertex v2, int direction) {
		if (direction == 0) {
			adjacencyMatrix[v1.index][v2.index] = false;
		} else {
			adjacencyMatrix[v2.index][v1.index] = false;
		}
		edgeSize--;
	}
	
	public Vertex[] adjacentVertices (Vertex v) {
		int indexOfVertex = v.index;
		Vertex adjacentVertices[] = new Vertex[numVertices()];
		int index = 0;
		for (int j = 0; j < adjacencyMatrix.length; j++) {
			if (adjacencyMatrix[indexOfVertex][j]) {
				adjacentVertices[index++] = vertices[j];  
			}
		}
		return adjacentVertices;
	}
	
	public boolean isAdjacent (Vertex v1, Vertex v2) {
		if (v1 != null && v2 != null) {
			return adjacencyMatrix[v1.index][v2.index];
		}
		return false;
	}
}
