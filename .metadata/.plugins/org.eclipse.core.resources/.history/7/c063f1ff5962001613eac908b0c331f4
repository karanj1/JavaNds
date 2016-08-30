package algo.linearsearch;
import java.util.Scanner;

class LinearSearch 
{
  public static void main(String args[])
  {
    int c, n, search, array[];
 
    Scanner in = new Scanner(System.in);
    System.out.println("Enter number of elements");
    n = in.nextInt(); 
    array = new int[n];
 
    System.out.println("Enter " + n + " integers");
 
    for (c = 0; c < n; c++)
      array[c] = in.nextInt();
 
    System.out.println("Enter value to find");
    search = in.nextInt();
 
    for (c = 0; c < n; c++)
    {
      if (array[c] == search)     /* Searching element is present */
      {
         System.out.println(search + " is present at location " + (c + 1) + ".");
          break;
      }
   }
   if (c == n)  /* Searching element is absent */
      System.out.println(search + " is not present in array.");
   
   System.out.println("-----------------");
   System.out.println("location of searched number(by calling \"linearSearch\" method) is: "+ linearSearch(array, search));
   
   System.out.println("-----using recursive lineart search------------");
   System.out.println("location of searched number(by calling \"recursiveLinearSearch\" method) is: "+ recursiveLinearSearch(array, 0, search));
  }
  
  public static int linearSearch(int []a, int x){
	for(int i = 0; i < a.length; i++){
		if(a[i] == x){
			return i+1;
		}
	}
	return -1;
  }
  
  public static int recursiveLinearSearch(int []a, int i, int x){
	if (i > a.length-1){	//if evaluates to true, x was not found in the array
		return -1;
	} else if (a[i] == x){
		return i+1;
	}else {
		System.out.println("index at: " + i);
		return recursiveLinearSearch(a, i+1, x);
	}
  }
  
}