package BellmanFord;

public class Vertex {
	
	String name;
	int Status;
	int predecessor;
	int pathLength;
	
	Vertex (String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return name;
	}

}
