package algo.insertionsort;

public class insetionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myArray [] = insertionSortMethod(new int [] {9,8,3,13,87,15,19});
		for (int i=0; i < myArray.length; i++){
			System.out.println(myArray[i]);
		}
	}
		
		public static int [] insertionSortMethod(int a[]){
			
			for (int i=0; i < a.length; i++){
				int element = a[i];
				int j=i-1; 
				while (j >= 0 && a[j]>element){		 
					a[j+1] = a[j];					//in insertion sort it swaps/assigns numbers inside inner loop
					j--;
				}
				a[j+1] = element;
			}
			return a; 		// returns array to calling function main (myArray)
		}

}
