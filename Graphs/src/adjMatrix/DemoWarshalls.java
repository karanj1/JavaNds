/* see DirectedGraph.java and method "public void Warshalls()" */

package adjMatrix;

public class DemoWarshalls {

	public static void main(String[] args) {
		
			DirectedGraph g = new DirectedGraph();
			
			g.insertVertex("Zero");
			g.insertVertex("One");
			g.insertVertex("Two");
			g.insertVertex("Three");
			
			g.insertEdge("Zero", "One");
			g.insertEdge("Zero", "Three");
			g.insertEdge("One", "Two");
			g.insertEdge("Two", "One");
			g.insertEdge("Three", "Zero");
			g.insertEdge("Three", "Two");
			
			g.Warshalls();
			
	}

}
