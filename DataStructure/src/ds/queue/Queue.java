package ds.queue;

public class Queue {
	
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue(int size){
		maxSize = size;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(long j){
		if (rear == maxSize-1){
			rear = -1;
		}
		rear++;
		queArray[rear] = j;
		nItems++;
	}
	
	public long remove(){
		long temp = queArray[front++];
		if (front == maxSize){
			front = 0;
		}
		nItems--;
		return temp;		
	}
	
	public void view(){
		System.out.print("[ ");
		for(int i=0; i < queArray.length; i++){
			System.out.print(queArray[i]+ " ");
		}
		System.out.println("]");
	}
	
	public void realview(){
		System.out.print("[ ");
		for(int i=front; i < maxSize; i++){
			System.out.print(queArray[i]+ " ");
		}
		System.out.println("]");
	}
	
	public long peekFront(){
		return queArray[front];
	}
	
	public boolean isEmpty(){
		return (nItems == 0);		//return true if top == 0.
	}
	
	public boolean isFull(){
		return (nItems == maxSize);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue myQueue = new Queue(5);
		myQueue.insert(100);
		myQueue.insert(200);
		myQueue.insert(300);
		myQueue.insert(400);
		myQueue.insert(500);
		myQueue.insert(9);
		myQueue.insert(8);
		myQueue.insert(7);
		
		myQueue.view();
		myQueue.realview();
		
		System.out.println(myQueue.remove());
		System.out.println(myQueue.remove());
		System.out.println(myQueue.remove());
		
		
		myQueue.realview(); //real view doesn't shows elements which were removed from queue
		
	}

}
