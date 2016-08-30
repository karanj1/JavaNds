
class TestMultiNaming2 extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}

public class currentThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMultiNaming2 t1 = new TestMultiNaming2();
		TestMultiNaming2 t2 = new TestMultiNaming2();

		t1.start();
		t2.start();  //Thread-1
		
		t1.setName("Sonoo Jaiswal");  
		  System.out.println("After changing name of t1:"+t1.getName());  
	}

}


/*
-----http://www.javatpoint.com/naming-a-thread


For join method:
The join() method waits for a thread to die. In other words, it causes the currently running threads to stop executing until the thread it joins with completes its task.
Syntax:

public void join()throws InterruptedException
public void join(long milliseconds)throws InterruptedException

-----http://www.javatpoint.com/join()-method
*/