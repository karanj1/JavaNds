// we have set top = -1
package Stack;

import java.util.NoSuchElementException;

public class MyStack {

	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public MyStack(int s){
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}
	
	public void push(long j){
		if (isFull()){
			throw new IllegalStateException("Cannot add to full stack");
		}
		stackArray[++top] = j;
	}
	
	public long pop(){
		if (isEmpty()){
			throw new IllegalStateException("Cannot pop from empty stack");
		}
		return stackArray[top--]; //first return value at "top" then decrement top.
	}
	
	public long peek(){
		if (isEmpty()){
			throw new IllegalStateException("Cannot peek into empty stack");
		}
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return (top == -1);		//return true if top == -1.
	}
	
	public boolean isFull(){
		return (top == maxSize - 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack stack1 = new MyStack(4);
		
		stack1.push(10);
		stack1.push(20);
		stack1.push(30);
		stack1.push(40);
		stack1.push(50);
	      while (!stack1.isEmpty()) {
	      long value = stack1.pop();
	      System.out.print(value);
	      System.out.print(" ");
	    }
	   System.out.println("");  
	}	
}
