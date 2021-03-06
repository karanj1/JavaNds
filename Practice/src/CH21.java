import java.util.Scanner;

public class CH21 {

	 // Constructor method
	 
	  CH21() {
	    System.out.println("Constructor method is called when an object of it's class is created");
	  }
	  
	  //parameterized constructor
	  CH21(int a,String b)
	  {
		  System.out.println("parameterized contstructor method passes two parameters : " + a  + " and " + b);
	  }
	  
	 
	  // Main method where program execution begins
	 
	  public static void main(String[] args) {
	    staticMethod(); //Static method can be called without creating object
	    //CH21 object = new CH21();  //default constructor call
	    CH21 object = new CH21(1 , "second parameter"); //parametrerized constructor call
	    object.nonStaticMethod();
	    
	   
	    int n = 0;
	    object.whileloop(n);
	    
	  }
	 
	  // Static method
	 
	  static void staticMethod() {
	    System.out.println("Static method can be called without creating object");
	  }
	 
	  // Non static method
	 
	  void nonStaticMethod() {
	    System.out.println("Non static method must be called by creating an object");
	  }
	  
	  void whileloop(int n)
	  {
		  Scanner input = new Scanner(System.in);
		    System.out.println("Input an integer"); 
		  
		  while ((n = input.nextInt()) != 0) {
		      System.out.println("You entered " + n);
		      System.out.println("Input another integer");
		    }
		 
		    System.out.println("You entered 0,hence out of loop");
	  }
}
