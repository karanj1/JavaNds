package MyPack;
import java.util.Scanner;



public class MyAccount {

	protected int acno,bal,time;
	protected String name;
	
	public int num = 321;
	
	public void disp(String name)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter Account number : ");
		acno = input.nextInt();
		
		System.out.println("Account holder name : " + name);
		System.out.println("Account number : " + acno);
	}
	
	public String toString()			//Override toString() of Object class to print the object.
	{
		return "\nnum usning \"Override toString() of Object class\" = " + num;
	}
}
