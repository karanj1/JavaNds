import java.util.*;

class PrioQueue 
{

	public static void main(String[] args) 
	{
		
		//PriorityQueue<Integer> pq1 =new PriorityQueue<Integer>();  // ascending priority queue
		PriorityQueue<Integer> pq1 =new PriorityQueue<Integer>(5,Collections.reverseOrder()); // capacity,comparator
		pq1.offer(12);// add element
		pq1.offer(2);
		pq1.offer(5);
		pq1.offer(21);
		pq1.offer(7);

		System.out.println("size " + pq1.size());
		System.out.println("peek " + pq1.peek()); // smallest value , will not remove
		System.out.println("size " + pq1.size());
	 
		int s=pq1.size();

		for(int i=0;i<s;i++) // review queue
		{
			System.out.print(pq1.poll() + " "); // delete
		}
		
		/*for(int i : pq1) // review queue
		{
			System.out.print(i + " "); // no delete , only print
		}*/
		
		System.out.println();
		System.out.println("size " + pq1.size());


	}
}