package MyPack.calculate;	//nested package
import java.util.Scanner;

import MyPack.*;

public class CalculateInterest extends MyAccount {	//CalculateInterest is subclass of MyAccount class
	
	
	
	public void dispReport()
	{

		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter current balance : ");
		bal = input.nextInt();
		
		System.out.println("Enter time period to claculate interest for : ");
		time = input.nextInt();
		
		
		
		double amount = bal + (bal * 0.07 * time);
		
		System.out.println("amount after interest for " + time + " years is : " + amount);
	}
	
	
}
