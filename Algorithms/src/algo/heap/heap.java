package algo.heap;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class heap {
	
	private int [] a;		//array for heap
	private int n;		//size of heap
	
	public heap()
	{
		a = new int[10];
		n=0;
		a[0]=99999;
	}
	
	public heap(int maxSize)
	{
		a = new int[maxSize];
		n=0;
		a[0]=99999;
	}
	
	public void insert (int value)
	{
		n++;	//everytime we insert a value into heap, first we need to increment size of heap
		a[n] = value;		//insert value to the last of array
		restoreUp(n);		//calling function to place that value to its appropriate place in max-heap(descending heap)
	}
	
	private void restoreUp(int i)
	{
		int temp = a[i];	//storing value to be inserted in a temp variable
		int iparent = i/2;	//location of parent is always floor of i/2 (location of parent of 6th and 7th ids will be at 3rd position (i/2))
		
		while(a[iparent] < temp)
		{
			a[i] = a[iparent];
			i = iparent;
			iparent = i/2;
		}
		a[i] = temp;
	}

	public int deleteRoot()
	{
		if (n==0)
			throw new NoSuchElementException("Heap is Empty");
		
		int maxValue = a[1];	//copy root to maxValue
		a[1] = a[n];			//copy data of last node to root
		n--;					//decrease size of array
		restoreDown(1);			//call function to place a[1] to its appropriate place
		return maxValue;
	}
	
	private void restoreDown(int i)
	{
		int temp = a[i];
		int lchild = 2*i, rchild = lchild+1;
		
		while (rchild <= n)
		{
			if (temp >= a[lchild] && temp >= a[rchild])
			{
				a[i] = temp;
				return;
			}
			else if (a[lchild] > a[rchild])
			{
				a[i] = a[lchild];
				i = lchild;
			}
			else
			{
				a[i] = a[rchild];
				i = rchild;
			}
			lchild = 2*i;
			rchild = lchild+1;
		}
		
		/* If number of nodes are even */
		if(lchild==n && temp<a[lchild])
		{
			a[i] = a[lchild];
			i = lchild;
		}
		a[i] = temp;
	}
	
	public void display()
	{
		int i = 1;
		if (n == 0)
		{
			System.out.println("Heap is empty");
		}
		else
		{
			while (i <= n)
			{
				System.out.print(a[i] + " ");
				i++;
			}
			System.out.print("\n\n");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		
		heap h =new heap(20);
		
		int choice,value;
		
		while (true)
		{
			System.out.println("1.Insert");
			System.out.println("2.Delete root");
			System.out.println("3.Display");
			System.out.println("4.Exit");
			System.out.print("Enter your Choice : ");
			choice = scan.nextInt();
			
			if (choice == 4)
				break;
			
			switch(choice)
			{
			case 1:
				System.out.print("Enter the value to be inserted : ");
				value  = scan.nextInt();
				h.insert(value);
				break;
			case 2:
				System.out.println("Maximum value is " + h.deleteRoot());
				break;
			case 3:
				h.display();
				break;
			default:
					System.out.println("wrong choice");
			}
		}
		scan.close();
		
	}

}
