import MyPack.*;
import MyPack.calculate.CalculateInterest;
import java.util.Scanner;


public class CH61 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter name of account holder : ");
		name = input.nextLine();
		
		MyAccount v1 = new MyAccount();
		v1.disp(name);
		
		CalculateInterest v2 = new CalculateInterest();
		v2.dispReport();
		
		Object v3 = new MyAccount(); 	//Override toString() of Object class to print the object.
		System.out.println(v1.toString());

	}

}
