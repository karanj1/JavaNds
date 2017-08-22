//See example CH51 and compare
//in this example "modify" method is in same class(CH51_2) as from which it is called

class MyClass2
{
	int k;
}

public class CH51_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		MyClass2 v1=new MyClass2();
		v1.k = 100;
		System.out.println("Value of v1.k before calling increment() is "+v1.k);
		
		modify(v1);
		
		System.out.println("Value of v1.k before calling increment() is "+v1.k);
		//System.out.println(" a = " + a);
	}
	
	static void modify(MyClass2 temp)
	{
		System.out.println("Value of temp.k before calling increment() is "+temp.k);
		++temp.k;
		System.out.println("Value of temp.k before calling increment() is "+temp.k);
	}

}