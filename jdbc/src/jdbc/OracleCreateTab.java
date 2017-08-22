package jdbc;

import java.sql.*;

public class OracleCreateTab 
{
  public static void main(String [] args) 
  {
    Connection conn;// = null;
	 Statement stmt; //interface

	
    try {

// Load the Oracle JDBC driver
      Class.forName("oracle.jdbc.OracleDriver") ; 
      

      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","HR","password");
    
      stmt = conn.createStatement();

	//DDL,DML use executeUpdate
      //stmt.executeUpdate("create table myStudentJava(id number(5) ,name varchar2(10), 	address varchar2(10))");
      //System.out.println("Table created succesfully");			
		
      int i=	stmt.executeUpdate("insert into myStudentJava values(12,'bb','Mumbai')");
      System.out.println(i + " row Inserted succesfully");
      
      //int i=stmt.executeUpdate("delete from myStudentJava where id=12 ");
      //System.out.println("Number of rows deleted :  "+i);
		
      //int i=stmt.executeUpdate("update myStudentJava set address='Pune' where address='Mumbai'");
      //System.out.println("Update count = "+i);
		

		stmt.close();
		conn.close();
		

    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
	
  }
}