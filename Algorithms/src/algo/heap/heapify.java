package algo.heap;

public class heapify {
	
	public static void buildHeap_BottomUp(int [] a, int n)
	{
		for(int i=n/2; i>=1; i--)
			restoreDown(i,a,n);
	}
	
	private static void restoreDown(int i, int [] a, int n)
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
	
	
	
	public static void buildHeap_TopDown(int [] a, int n)
	{
		for(int i=2; i<=n; i++)
			restoreUp(i,a);
	}
	
	private static void restoreUp(int i, int [] a)
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
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1[] = {99999,1,4,5,7,9,10};
		int n1 = a1.length-1;				// a1.length will be 7 ,hence n1 = 6.
		
		buildHeap_BottomUp(a1,n1);
		
		for(int i=1; i<=n1; i++)
			System.out.print(a1[i] + " ");
		System.out.println();
		
		
		int a2[] = {99999,1,4,5,7,9,10};
		int n2 = a2.length-1;
		
		buildHeap_TopDown(a2,n2);
		
		for(int i=1; i<=n2; i++)
			System.out.print(a2[i] + " ");
		System.out.println();
	}

}
