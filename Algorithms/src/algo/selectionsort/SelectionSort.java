package algo.selectionsort;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myArray [] = selectionSortMethod(new int [] {9,8,3,13,87,15,99});
		for (int i=0; i < myArray.length; i++){
			System.out.println(myArray[i]);
		}
	}
	
	public static int [] selectionSortMethod(int a[]){
		
		for (int i=0; i < a.length; i++){
			int minimum = i;
			for (int j=i+1; j < a.length; j++){		//in selection sort it doesnt swap numbers until inner loop is finished
				if (a[j] < a[minimum]){
					minimum = j;					// assigns index of new minimum but doesnt assigns the number itself //index means i , j, minimum
				}
			}
				int temp = a[i];				//swapping of numbers is done here	// numbers means a[i], a[j], a[minimum]...
				a[i] = a[minimum];				// swaps new minimum to i position
				a[minimum] = temp;
		}
		return a; 		// returns array to calling function main (myArray)
	}

}
