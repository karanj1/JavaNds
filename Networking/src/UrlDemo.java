import java.net.*;
import java.io.*;

public class UrlDemo {


	public static void main(String[] args)  throws Exception
	{
		int c;
		//Class URL represents a Uniform Resource Locator, 
		//a pointer to a "resource" on the World Wide Web.

		//URL url=new URL("file:/d:/f1.txt");
		URL  url=new URL("https://www.linkedin.com/edu/alumni?id=19529");

		//URL  url=new URL("http://localhost:8090/examples/servlets/helloworld.html");


		//The abstract class URLConnection is the superclass of all classes that 
		//represent a communications link between the application and a URL. 
		//Instances of this class can be used both to read from and to write to 
		//the resource referenced by the URL.
		URLConnection con =url.openConnection();
		System.out.println("Protocol ="+url.getProtocol());
		System.out.println("port ="+url.getPort());
		System.out.println("Host ="+url.getHost());
		System.out.println("File ="+url.getFile());
		System.out.println("External  form  ="+url.toExternalForm());
		int len=con.getContentLength();
		System.out.println("total length="+len);
		if (len>1)
		{
			System.out.println("--------contents----------------");
			InputStream   fin=con.getInputStream();

			while(((c=fin.read())!=-1)) // -1 indicates End of stream
			{
				System.out.print((char)c);
			}
			fin.close();
		}
		else
			System.out.println("no contents are avaialble");

	}

}