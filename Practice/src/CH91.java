//Example of synchronized method by using anonymous class.

class Test
{
	//synchronized 
	synchronized void dispMsg(String msg) throws InterruptedException
	{
		System.out.println("[");
		System.out.println(msg);
		Thread.sleep(2000);
		System.out.println("]");
	}
}

/*class ThrMsg extends Thread
{
	Test t1;
	String msg;
	ThrMsg(Test t1,String msg)
	{
		this.t1=t1;
		this.msg=msg;
	}
	
	public void run() {
		try {
			synchronized(t1)
			{
				t1.dispMsg(msg);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}*/

public class CH91 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t1=new Test();
		//Test t2=new Test();
		Thread thr1 = new Thread(){
			public void run() {
				try
					{
						t1.dispMsg("msg1");
					}
				 catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		};
		
		Thread thr2 = new Thread(){
			public void run() {
				try 
					{
						t1.dispMsg("msg2");
					}
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		};
		
		/*ThrMsg thr1=new ThrMsg(t1, "Hello"){
			
		};
		ThrMsg thr2=new ThrMsg(t1, "Welcome");*/
		thr1.start();
		thr2.start();
	}

}
