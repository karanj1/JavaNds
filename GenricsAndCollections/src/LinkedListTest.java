
import java.util.*;  

class LinkedListTest 
{ 
  public static void main(String args[]) 
  { 
    // Create a linked list. 

    LinkedList<String> ll = new LinkedList<>();   // Doubly LL  , fast ins,del
    // Add elements to the linked list. 
    ll.add("F"); // add at the end
    ll.add("B"); 
    ll.add("D"); 
    ll.add("E"); 
    ll.add("C"); 
    ll.addLast("Z"); 
    ll.addFirst("A");  
    ll.add(1, "One");  //index
	
    System.out.println("Original contents of ll: " + ll);  
    // Remove elements from the linked list. 
    ll.remove("D"); 
    ll.remove(3);  
    System.out.println("Contents of ll after deletion: " 
                       + ll);  
    // Remove first and last elements. 
    ll.removeFirst(); 
    ll.removeLast();  
    System.out.println("ll after deleting first and last: " 
                       + ll);  
	 System.out.println(" Size = " + ll.size());				  
    // Get and set a value. 
    String val = ll.get(2); 
	System.out.println(" get(2) " + val);
    ll.set(2, "XYZ"); 
 
    System.out.println("ll after change: " + ll); 

	System.out.println(" First ele : " + ll.getFirst());
	System.out.println(" Last ele : " + ll.getLast());

	ListIterator<String> lstItr=ll.listIterator();//traverse the list in either direction
	System.out.println(" ListIterator , forward  : ");
		while(lstItr.hasNext()) 
		{ 
	      String element = lstItr.next(); 

	      System.out.print(element + " "); 

	    } 
	System.out.println("\n ListIterator , backward  : ");

		while(lstItr.hasPrevious()) 
		{ 
	      String element = lstItr.previous(); 

	      System.out.print(element + " "); 

	    } 
  } 
}