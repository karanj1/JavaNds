// CH 9 - wait() and notify() , belongs to Object class
class TestThreadWaitNotify 
{
	public static void main(String [] args) throws InterruptedException 
	{
		 ThreadB b = new ThreadB();
		b.start();

		synchronized(b) 
		{
				System.out.println("Waiting for b to complete...");
				b.wait();//IMP:  release lock				
			
			System.out.println("Total is: " + b.total);
		}
	}
}

class ThreadB extends Thread 
{
	int total=0;
	public void run() 
	{
		synchronized(this) 
		{
			for(int i=1;i<=500;i++) 
			{
				total += i;
			}
		
		  notify();

		}// release lock
		try
			{
				Thread.sleep(3000);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}

		System.out.println(" From child thread , the last line ");

	}
}
