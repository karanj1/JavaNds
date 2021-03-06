package algo.mergesort;

public class mergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a =  {9,8,3,13,87,15,19};
		int length = a.length;

		mergeSortMethod(a , 0, length-1);
		for (int i=0; i < a.length; i++){
			System.out.println(a[i]);
		}
	}
	
	public static void mergeSortMethod(int a[], int p, int r){
		if (p < r){
			int q = (p + r)/2;
			mergeSortMethod(a, p, q);
			mergeSortMethod(a, q+1, r);
			merge(a, p, q, r);
		}
		
	}
	
	public static void merge(int a[], int p, int q, int r){
		int lc = q-p+1; //left_count = number of elements in left sorted array
		int rc = r-q;   //right_count = number of elements in right sorted array
		int [] L = new int[lc+1];	//Left array //rc+1 = number of elements in rc + 1(for infinity or 999999)
		int [] R = new int[rc+1];	//Right array
		
		for (int i=0; i < lc; i++){
			L[i] = a[p+i];		//assigning values to left array from main array a[]
		}
		L[lc] = 999999;			//last element of array should be --> infinite //it will be used for comparison purpose
		
		for (int j=0; j < rc; j++){
			R[j] = a[q+1+j];	//assigning values to right array from main array a[]
		}
		R[rc] = 999999;			//last element of array should be --> infinite
		
		int i=0; 
		int j=0;
		
		for (int k = p; k <= r; k++){
			if (L[i] < R[j]){
				a[k] = L[i];
				i++;
			}else if (L[i] > R[j]){
				a[k] = R[j];
				j++;
			}
		}
		
	}
	

}
