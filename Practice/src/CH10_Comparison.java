
public class CH10_Comparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="abcdefg";
		String s2="abcdefgert";
		if(s1.compareTo(s2)==0)
		{
			System.out.println("Equal");
		}
		else if(s1.compareTo(s2)<0)
		{
			System.out.println("s1 < s2");
		}
		else
		{
			System.out.println("s1 > s2 ");
		}
			 
		System.out.println("\n");
		
		stringbuffer();
		
		System.out.println("\n");
		
		StringMethods();
		
	}
	
	static void stringbuffer(){
		StringBuffer b1=new StringBuffer("abc def");
		b1.insert(4, "xyz ");
		System.out.println(b1);
		
		b1.delete(4,8);
		System.out.println(b1);
		
		b1.reverse();
		System.out.println(b1);
	}
	
	static void StringMethods(){ 				//constructor 
		String s="Guru";
		System.out.println(s.charAt(0));
		
		String k=s.concat(" Cert ");
		
		System.out.println(k);
		
		if(s.equalsIgnoreCase("guru"))
			System.out.println("equal");
		else
			System.out.println("not equal ");
		
		System.out.println(s.length());
		
		System.out.println(s.replace('u', 'U'));
		
		
		String z="abcdefgh";
		System.out.println(z.substring(1, 4));
		
		System.out.println(z.toString());
		
		
		String t="    pqrs    ";
		System.out.println(t.trim()+"y");
		
		String p="abc.java";
		if(p.endsWith(".java"))
			System.out.println("yes");
		else
			System.out.println("No");
	}
}
