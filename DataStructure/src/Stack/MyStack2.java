// we have set top = 0

package Stack;

import java.util.NoSuchElementException;

public class MyStack2 {

	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public MyStack2(int s){
		maxSize = s;
		stackArray = new long[maxSize];
		top = 0;
	}
	
	public void push(long j){
		if (isFull()){
			throw new IllegalStateException("Cannot add to full stack");
		}
		stackArray[top++] = j; //first push the value at "top" and then increment reference to top+1
	}
	
	public long pop(){
		if (isEmpty()){
			throw new IllegalStateException("Cannot pop from empty stack");
		}
		return stackArray[--top]; //decrement reference to top value present in stack and then return top value
		
	}
	
	public long peek(){
		if (isEmpty()){
			throw new IllegalStateException("Cannot peek into empty stack");
		}
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return (top == 0);		//return true if top == 0.
	}
	
	public boolean isFull(){
		return (top == maxSize);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack2 stack1 = new MyStack2(4);
		
		stack1.push(10);
		stack1.push(20);
		stack1.push(30);
		stack1.push(40);
		//stack1.push(50);
	      while (!stack1.isEmpty()) {
	      long value = stack1.pop();
	      System.out.print(value);
	      System.out.print(" ");
	    }
	   System.out.println("");  
	}	
}
