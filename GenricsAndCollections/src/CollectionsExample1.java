import java.util.*;

public class CollectionsExample1 
{
	
	public static void main(String[] args) 
	{		
		ArrayList<String> indst=new ArrayList<String>(); // states
		
		indst.add("MH");
		indst.add("MP");
		indst.add("UP");
		indst.add("GJ");
		
		ArrayList<String> pakst=new ArrayList<String>();
		
		pakst.add("pkst1");
		pakst.add("pkst2");
		pakst.add("pkst3");
		pakst.add("pkst4");
		
		
		HashMap <String,ArrayList<String>>hm=new HashMap<String,ArrayList<String>>();
		hm.put("India", indst); // country , states list
		hm.put("Pak", pakst);

		System.out.println(" Key Set ");		
		
		Set <String>s=hm.keySet();  // all countries //set for keyset
		
		System.out.println(s);
		

		
	Iterator<String> iterator=s.iterator(); // iterator for a set of countries
	
	
	while(iterator.hasNext())
	//for(String key : hm.keySet())
	{
		
		String cname=	iterator.next(); // country name //comment this line if using FOR loop
	
		ArrayList <String>stat=	hm.get(cname); // search country and get arraylist of states //if using FOR loop , replace cname with key

		Iterator <String>iterator1=stat.iterator(); // iterator for states list

		System.out.println("\n States of "+cname);	//if using FOR loop , replace cname with key

		while(iterator1.hasNext())
		//for(String state: hm.get(key))
		{
	
			System.out.println(iterator1.next()); //replace iterator1.next() with state, if using inner for loop
		
		}
	
	}	
		
		System.out.println("\n  Values Collection ");
		Collection<ArrayList<String>> c=	hm.values(); //collection for Values
		System.out.println(c);

		System.out.println("\n  Entry Set ");
		Set <Map.Entry<String,ArrayList<String>>>ss= hm.entrySet();	//set for EntrySet //set can be replaced by Collection, but as set doesnt allows duplicates we used set.

		System.out.println(ss);

		System.out.println("\n  Entry Set using enh for ");
		for(Map.Entry<String,ArrayList<String>> me : ss)
		{
			System.out.println(me.getKey());
			System.out.println(me.getValue());
		}
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("\n Enter Country name");
		String cnm=	sc.next();
		
		
		ArrayList<String> al=hm.get(cnm);
		if(al==null)
			System.out.println("\n Country name not found ... ");
		else
		{
	
			Iterator<String> itr=al.iterator();
			System.out.println("\n  states of "+cnm);
			while(itr.hasNext())
			{
	    	
	    		System.out.println(itr.next());
	    	
			} 
	
		}
		sc.close();
		
	}

}
