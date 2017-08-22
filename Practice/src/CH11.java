import java.util.*;

public class CH11 {
	
	int x,y,z;
	
	public static void main (String args[])
	{
		CH11 obj11 = new CH11();
		System.out.println("Enter an integer to check");
		Scanner in = new Scanner (System.in);
		
		obj11.x = in.nextInt();
		
		if (obj11.x % 2 == 0)
			System.out.println(obj11.x + " is an even number");
		else
			System.out.println(obj11.x + " is an odd number");
		
		System.out.println("\n\nEnter 3 integers to check maximum out of them");
		obj11.x = in.nextInt();
		obj11.y = in.nextInt();
		obj11.z = in.nextInt();
		obj11.max(obj11.x,obj11.y,obj11.z);
		
		
		System.out.println("\n\nmax out of an array:");
		int[] myArray = new int[]{1, 3, 8, 5, 7, };
		 Arrays.sort(myArray);
		 int max = myArray[myArray.length - 1];
		 System.out.println(max + "is largest in given array:");
	}
	
	void max (int x,int y,int z)
	{
			if ( x > y && x > z )
	         System.out.println("First number" +" '" + x + "' " + "is largest.");
	      else if ( y > x && y > z )
	         System.out.println("Second number" +" '" + y + "' " + "is largest.");
	      else if ( z > x && z > y )
	         System.out.println("Third number" +" '" + z + "' " + "is largest.");
	      else   
	         System.out.println("Entered numbers are not distinct.");
		
	}
}