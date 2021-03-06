// http://www.javatpoint.com/static-synchronization-example

class Table3 {

	synchronized static void printTable(int n) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
			}
		}
	}
}

class MyThread5 extends Thread {
	public void run() {
		Table3.printTable(1);
	}
}

class MyThread6 extends Thread {
	public void run() {
		Table3.printTable(10);
	}
}

class MyThread7 extends Thread {
	public void run() {
		Table3.printTable(100);
	}
}

class MyThread8 extends Thread {
	public void run() {
		Table3.printTable(1000);
	}
}

public class staticSynchronization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread5 t5 = new MyThread5();
		MyThread6 t6 = new MyThread6();
		MyThread7 t7 = new MyThread7();
		MyThread8 t8 = new MyThread8();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
	}

}
