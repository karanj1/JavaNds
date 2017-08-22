import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class dummytesting {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("n: ");
		int n = in.nextInt();
		System.out.println("k: ");
		int k = in.nextInt();
		System.out.println("q: ");
		int q = in.nextInt();
		System.out.println("n elements of array: ");
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {

			a[a_i] = in.nextInt();
		}

		for (int i = 0; i < k; i++) {
			for (int j = a.length - 1; j > 0; j--) {
				int temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
			}
		}

		for (int o : a) {
			System.out.println(o);
		}

		//for (int a0 = 0; a0 < q; a0++) {
		//	System.out.println("m: ");
		//	int m = in.nextInt();
		//	innerloop: for (int a_i = 0; a_i < n; a_i++) {
		//		if (a[a_i] == m) {
		//			System.out.println(a_i);
		//			break innerloop;
		//		}
		//	}
		//}
		
		int rot = k%n;
		 for(int i=0;i<q;i++)
         {
             int m=in.nextInt();
             if(m-rot>0)
                System.out.println(a[m-rot]);
             else
              System.out.println(a[m-rot+a.length-1]);
          }


	}
}
