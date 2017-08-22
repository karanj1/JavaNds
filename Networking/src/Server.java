
//chat Server
import java.io.*;
import java.net.*;
public class Server {
	public static void main(String agrs[])
	{
		try 
		{
			//Creates a server socket, bound to the specified port
			ServerSocket ss = new ServerSocket(1524); 
			// first 1024 port numbers are reserved

			System.out.println("Server is Ready");    

			PrintStream dout = null;

			//  Listens for a connection to be made to this socket and accepts it. The method blocks until a connection is made. 
			Socket s = ss.accept(); // imp , accept a client socket

			System.out.println("Server got Connected");

			BufferedReader br = new BufferedReader(new InputStreamReader
					(System.in)); // keyboard input

			BufferedReader din
			= new BufferedReader(new InputStreamReader(s.getInputStream()));
			//	 din object will read the input from client stream

			dout = new PrintStream(s.getOutputStream(),true); // autoFlush true
			// dout object is used to send data to the client

			while(true)
			{
				String str1 = din.readLine(); // read data from client

				System.out.println("client -> : " +str1);

				System.out.println("Enter text : ( terminate ->exit ) ");
				String str2 = br.readLine(); // keyboard input

				if (str2.equals("exit"))
					System.exit(0);

				dout.println(str2);// send data to the client
			}
		}
		catch(Exception e)
		{System.out.println("Application is terminated " );}
	}
}
