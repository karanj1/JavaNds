package FloydWarshall;

public class DirectedWeightedGraph {
	
	public final int MAX_VERTICES = 30;
	int n; // number of vertices
	int e; // edges
	int[][] adj;
	Vertex[] vertexList;
	
	//* constants for different states of a vertex */
			private static final int NIL = -1;		// to initialize predecessor
			private static final int INFINITY = 99999;		// to Initialize the pathLength

	public DirectedWeightedGraph() {
		adj = new int[MAX_VERTICES][MAX_VERTICES];
		vertexList = new Vertex[MAX_VERTICES];
		// By default n=0, e=0
		// By default adj[u3][v]=0
	}
	
	/* Floyd-Warshall ===========================================================----------------------------------------------------------- */
	
	public void FloydWarshall()
	{	
		int [] [] dist = new int [n] [n];
		
		for (int i=0; i<n; i++)
			for(int j=0; j<n; j++)
			{
				 if (i == j) {
					 dist[i][j] = 0;
	             } 
				 else if (adj[i][j] != 0){
					 dist[i][j] = adj[i][j];
				 }
				 else
					 dist[i][j] = INFINITY;
			}
		
		for (int k=0; k<n; k++)
			for (int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					if(dist[i][k] + dist[k][j] < dist[i][j])		// v is adjacent vertex of c and has temporary status
						dist[i][j] = dist[i][k] + dist[k][j];   //RELAXING : Consider an edge u --> v where u is the start and v is the end vertex respectively. Relaxing an edge means to find shorter path to reach v when considering edge u --> v
		
		for(int i=0; i<n; i++)
		{
			if(dist[i][i] < 0)
				
			{
				System.out.println("There is a negative Circuit ");
				break;
			}
		}
		
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n; j++)
			{
				if (dist[i][j] != 99999)
					System.out.print(dist[i][j]+"   ");
					
				else
					System.out.print("INF ");
			}
			System.out.println();
		}
	}
	
	/* ------------------------------------------------------------------------------------------------------------------------------------- */

	public int vertices() {
		return n;
	}

	public int edges() {
		return e;
	}

	public void display() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
					System.out.print(adj[i][j]+" ");
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
		return (adj[u][v]!=0);
	}

	public void insertEdge(String s1, String s2, int wt)  
	{ 
		int u = getIndex(s1);  
		int v = getIndex(s2); 
		if(u==v) 
			throw new IllegalArgumentException("Not a valid edge"); 
		if(adj[u][v] != 0) 
			System.out.print("Edge already present"); 
		else  
		{ 
			adj[u][v]=wt; 
			e++;		// increase the number of vertices
		}
	}
	
	public void deleteEdge(String s1, String s2)  
	{ 
		int u = getIndex(s1);  
		int v = getIndex(s2); 
		
		if(adj[u][v] == 0) 
			System.out.print("Edge not present"); 
		else  
		{ 
			adj[u][v]=0;
			e--;
		}
	}
	
	public int outdegree(String s)
	{
		int u = getIndex(s);		// get the row number
		
		int out = 0;
		
		for(int v=0; v<n; v++)		// sum through row
			if(adj[u][v] != 0)
				out ++;
		
		return out;
	}
	
	public int indegree(String s)
	{
		int v = getIndex(s);		// get the column index
		
		int in = 0;
		
		for(int u=0; u<n; u++)		// sum through column
			if(adj[u][v] != 0)
				in ++;
		
		return in;
	}
}
