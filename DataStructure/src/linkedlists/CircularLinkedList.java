package linkedlists;

public class CircularLinkedList {
	
private Node first;
private Node last;
	
	public CircularLinkedList(){
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public void insertFirst(int data){
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()){
			last = newNode;
		}else{
			newNode.next = first ; //newNode --> old first (if list is not empty)
		}
		first = newNode;		//new first
	}
	
	public void insertLast(int data){
		Node newNode = new Node();
		newNode.data = data;
		if(isEmpty()){
			first = newNode;
		}else {
			last.next = newNode; // old last next --> newNode
		}
		last = newNode;		 //new last
	}
	
	public Node deleteFirst(){
		Node temp = first;
		if(first.next == null){
			last = null;
		}
		first = first.next;
		return temp;
	}
	
	public void displayList(){
		System.out.println("List of Nodes (First ----> Last):");
		Node currentNode = first;
		while(currentNode != null){
			currentNode.displayNode();
			currentNode = currentNode.next;
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedList myList = new CircularLinkedList();
		myList.insertFirst(100);
		myList.insertFirst(50);
		myList.insertFirst(99);
		myList.insertFirst(88);
		
		myList.displayList();
		
		System.out.println();
		System.out.println(myList.deleteFirst().data);
		
		myList.displayList();
		
		System.out.println();
		myList.insertLast(111);
		myList.displayList();
	}

}
