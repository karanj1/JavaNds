package bfsTreeEdges;

/* https://www.udemy.com/data-structures-and-algorithms-in-java-2/learn/v4/t/lecture/3580940 */

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

		g.insertEdge("Zero","One"); 
		g.insertEdge("Zero","Three"); 
		g.insertEdge("One", "Two"); 
		g.insertEdge("One", "Four"); 
		g.insertEdge("One","Five"); 
		g.insertEdge("Two","Three"); 
		g.insertEdge("Two","Five"); 
		g.insertEdge("Three","Six"); 
		g.insertEdge("Four", "Five"); 
		g.insertEdge("Four", "Seven"); 
		g.insertEdge("Five","Six");
		g.insertEdge("Five","Eight"); 
		g.insertEdge("Six", "Eight");
		g.insertEdge("Six", "Nine"); 
		g.insertEdge("Seven", "Eight");
		g.insertEdge("Eight", "Nine"); 
		
		g.bfsTreeEdges();
	}

}
