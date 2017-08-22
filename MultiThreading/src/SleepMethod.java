class TestSleepMethod1 extends Thread {
	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				Thread.sleep(2000); // at a time only one thread is executed. If
									// you sleep a thread for the specified
									// time,the thread schedular picks up
									// another thread and so on.
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}
}

public class SleepMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSleepMethod1 t1 = new TestSleepMethod1();
		TestSleepMethod1 t2 = new TestSleepMethod1();

		t1.start();
		t2.start();
	}

}


/*
class TestCallRun2 extends Thread{  
public void run(){  
 for(int i=1;i<5;i++){  
   try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
   System.out.println(i);  
 }  
}  
public static void main(String args[]){  
 TestCallRun2 t1=new TestCallRun2();  
 TestCallRun2 t2=new TestCallRun2();  
  
 t1.run();  
 t2.run();  
}  
}  

****************---------
Output:1
       2
       3
       4
       5
       1
       2
       3
       4
       5
       
       //As you can see in the above program that there is no context-switching because here t1 and t2 will be treated as normal object not thread object.
*/