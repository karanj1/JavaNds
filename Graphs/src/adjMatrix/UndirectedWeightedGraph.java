package adjMatrix;

public class UndirectedWeightedGraph {
	

	public final int MAX_VERTICES = 30;
	int n; // number of vertices
	int e; // edges
	int[][] adj;
	Vertex[] vertexList;

	public UndirectedWeightedGraph() {
		adj = new int[MAX_VERTICES][MAX_VERTICES];
		vertexList = new Vertex[MAX_VERTICES];
		// By default n=0, e=0
		// By default adj[u3][v]=0
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
			adj[v][u]=wt; 
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
			adj[v][u]=0;
			e--;
		}
	}
	
	public int degree(String s)		//for undirected graphs inDegree = outDegree = Degree
	{
		int u = getIndex(s);		// get the row number
		
		int deg = 0;
		
		for(int v=0; v<n; v++)		// sum through row
			if(adj[u][v] != 0)
				deg ++;
		
		return deg;
	}
	

}
