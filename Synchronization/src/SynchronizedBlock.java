/*
 - Synchronized block is used to lock an object for any shared resource.
 - Scope of synchronized block is smaller than the method.
 */

class Table2 {

	void printTable(int n) {
		synchronized (this) {// synchronized block
			for (int i = 1; i <= 5; i++) {
				System.out.println(n * i);
				try {
					Thread.sleep(400);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}// end of the method
}

class MyThread3 extends Thread {
	Table2 t;

	MyThread3(Table2 t) {
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}

}

class MyThread4 extends Thread {
	Table2 t;

	MyThread4(Table2 t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
}

public class SynchronizedBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Table2 obj = new Table2();// only one object
		MyThread3 t3 = new MyThread3(obj);
		MyThread4 t4 = new MyThread4(obj);
		t3.start();
		t4.start();
	}
}
