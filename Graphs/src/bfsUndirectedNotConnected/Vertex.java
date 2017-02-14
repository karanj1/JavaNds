package bfsUndirectedNotConnected;

public class Vertex {
	
	String name;
	int state;
	
	//If componentNumber for two vertices are same then they are in same component
	int componentNumber;		// It tags the all connected vertex in a components with same number // other component's vertices will be tagged using other unique number 
	
	Vertex (String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return name;
	}

}
