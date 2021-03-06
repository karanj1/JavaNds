class TestMultiPriority1 extends Thread {
	public void run() {
		System.out.println("running thread name is:" + Thread.currentThread().getName());
		System.out.println("running thread priority is:" + Thread.currentThread().getPriority());

	}
}

public class TreadPriority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMultiPriority1 m1=new TestMultiPriority1();  
		  TestMultiPriority1 m2=new TestMultiPriority1();  
		  TestMultiPriority1 m3=new TestMultiPriority1();  
		  
		  m1.setPriority(Thread.MIN_PRIORITY);  //explicitly priority set to MINIMUM
		  m2.setPriority(Thread.MAX_PRIORITY);  //explicitly priority set to MAXIMUM
		  
		  m1.start();  //Thread-0 lowest priority
		  m2.start();  //Thread-1 highest priority
		  m3.start(); //Thread-2 Normal priority , priority not explicitly set
	}

}
