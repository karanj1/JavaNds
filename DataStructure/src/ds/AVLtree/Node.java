package ds.AVLtree;

public class Node {

	int data, balance;
    Node left, right;
 
    Node(int d) {
        data = d;
        balance = 0;
        left = null;
        right = null;
    }
	
}
