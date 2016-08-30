
import java.net.*;
import java.util.*;

public class DemoInetAddress {
	  public static void main(String args[])  throws UnknownHostException
	  {
		  InetAddress adr; //This class represents an Internet Protocol (IP) address. 
		  adr=InetAddress.getLocalHost(); // factory method , static methods , catch UnknownHostException
		  System.out.println(adr);
		  
		  System.out.println("-----------------------------------------------");
		  System.out.println();
		  
		  String host;
		  Scanner sc=new Scanner (System.in);
		  System.out.print("Enter the Machine \'s host name ");
		  host=sc.next();
		  
		  adr=InetAddress.getByName(host);
		  System.out.println(adr);
		  sc.close();
		  
		  
	  }
}
//Sanu-Win8pc/192.168.56.1
//Sanu-Win8pc/127.0.0.1


// ipconfig