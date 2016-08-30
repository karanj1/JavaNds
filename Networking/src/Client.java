
import java.io.*;
import java.net.*;
public class Client {
	public static void main(String args[])
	{
		try {
			if(args.length<1)
			{
				System.out.println("Try with machine name");
				System.exit(0);
			}
			//Determines the IP address of a host, given the host's name
			InetAddress inet = InetAddress.getByName(args[0]); // ip addr of server machine
			PrintStream dout = null;
			//Creates a stream socket and connects it to the specified port number at the specified IP address.
			Socket s = new Socket(inet,1524); //Socket at client side which is connected to a server

			// keyboard input
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			// to read data from a server 
			BufferedReader din
			= new BufferedReader(new InputStreamReader(s.getInputStream()));

			// to send data to a server
			dout = new PrintStream(s.getOutputStream(),true);//true indicates autoflush


			while(true)
			{
				System.out.println("Enter some text , (to terminate -> stop):");
				String str2 = br.readLine(); // keyboard i/p
				
				if (str2.equals("stop"))
					System.exit(0);
				
				dout.println(str2); // send it to the server
				String str1 = din.readLine(); // read from server
				System.out.println("server----> : "+str1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Application is terminated ");
		}
	}
}
