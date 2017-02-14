package DFSRecursiveTime;

/* this Demo program is not complete, please see video for better understanding */
/* see video https://www.udemy.com/data-structures-and-algorithms-in-java-2/learn/v4/t/lecture/3577416 */

public class Demo {

	public static void main(String[] args) {
		
		
		DirectedGraph g = new DirectedGraph ();  

		g.insertVertex("Zero"); 
		g.insertVertex("One"); 
		g.insertVertex("Two"); 
		g.insertVertex("Three"); 
		g.insertVertex("Four"); 
		g.insertVertex("Five"); 
		g.insertVertex("Six"); 
		g.insertVertex("Seven") ; 
		g.insertVertex("Eight"); 
		g.insertVertex("Nine");
		g.insertVertex("Ten"); 
		g.insertVertex("Eleven");  

		g.insertEdge("Zero","One"); 
		g.insertEdge("Zero","Three"); 
		g.insertEdge("One", "Two"); 
		g.insertEdge("One", "Four"); 
		g.insertEdge("One","Five"); 
		g.insertEdge("Two","Five"); 
		g.insertEdge("Two","Seven"); 
		g.insertEdge("Three","Six"); 
		g.insertEdge("Four", "Three"); 
		g.insertEdge("Five", "Three"); 
		g.insertEdge("Five","Six");
		g.insertEdge("Five","Eight"); 
		g.insertEdge("Seven", "Eight");
		g.insertEdge("Seven", "Ten");
		g.insertEdge("Eight", "Eleven"); 
		g.insertEdge("Nine", "Six");
		g.insertEdge("Eleven", "Nine"); 
		
		g.dfsTraversal();
		g.dfsTraversal_All();
	}

}
