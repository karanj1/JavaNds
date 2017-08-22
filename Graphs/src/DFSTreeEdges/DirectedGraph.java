
package DFSTreeEdges;

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
	private static final int INITIAL = 0;
	private static final int VISITED = 1;
	
	private static final int NIL = -1;

	public DirectedGraph() {
		adj = new boolean[MAX_VERTICES][MAX_VERTICES];
		vertexList = new Vertex[MAX_VERTICES];
		// By default n=0, e=0
		// By default adj[u3][v]=false
	}
	
	/*  DFS tree Edges ===================================== -------------------------------------------------------------------------- */
	public void dfsTreeEdges()
	{
		int v;
		for(v=0; v<n; v++)
		{
			vertexList[v].state = INITIAL;
			vertexList[v].predecessor = NIL;
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Starting vertex for Breadth first Search : ");
		String s = scan.next();
		
		dfs(getIndex(s));
		
		// when the bfs() of the start vertex is finished, we check status of all the vertices one by one (BFS spanning tree Forest) :
		for(v=0; v<n; v++)
			if(vertexList[v].state == INITIAL)
				dfs(v);
		
		System.out.println("tree Edges : "); 
		int u; 
		for(v=0; v<n; v++) 
		{ 
			u = vertexList[v].predecessor; 
			if(u!=NIL)  
				System.out.println("(" + vertexList[u] + ", " + vertexList[v] +")");
		}
	}
	
	private void dfs(int v) 
	{
		Stack<Integer> st = new Stack<Integer>();
		st.push(v);
		
		while(!st.isEmpty())
		{
				v = st.pop(); 
				if(vertexList[v].state == INITIAL) // It is possible that nodes comes repeated, so this is to avoid printing already visited nodes // see video "Implementation of dfs through stack"
				{
					System.out.print(vertexList[v] + " ");
					vertexList[v].state = VISITED;
				}
				
				for(int i=n-1; i>=0; i--)  
				{ 
					if(isAdjacent(v,i) && vertexList[i].state == INITIAL) 
					{
						st.push(i);
						vertexList[i].predecessor = v;
					}
				}
			}
			System.out.println();
	}
	/* DFS ========================================== ----------------------------------------------------------------------------- */

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
