/* https://www.udemy.com/data-structures-and-algorithms-in-java-2/learn/v4/t/lecture/3577408 */
package bfsUndirected;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UndirectedGraph {
	
	public final int MAX_VERTICES = 30;
	int n; // number of vertices
	int e; // edges
	boolean[][] adj;
	Vertex[] vertexList;
	
	//* constants for different states of a vertex */
		private static final int INITIAL = 0;
		private static final int WAITING = 1;
		private static final int VISITED = 2;
		

	public UndirectedGraph() {
		adj = new boolean[MAX_VERTICES][MAX_VERTICES];
		vertexList = new Vertex[MAX_VERTICES];
		// By default n=0, e=0
		// By default adj[u3][v]=false
	}
	
	
	/*  BFS traversals ===================================== -------------------------------------------------------------------------- */
	public void bfsTraversal()
	{
		for (int v=0; v<n; v++)
			vertexList[v].state = INITIAL;
		
		Scanner scan = new Scanner(System.in); 
		System.out.println("Enter Starting Vertex for Breadth First Search : ");
		String	s = scan.next();
		bfs(getIndex(s));
	}
	
	public void bfsTraversal_All()   //for Undirected-connected Graph bfsTraversal() will give same results as bfsTraversal_All() because traversal can be done regardless of direction. 
	{	
		int v;
		for (v=0; v<n; v++)
			vertexList[v].state = INITIAL;
		
		Scanner scan = new Scanner(System.in); 
		System.out.println("Enter Starting Vertex for Breadth First Search : ");
		String	s = scan.next();
		bfs(getIndex(s));		//bfs of starting vetex
		
		// when the bfs() of the start vertex is finished, we check status of all the vertices one by one :
		for(v=0; v<n; v++)
			if(vertexList[v].state == INITIAL)
				bfs(v);
	}
	
	private void bfs(int v) 
	{
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.add(v);
		vertexList[v].state = WAITING;
		
		while(!qu.isEmpty())
		{
				v = qu.remove(); 
				System.out.print(vertexList[v] + " "); 
				vertexList[v].state = VISITED;  
				
				for(int i=0; i<n; i++)  
				{ 
					if(isAdjacent(v,i) && vertexList[i].state == INITIAL) 
					{ 
						qu.add(i); 
						vertexList[i].state=WAITING; 
					}
				}
			}
			System.out.println();
	}
	/* BFS ========================================== ----------------------------------------------------------------------------- */


	public int vertices() {
		return n;
	}

	public int edges() {
		return e;
	}

	public void display() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				if (adj[i][j])
					System.out.print("1 ");
				else
					System.out.print("0 ");
			System.out.println();
		}
	}

	public void insertVertex(String name) {
		vertexList[n++] = new Vertex(name);		// add vertex and also increase number of vertices(n++)
	}

	private int getIndex(String s) {
		for (int i = 0; i < n; i++)
			if (s.equals(vertexList[i].name))
				return i;
		throw new RuntimeException("Invalid Vertex");
	}

	public boolean edgeExists(String s1, String s2) {
		return isAdjacent(getIndex(s1), getIndex(s2));
	}

	public boolean isAdjacent(int u, int v)
	{
		return adj[u][v];
	}

	public void insertEdge(String s1, String s2)  
	{ 
		int u = getIndex(s1);  
		int v = getIndex(s2); 
		if(u==v) 
			throw new IllegalArgumentException("Not a valid edge"); 
		if(adj[u][v] == true) 
			System.out.print("Edge already present"); 
		else  
		{ 
			adj[u][v]=true;
			adj[v][u]=true;
			e++;		// increase the number of vertices
		}
	}
	
	public void deleteEdge(String s1, String s2)  
	{ 
		int u = getIndex(s1);  
		int v = getIndex(s2); 
		
		if(adj[u][v] == false) 
			System.out.print("Edge not present"); 
		else  
		{ 
			adj[u][v]=false;
			adj[v][u]=false;
			e--;
		}
	}
	
	public int degree(String s)
	{
		int u = getIndex(s);		// get the row number
		
		int deg = 0;
		
		for(int v=0; v<n; v++)		// sum through row
			if(adj[u][v])
				deg ++;
		
		return deg;
	}
	
}
