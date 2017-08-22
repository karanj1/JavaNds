package ds.BinaryThreadedTree;

public class Node {
	int data;
    Node left, right;
    public boolean leftThread;  // if leftThread is true that means corresponding Node 'left' is thread and refers to its predecessor
    public boolean rightThread; // if rightThread is true that means corresponding Node 'right' is thread and refers to its Successor
    
    public Node(int data) 
    {
        this.data = data;
        left = right = null;
        leftThread = rightThread = true;
    }
}
