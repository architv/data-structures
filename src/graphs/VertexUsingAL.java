package graphs;

public class VertexUsingAL {
	String name;
	Node<EdgeUsingAL> adjacencyList;
	
//	public VertexUsingAL() {
////		edgeList = new ArrayList<EdgeUsingAL>();
//	}
	
	public int numEdges() {
		Node<EdgeUsingAL> tempEdge = adjacencyList;
		int numberOfEdges = 0;
		while (tempEdge != null) {
			tempEdge = tempEdge.next;
			numberOfEdges++;
		}
		return numberOfEdges;
	}
	
	public void addEdge(EdgeUsingAL edge) {
		Node<EdgeUsingAL> newEdgeNode = new Node<EdgeUsingAL>();
		newEdgeNode.data = edge;
		newEdgeNode.next = adjacencyList;
		adjacencyList = newEdgeNode;
	}
	
	public void removeEdgeWithVertex(VertexUsingAL v) {
		Node<EdgeUsingAL> currentEdge = adjacencyList;
		Node<EdgeUsingAL> previousEdge = null;
		while (currentEdge != null) {
			if (currentEdge.data.one == v || currentEdge.data.two == v) {
				if (previousEdge != null) {
					previousEdge.next = currentEdge.next;
				} else {
					adjacencyList =  currentEdge.next;
				}
			}
			previousEdge = currentEdge;
			currentEdge = currentEdge.next;
		}
	}
	
	public VertexUsingAL[] adjacentList() {
		VertexUsingAL output[] = new VertexUsingAL[numEdges()];
		Node<EdgeUsingAL> currentEdge = adjacencyList;
		int i = 0;
		while (currentEdge != null) {
			if (currentEdge.data.one == this) {
				output[i++] = currentEdge.data.two;
			} else {
				output[i++] = currentEdge.data.one;
			}
			currentEdge = currentEdge.next;
		}
		return output;
	}
	
	public boolean isAdjacent (VertexUsingAL v) {
		Node<EdgeUsingAL> currentEdge = this.adjacencyList;
		while (currentEdge != null) {
			if (currentEdge.data.one == v || currentEdge.data.two == v) {
				return true;
			}
			currentEdge = currentEdge.next;
		}
		return false;
	}
}
