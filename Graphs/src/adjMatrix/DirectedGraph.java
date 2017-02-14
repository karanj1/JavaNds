/* also includes Warshalls algorith to find Path matrix */
package adjMatrix;

public class DirectedGraph {

	public final int MAX_VERTICES = 30;
	int n; // number of vertices
	int e; // edges
	boolean[][] adj;
	Vertex[] vertexList;

	public DirectedGraph() {
		adj = new boolean[MAX_VERTICES][MAX_VERTICES];
		vertexList = new Vertex[MAX_VERTICES];
		// By default n=0, e=0
		// By default adj[u3][v]=false
	}

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
	
	public void Warshalls()
	{
		boolean [] [] p = new boolean [n] [n];
		
		for (int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				p[i][j] = adj[i][j];
		
		for (int k=0; k<n; k++)
		{
			for (int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					p[i][j] = ( p[i][j] || ( p[i][k] && p[k][j] ) );
		}
		
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n; j++)
				if (p[i][j])
					System.out.print("1 ");
				else
					System.out.print("0 ");
			System.out.println();
		}
	}

}
