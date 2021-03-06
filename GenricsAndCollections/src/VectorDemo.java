/*
java.util 
Interface Enumeration<E>

An object that implements the Enumeration interface 
generates a series of elements, one at a time. 
Successive calls to the nextElement method return 
successive elements of the series. 

For example, to print all elements of a Vector<E> v: 

   for (Enumeration<E> e = v.elements(); e.hasMoreElements();)
       System.out.println(e.nextElement());

*/

import java.util.*; 
class VectorDemo 
{ 
  public static void main(String args[]) 
  {  
    	
		// Thread Safe class , ordered
    Vector<Integer> v = new Vector<Integer>(3,5);  //(int initialCapacity, int capacityIncrement) 
    System.out.println("Initial size: " + v.size()); 
    System.out.println("Initial capacity: " + 
                       v.capacity());  
    v.addElement(1); 
    v.addElement(6); 
    v.addElement(3); 
    v.addElement(4);  
    System.out.println("Capacity after four additions: " + 
                       v.capacity());  
    v.addElement(11); 
    v.addElement(12);  
 
    System.out.println("First element: " + v.firstElement()); 
    System.out.println("Last element: " + v.lastElement()); 
 
    if(v.contains(3)) 
      System.out.println("Vector contains 3."); 
 
	System.out.println(v);

	Enumeration<Integer> e=v.elements(); // older way when iterator was not there

	System.out.println("Using enumeration : ");
	while( e.hasMoreElements()) // if more elements are present
	 {
        System.out.println(e.nextElement()); //  get the next element
	 }

	Collections.reverse(v); // reverses the order
	System.out.println("Reverse : ");
	System.out.println(v);


  } 
}