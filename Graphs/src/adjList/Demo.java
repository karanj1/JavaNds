package adjList;
import java.util.Scanner;



public class Demo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		LinkedDigraph g = new LinkedDigraph(); 
		
		int choice;  
		String u,v;  
		
		while(true) 
		{ 
			System.out.println("l.Display Adjacency List"); 
			System.out.println("2.Insert a vertex"); 
			System.out.println("3.Delete an edge"); 
			System.out.println("4.lnsert an edge"); 
			System.out.println("5.Delete an edge"); 
			System.out.println("6.Display Indegree and outdegree of a vertex"); 
			System.out.println("7.Check if there is an edge between two vertices"); 
			System.out.println("8.Exit");
			System.out.print("Enter your choice : "); 
			choice = scan.nextInt();
			
			if(choice == 8)
				break;
			
			switch(choice)
			{
			case 1: 
				System.out.println("");
				g.display(); 		// display List
				System.out.println("Vertices = " + g.vertices()+ ", Edges = " + g.edges()); 		// no of vertices and edges
				break; 
			case 2: 
				System.out.print("Enter a vertex to be inserted : "); 
				u=scan.next(); 
				g.insertVertex(u); 
				break; 
			case 3: 
				System.out.print("Enter a vertex to be Deleted : "); 
				u=scan.next(); 
				g.deleteVertex(u); 
				break; 
			case 4: 
				System.out.print("Enter start and and vertices : "); 
				u=scan.next(); 
				v=scan.next(); 
				g.insertEdge(u,v); 
				break; 
			case 5: 
				System.out.print("Enter start and end vertices : "); 
				u=scan.next(); 
				v=scan.next(); 
				g.deleteEdge(u,u); 
				break;	
			case 6:
				System.out.print("Enter a vertex : "); 
				u = scan.next();
				System.out.println("InDegree is :  " + g.inDegree(u));
				System.out.println("OutDegree is :  " + g.outDegree(u));
				break;
			case 7:
				System.out.print("Enter two vertices : "); 
				u = scan.next();
				v = scan.next();
				if(g.edgeExists(u, v))			// directed from s1 to s2
					System.out.println("There is an edge from " + u + " to " + v);
				else
					System.out.println("There is no edge from " + u + " to " + v);
				
				if(g.edgeExists(v, u))			// directed from s2 to s1
					System.out.println("There is an edge from " + u + " to " + v);
				else
					System.out.println("There is no edge from " + u + " to " + v);
				break;
			default:
				System.out.println("Wrong choice"); 
				break;
			}
		}
		
		scan.close();
	}
}
