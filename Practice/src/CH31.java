//Static methods and variables 

class Student {

	int rno;
	String name;
	static String collage_name;
	
	static void FromStatic()
	{
		System.out.println(collage_name);
		//System.out.println(i);
	}
}
public class CH31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student.collage_name = "IIT"; //static variable can be assigned values using class.varName and without using object 
										//Static variable remains constant until assigned new values again
		
		Student v1=new Student();
		v1.rno=100;
		v1.name= "Ramesh";
		
		Student v2=new Student();
		v2.rno=200;
		v2.name = "Suresh"; 
		
		System.out.println(v1.name + " is assigned roll number "+v1.rno);
		System.out.println(v2.name + " is assigned roll number "+v2.rno);
		
		System.out.println("Name of the college is " + Student.collage_name); //static variable can be called using class.varName and without using object
		
		Student.FromStatic(); //static method can be called using class.method() and without creating object

	}

}
