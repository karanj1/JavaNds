package linkedlists;

public class SinglyLinkedList {

	private Node first;
	
	public SinglyLinkedList(){
		
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public void insertFirst(int data){
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = first;
		first = newNode;
	}
	
	public Node deleteFirst(){
		Node temp = first;
		first = first.next;
		return temp;
	}
	
	public void insertLast(int data){
		Node currentNode = first;
		while(currentNode.next != null){
			currentNode = currentNode.next;
		}
		Node newNode = new Node();
		newNode.data = data;
		currentNode.next = newNode;
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
		
		SinglyLinkedList myList = new SinglyLinkedList();
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
