//See example CH51_2 and compare
//in this example "modify" method is in different class(MyClass) than the class(CH51) from which it is called

class MyClass
{
	int k;
	MyClass(int k)
	{
		this.k=k;
	}
	void disp()
	{
		System.out.println(" k = " + k);
	}
	
	static void modify(MyClass temp)
	{
		++temp.k;
	}
}

public class CH51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=100;
		
		MyClass v1=new MyClass(a);
		v1.disp();
		
		MyClass.modify(v1);
		
		v1.disp();
		System.out.println(" a = " + a); //Integer a is local to class CH51, so will not chnage due to change in mycalss.k
	}

}
