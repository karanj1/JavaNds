//http://www.javatpoint.com/inter-thread-communication-example
//Wait(), notify(), NotifyAll()

class Customer {

	int amount = 10000;

	synchronized void withdraw(int amount) {
		System.out.println("going to withdraw...");

		if (this.amount < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();  //Causes current thread to release the lock and wait until either another thread invokes the notify() method or the notifyAll() method for this object
			} catch (Exception e) {
			}
		}
		this.amount -= amount;
		System.out.println("withdraw completed...");
	}

	synchronized void deposit(int amount) {
		System.out.println("going to deposit...");
		this.amount += amount;
		System.out.println("deposit completed... ");
		notify();
	}
}

class InterThreadComm {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Customer c1 = new Customer();
		new Thread() {
			public void run() {
				c1.withdraw(15000);
			}
		}.start();
		new Thread() {
			public void run() {
				c1.deposit(10000);
			}
		}.start();

	}
}
