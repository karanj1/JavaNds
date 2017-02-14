package BellmanFord;

public class Demo {

	public static void main(String[] args) {
		
		
		DirectedWeightedGraph g = new DirectedWeightedGraph ();  

		g.insertVertex("Zero"); 
		g.insertVertex("One"); 
		g.insertVertex("Two"); 
		g.insertVertex("Three"); 
		g.insertVertex("Four"); 
		g.insertVertex("Five"); 
		//g.insertVertex("Six"); 
		//g.insertVertex("Seven") ; 
		//g.insertVertex("Eight"); 

		g.insertEdge("Zero","One", 10); 
		g.insertEdge("Zero","Three", 3); 
		g.insertEdge("One", "Two", 2); 
		g.insertEdge("One","Four" , -3); 		//If you increase this -3 to -2 than below weight needs to be decreased -3 or lower to see negative circuit
		g.insertEdge("Two", "One", -1);		// decrease this weight to -2 to lower to see negative circuit(negative looping)
		g.insertEdge("Three","Four", 3);
		g.insertEdge("Four", "Five", 1); 
		g.insertEdge("Four", "Two", 4); 
		g.insertEdge("Five","Two", 4);
		
		//g.insertEdge("Six", "Seven", 9);
		//g.insertEdge("Six", "Three", 5); 
		//g.insertEdge("Seven","Five", 3); 
		//g.insertEdge("Seven", "Eight", 5);
		//g.insertEdge("Eight", "Five", 3); 
		
		
		g.findPaths("Zero");
	}

}
