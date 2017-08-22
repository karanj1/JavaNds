import java.util.*;  

public class HashMapDemo 
{
  public static void main(String[] args) 
  {
    HashMap<String, Double> hm = new HashMap<>();   // unordered   , unsorted 
  
	// Put elements to the map , Add 
    hm.put("Ram",300.5);  // key,value
    hm.put("Deep", 120.22);  
	hm.put("Beena", 320.22);  
    hm.put("Jaya", 178.00);  
    hm.put("Teena", 199.22);  
    hm.put("Sunita", -19.08);  
  

	hm.remove("Jaya"); //key

    System.out.println(hm);   

    System.out.println("--------------");
    // Deposit 100 into Deep's account. 
    double balance = hm.get("Deep");  // pass key and get the value

    hm.put("Deep", balance + 100);// modify 
    System.out.println("Deep's new balance: " +  
      hm.get("Deep"));  

	Set<String> ks=hm.keySet(); // all keys
	System.out.println("\n Keys : ");
	for(String key : ks)
	  {
		System.out.print(key+"\t");
	  }
	  System.out.println();

	  System.out.println("\n Values : ");
	for(Double v : hm.values()) // all values
	  {
		System.out.print(v+"\t");
	  }
	  System.out.println();


		System.out.println("\n Entry Set using enh for ");
		for(Map.Entry<String,Double> me : hm.entrySet())// entry (key-value pair). 
		{
			System.out.print(me.getKey()+ "\t");
			System.out.println(me.getValue());
		}
  }
}
