 // CH 10 -using notifyall
class Reader1 extends Thread 
{
	Calculator c;

	public Reader1(Calculator calc) 
	{
		c = calc;
	}

	public void run() 
	{
		 synchronized(c) 
		 {
			try 
			{
				System.out.println("Waiting for calculation...");
				c.wait();
			} 
			catch (InterruptedException e) 
			{
				System.out.println(e);
			}
			System.out.println("Total is: " + c.total);
	}

}

 public static void main(String [] args) 
 {
	Calculator calculator = new Calculator();
	new Reader1(calculator).start();
	new Reader1(calculator).start();
	new Reader1(calculator).start();
	calculator.start();
 }
}

class Calculator extends Thread 
{
	int total;

	public void run() 
	{
		synchronized(this) 
		{
			for(int i=1;i<=100;i++) 
			{
				total += i;
			}
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			notifyAll();
		}
	}
 }