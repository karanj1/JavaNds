
package DFSUndirectedClasifyEdges;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DirectedGraph {

	public final int MAX_VERTICES = 30;
	int n; // number of vertices
	int e; // edges
	boolean[][] adj;
	Vertex[] vertexList;
	
	//* constants for different states of a vertex */
	private static int time;
	private static boolean hasCycle;
	private static final int INITIAL = 0;
	private static final int VISITED = 1;
	private static final int FINISHED = 2;
	

	public DirectedGraph() {
		adj = new boolean[MAX_VERTICES][MAX_VERTICES];
		vertexList = new Vertex[MAX_VERTICES];
		// By default n=0, e=0
		// By default adj[u3][v]=false
	}
	
	/*  DFS traversals ===================================== -------------------------------------------------------------------------- */
	public void dfsTraversal()
	{
		for (int v=0; v<n; v++)
			vertexList[v].state = INITIAL;
		
		time = 0;
		Scanner scan = new Scanner(System.in); 
		System.out.println("Enter Starting Vertex for Breadth First Search : ");
		String	s = scan.next();
		dfs(getIndex(s));
		
		//for(int v=0; v<n; v++)  
		//{ 
		//	System.out.println("Vertex " + vertexList[v]); 
		//	System.out.print(" Discovery time — " + vertexList[v].discoveryTime); 
		//	System.out.println(" Finishing time — " + vertexList[v].finishingTime);
		//}
	}
	
	public void dfsTraversal_All()
	{	
		int v;
		for (v=0; v<n; v++)
			vertexList[v].state = INITIAL;
		
		time = 0;
		Scanner scan = new Scanner(System.in); 
		System.out.println("\n\nEnter Starting Vertex for Breadth First Search : ");
		String	s = scan.next();
		dfs(getIndex(s));		//dfs of starting vetex
		
		// when the dfs() of the start vertex is finished, we check status of all the vertices one by one :
		for(v=0; v<n; v++)
			if(vertexList[v].state == INITIAL)
				dfs(v);
	}
	
	private void dfs(int v) 	// recursive method
	{
		System.out.print(vertexList[v] + " ");
		vertexList[v].state = VISITED;
		
		for(int i=0; i<n; i++)  
		{ 
			if(isAdjacent(v,i) && vertexList[v].predecessor != i)		//checking (i, v)// if i is predecessor of v// but now (v,i) => (i,v) // see video at 3:30 (" https://www.udemy.com/data-structures-and-algorithms-in-java-2/learn/v4/t/lecture/3577418 ")
			{
				if(vertexList[i].state == INITIAL)
				{
					vertexList[i].predecessor = v;		//recording the predecessors for  (v, i) // v is predecessor for i
					System.out.println("Tree Edge - (" + vertexList[v] + ", "+ vertexList[i] +")");
					dfs(i);
				}
				else if(vertexList[i].state == VISITED)
				{
					System.out.println("Back Edge - (" + vertexList[v] + ", "+ vertexList[i] +")");
				}
			}
		}
		vertexList[v].state = FINISHED;
	}
	/* DFS ========================================== ----------------------------------------------------------------------------- */
	
	
	/* Is Cyclic?? -------------------------------------------------*/
	
	public boolean isCyclic()  
	{  
		int v; 
		for(v=0; v<n; v++) 
			vertexList[v].state = INITIAL;  
		
		hasCycle=false;  
		
		for(v=0; v<n; v++) 
			if(vertexList[v].state == INITIAL) 
				dfsC(v); 
		return hasCycle;  // it gets reference from dfsC() method below, if updated by that method.
	}
	
	private void dfsC(int v)  
	{ 
		vertexList[v].state = VISITED;
		
		for(int i=0; i<n; i++)  
		{ 
			if(isAdjacent(v,i) && vertexList[v].predecessor != i) 
			{ 
				if(vertexList[i].state == INITIAL) 
				{
					vertexList[i].predecessor = v;		//recording the predecessors for  (v, i) // v is predecessor for i
					dfsC(i);
				}
				else if(vertexList[i].state == VISITED) /* checking for back edge” */ 
					hasCycle=true;
			} 
		}  
		vertexList[v].state = FINISHED;
	}
	
	///////////////////////////////////////////////////////////////////////

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
			e--;
		}
	}
	
	public int outdegree(String s)
	{
		int u = getIndex(s);		// get the row number
		
		int out = 0;
		
		for(int v=0; v<n; v++)		// sum through row
			if(adj[u][v])
				out ++;
		
		return out;
	}
	
	public int indegree(String s)
	{
		int v = getIndex(s);		// get the column index
		
		int in = 0;
		
		for(int u=0; u<n; u++)		// sum through column
			if(adj[u][v])
				in ++;
		
		return in;
	}
	
}
