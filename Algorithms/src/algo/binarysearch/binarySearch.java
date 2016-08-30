package algo.binarysearch;

public class binarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(binarySearchMethod(new int[] {1,2,3,4,7,9,12,18}, 2));
		
		System.out.println(recursiveBinarySearch(new int[] {1,2,3,4,7,9,12,18}, 0, 7, 12));
	}
	
	public static int binarySearchMethod(int [] a, int x){
		int p = 0;
		int r = a.length - 1;
		
		while (p <= r){
			int q = (p+r)/2;
			if (x < a[q]) r = q-1;
			else if(x > a[q]) p = q+1;
			else return q+1;	//+1 because loop counts[q] goes from 0 to n-1
		}
		return -1;
	}
	
	
	public static int recursiveBinarySearch(int [] a, int p, int r, int x){
		System.out.println("[" + p + "....." + r + "]");
		if ( p>r ){
			return -1;
		}else {
			int q = (p+r)/2;
			if (a[q] == x){
				return q;
			} else if (x < a[q]){
				return recursiveBinarySearch(a, p , q-1, x);
			} else {										// if( a[q] > x)
				return recursiveBinarySearch(a, p+1, r, x);
			}
		}
	}

}
