// we have set top = 0

package Stack;

import java.util.NoSuchElementException;

public class Stack_reverseString {

	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public Stack_reverseString(int s){
		maxSize = s;
		stackArray = new char[maxSize];
		top = 0;
	}
	
	public void push(char j){
		if (isFull()){
			throw new IllegalStateException("Cannot add to full stack");
		}
		stackArray[top++] = j; //first push the value at "top" and then increment reference to top+1
	}
	
	public char pop(){
		if (isEmpty()){
			throw new IllegalStateException("Cannot pop from empty stack");
		}
		return stackArray[--top]; //decrement reference to top value present in stack and then return top value
		
	}
	
	public char peek(){
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
	   System.out.println(reverseString("Hello"));
	}	
	
	public static String reverseString(String str){
		int stackSize = str.length();
		
		Stack_reverseString theStack = new Stack_reverseString(stackSize);
		
		for(int j=0; j < str.length(); j++){
			char ch = str.charAt(j);
			theStack.push(ch);
		}
		
		String result = "";
		 while (!theStack.isEmpty()) {
			char ch = theStack.pop();
			result = result+ ch;
		}
		
		return result;
	}
}
