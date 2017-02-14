/* https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=10&cad=rja&uact=8&sqi=2&ved=0ahUKEwjZ0sikydbQAhXM7yYKHRlAATAQFghKMAk&url=http%3A%2F%2Fwww.cargalmathbooks.com%2F9%2520Shortest%2520Paths%2520.pdf&usg=AFQjCNFbHtCN9bVfcMeLoFKuheE8s1Zl9A&sig2=YXwHTTlmsCY5L-uR59PWCQ&bvm=bv.139782543,d.eWE  */
package BellmanFord;

import java.util.concurrent.locks.Condition;

public class DirectedWeightedGraph2 {
	
	public final int MAX_VERTICES = 30;
	int n; // number of vertices
	int e; // edges
	int[][] adj;
	Vertex[] vertexList;
	
	//* constants for different states of a vertex */
		private static final int NIL = -1;		// to initialize predecessor
		private static final int INFINITY = 99999;		// to Initialize the pathLength
		private static final int TEMPORARY = 1;		// to Initialize the Status
		private static final int PERMANENT = 2;

	public DirectedWeightedGraph2() {
		adj = new int[MAX_VERTICES][MAX_VERTICES];
		vertexList = new Vertex[MAX_VERTICES];
		// By default n=0, e=0
		// By default adj[u3][v]=0
	}

	/*  BFS traversals ===================================== -------------------------------------------------------------------------- */
	
	public void findPaths(String source)
	{
		int s = getIndex(source);
		
		dijkstras(s);
		
		System.out.println("Source Vertex : " + source + "\n");
		
		for (int v=0; v<n; v++)
		{
			System.out.println("Destination Vertex : " +vertexList[v]);
			
			if( vertexList[v].pathLength == INFINITY )  
				System.out.println("There is no path from " + source + " to vertex " + vertexList[v]);
			else  findPath(s,v);
		}
	}
	
	public void findPath(int s, int v)
	{
		int i,u;
		int [] path = new int[n];
		int sd=0; 		//shortest pathLenth from s to v
		int count=0;  
		
		while(v!=s)  
		{ 
			count++; 
			path[count] = v; 
			u = vertexList[v].predecessor; 
			sd += adj[u][v];
			v=u;  
		}
		count++;  
		path[count]=s;
		
		System.out.print("Shortest Path is : ");
		for(i=count; i>=1; i--)
			System.out.print(path[i] + " ");
		System.out.print("\nShortest distance is : " + sd + "\n\n ");
			
	}
	
	private void dijkstras(int s)
	{
		int v,c;
		
		for (v=0; v<n; v++)
		{
			//vertexList[v].Status = TEMPORARY;
			vertexList[v].pathLength = INFINITY;
			vertexList[v].predecessor = NIL;
		}
		
		vertexList[s].pathLength = 0;		// set the pathlength of starting element
		//vertexList[s].Status = PERMANENT;
		
		int counter = 0;
		boolean cond = true;
		
		while(cond)
		{
			c = tempVertexMinPL();		//To find the vertex having minimum PL amongst all temporary status vertices // see video at 2:00 : https://www.udemy.com/data-structures-and-algorithms-in-java-2/learn/v4/t/lecture/3577426
			
			if(c == NIL)		// above method returns NIL when there is no Temporary vertex of all the Temporary vertices remaining have PL == INFINITY
				return;
			
			//vertexList[c].Status = PERMANENT;
			counter = counter +1;
			
			if(counter == n+1)
			{
				System.out.println("There is a negative Circuit ");
				break;
			}
			
			cond = false;
			
			
				for(v = 0; v<n; v++)
				{
				if(isAdjacent(c, v))		
					if(vertexList[c].pathLength + adj[c][v] < vertexList[v].pathLength)		// v is adjacent vertex of c and has temporary status
					{
						vertexList[v].predecessor = c;
						vertexList[v].pathLength = vertexList[c].pathLength + adj[c][v];   //RELAXING : Consider an edge u --> v where u is the start and v is the end vertex respectively. Relaxing an edge means to find shorter path to reach v when considering edge u --> v
						cond = true;
					}
				}
		}
	}
	
	private int tempVertexMinPL() 	//searches for the vertex having minimum pathlength out of all TEMPORARY status vertices
	{
		int min = INFINITY;
		int x= NIL;
		for(int v=0; v<n; v++)
		{
			if(vertexList[v].pathLength < min)
			{
				min = vertexList[v].pathLength;
				x=v;
			}
		}
		return x;		//return the vetex having minimum pathlength amongst all temporary status vertices // see video at 2:00 : https://www.udemy.com/data-structures-and-algorithms-in-java-2/learn/v4/t/lecture/3577426 
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
