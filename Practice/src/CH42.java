class Num
{
	int data;
	Num(int d)
	{
		data=d;
	}
	void disp()
	{
		System.out.println("data is : "+data);
	}
}
public class CH42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Num v1=new Num(100);
		v1.disp();
		
		Num v2=v1; // copy of a reference
		v2.disp();
		
		v2.data=-99;
		v1.disp();

	}

}
