 // Demonstrate File class.
// File class is used to obtain the information  associated
// with a disk file , it is not used to read or write data
import java.io.*;
import java.io.File;
class CH11_1 
{
  
  public static void main(String args[]) 
  {
    File f1 = new File("C:\\Users\\rishabh\\Documents\\test.txt"); // we can also pass a filename

    System.out.println("File Name: " + f1.getName());
    System.out.println("Path: " + f1.getPath());
    System.out.println("Abs Path: " + f1.getAbsolutePath());

    System.out.println("Parent: " + f1.getParent());
    System.out.println(f1.exists() ? "exists" : "does not exist");

    System.out.println(f1.canWrite() ? "is writeable" : "is not writeable");
    System.out.println(f1.canRead() ? "is readable" : "is not readable");

    System.out.println("is " + (f1.isDirectory() ? "" : "not") + " a directory");
    System.out.println(f1.isFile() ? "is normal file" : "not a normal file ");
    System.out.println("File size: " + f1.length() + " Bytes\n");
	
    
    /*if(f1.delete()) //boolean delete()
		System.out.println("Deleted");
	else
			System.out.println("Not deleted ");*/
    
    FileReader fr=null;
	  try
	  {		
	  	
	    // fr = new FileReader("f2.txt"); //open
		fr = new FileReader("C:\\Users\\rishabh\\Documents\\test.txt");
		BufferedReader br = new BufferedReader(fr); //IMP , constructor chain

		String s;
		while((s = br.readLine()) != null) // read data from file
		{

			System.out.println(s);
		}
		
		
	  }
	  	  catch(FileNotFoundException e)
	  {
			System.out.println(e);
	  }
	    catch(IOException e)
	  {
			System.out.println(e);
	  }
  }
}