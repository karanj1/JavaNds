import java.util.Scanner;

class Employee
{
	int empNo;
	String name;
	
	Employee(int empNo, String nm)
	{
		this.empNo=empNo;
		name=nm;
	}
	
	void disp()
	{
		System.out.println("EmpNo : "+empNo);
		System.out.println("Name : " + name);
	}
}


public class CH41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("How many employees : ");
		int n=sc.nextInt();
		
		Employee []arr=new Employee[n]; //IMP //objects defined //asssume []arr = v1, v2,..... objects of class Employee
		
		for(int i=0;i<n;++i)
		{
			System.out.println("Enter emp num , name ");
			int eno=sc.nextInt();
			String nm=sc.next();
			
			arr[i]=new Employee(eno, nm); //IMP //objects initialized calling parameterized constructor //asssume arr[i] = v1, v2,..... objects of class Employee
		}
		
		System.out.println("All employees are : ");
		
		for(Employee k : arr)
		{
			k.disp();
		}
		sc.close();
	}

}

