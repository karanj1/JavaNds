package linkedlists;

public class DoublyLinkedList {

	private Node first;
	private Node last;
		
		public DoublyLinkedList(){
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
				first.previous = newNode;
				newNode.next = first ; //newNode next --> old first
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
				newNode.previous = last; //the old last will be newNodes previous
			}
			last = newNode;		 //new last
		}
		
		//assuming a non-empty list
		public Node deleteFirst(){
			Node temp = first;
			if(first.next == null){ //there is only one item in the list
				last = null;
			}else{
				first.next.previous = null; // first.next --> second node //if first node deleted than second.previous --> null
			}
			first = first.next; // first -referencing-> first.next(ll be new first) // because we want to remove reference to first node (delete first node) 
			return temp;
		}
		
		//assuming a non-empty list
		public Node deleteLast(){
			Node temp = last;
			if(last.previous == null){ //there is only one item in the list
				first = null;
			}else{
				last.previous.next = null; // last.previous --> second last node //if last node deleted than secondlast.next --> null
			}
			last = last.previous; // last -referencing-> last.previous(will be new last) // because we want to remove reference to last node (delete last node) 
			return temp;
		}
		
		//assuming a non-empty list
		public boolean insertAfter(int key, int data){
			Node current = first;
			while (current.data != key){
				current = current.next;
				if (current == null){
					return false;
				}
			}
			
			Node newNode = new Node();
			newNode.data = data;
			
			if (current == last){
				current.next = null;
				last = newNode;
			}else {
				newNode.next = current.next;
				current.next.previous = newNode;
			}
			newNode.previous = current;
			current.next = newNode;
			
			return true;
		}
		
		//assuming a non-empty list
		public Node deleteKey(int key){
			Node current = first;
			while (current.data != key){
				current = current.next;
				if (current == null){
					return null;
				}
			}
			

			if (current == first){
				first = current.next;
			}else if (current == last){
				last = current.previous;
			}else{
				current.previous.next = current.next;
				current.next.previous = current.previous;
			}
			
			return current;
		}
		
		public void displayForward(){
			System.out.println("List of Nodes (First ----> Last):");
			Node currentNode = first;		//starts from the beginning
			while(currentNode != null){
				currentNode.displayNode();
				currentNode = currentNode.next;
			}
			System.out.println();
		}
		
		public void displayBackward(){
			System.out.println("List of Nodes (Last ----> first):");
			Node currentNode = last;		//starts from the end
			while(currentNode != null){
				currentNode.displayNode();
				currentNode = currentNode.previous;
			}
			System.out.println();
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList myList = new DoublyLinkedList();
		
		myList.insertFirst(44);
		myList.insertFirst(66);
		myList.insertFirst(88);
		
		myList.insertLast(99);
		myList.insertLast(11);
		myList.insertLast(33);
		myList.insertLast(55);
		
		myList.displayForward();
		myList.displayBackward();
		
		System.out.println();
		System.out.println(myList.deleteFirst().data);
		System.out.println(myList.deleteLast().data);
		System.out.println(myList.deleteKey(99).data);
		myList.displayForward();
		
		System.out.println();
		myList.insertAfter(44, 22);
		myList.insertAfter(33, 77);
		myList.displayForward();
		myList.displayBackward();
	}

}
