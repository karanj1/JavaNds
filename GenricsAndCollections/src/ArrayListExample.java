import java.util.*;  
public class ArrayListExample 
{

	public static void main(String args[]) 
	{ 
		
	    // Create an array list. 
	  //  ArrayList <Integer>al = new ArrayList<Integer>();
		   ArrayList <Integer>al = new ArrayList<>();  //"diamond" operator    
	
	    // Add elements to the array list. 
		Integer iObj=new Integer(5);

		// add at the end
	    al.add(10); // autobox
		al.add(iObj); //5
	    al.add(12); 

	    al.add(15); 
	   
	    al.add(2); 
	    al.add(1, 20);  // using index , add at 1st location
	    System.out.println("Size of al  " +  al.size());  

	    // Display the array list. 
	    System.out.println("Contents of al: " + al); // ordered 
	    
		// Remove elements from the array list. 
	  
	    al.remove(0);  // index
		al.remove(iObj);//data , can use Integer valueOf(int i) method to convert int to Integer

	    System.out.println("Size of al after deletions: " + 
	                       al.size()); 
	    System.out.println("Contents of al: " + al); 
	    
	   
	   System.out.print("contents of al using iterator : "); 

	    Iterator<Integer> itr = al.iterator(); //java.util Interface Iterator<E>
	    
		while(itr.hasNext()) // returns true if next element is available
		{ 
	      Integer element = itr.next(); // get the next element

	      System.out.print(element + " "); 

	    } 
	    
		 Collections.sort(al); //ascending order
		System.out.println();
		System.out.println("Sorted Contents of al: " + al); 
	    
		System.out.println(); 
		System.out.println(" Contents of al: using for loop ");
		for(int k : al) //unboxing
		  {
				 System.out.println(k);
		  }

		 System.out.print("get (3) " );
		System.out.println(al.get(3)); // illegal index will throw an exception
	

  	    System.out.println(" Search : 19 --> " + Collections.binarySearch(al,19)); // if value is not present , -ve ans is returned , add 1 to it, to get the insertion point
  	    
  	    
  	    Collections.sort(al,Collections.reverseOrder()); // descending order
  	  System.out.println();
		System.out.println("Sorted in descending order , Contents of al: " + al); 

	  } 
}