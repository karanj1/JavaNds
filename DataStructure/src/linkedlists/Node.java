package linkedlists;

public class Node {
	int data;
	Node next = null;
	Node previous = null; //will be used in DoublyLinkedList
	
	public void displayNode(){		//this method will be used in Singly/Double LinkedList
		System.out.print("{"+ data +"}");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node nodeA = new Node();
		nodeA.data = 4;
		Node nodeB = new Node();
		nodeB.data = 3;
		Node nodeC = new Node();
		nodeC.data = 7;
		Node nodeD = new Node();
		nodeD.data = 8;
		
		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		
		System.out.println(listLength(nodeA));
		System.out.println(listLength(nodeB));
	}
	
	public static int listLength(Node aNode){
		Node currentNode = aNode;
		int length = 0;
		while(currentNode != null){
			length++;
			currentNode = currentNode.next;
		}
		return length;
	}
}
