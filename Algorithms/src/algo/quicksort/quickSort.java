package algo.quicksort;

public class quickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a =  {9,8,3,13,87,15,19};
		int length = a.length;

		quickSortMethod(a , 0, length-1);
		for (int i=0; i < a.length; i++){
			System.out.println(a[i]);
		}
	}
	
	public static void quickSortMethod(int a[], int p, int r){
		if (p < r){
			int q = partition(a, p, r);	// q is pivot point
			quickSortMethod(a, p, q-1);
			quickSortMethod(a, q+1, r);
		}
	}
	
	public static int partition(int a[], int p, int r){
		int x = a[r];
		int i = p - 1;
		
		for (int j=p; j < r; j++){
			if (a[j] <= x){
				i = i+1;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		int temp2 = a[i+1];
		a[i+1] = a[r];
		a[r] = temp2;
		
		return i+1;
	}

}
