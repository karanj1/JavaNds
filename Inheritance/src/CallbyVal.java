class A
{
	static void modify(int a)
	{
			++a;
			System.out.println("a = " +a); // this is different copy and is not sent back to "CallbyVal" class //changes will be in the local variable only  

	}
}


public class CallbyVal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=100;
		System.out.println("k = "+k);
		A.modify(k);
		System.out.println("k = " +k); //This k has its own copy/value for this class only and not coming from "A"
	}

}
