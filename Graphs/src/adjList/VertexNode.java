package adjList;

public class VertexNode {
	
	String name;
	public VertexNode nextVertex;
	EdgeNode firstEdge;
	
	public VertexNode (String s)
	{
		name = s;
	}
	
	public String toString()
	{
		return name;
	}
}
