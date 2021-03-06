package jdbc;

import java.sql.*;
public class OracleBatch {
  public static void main(String [] args) {
    Connection con = null;
	Statement stmt;
    try {

// Load the Oracle JDBC driver
      Class.forName("oracle.jdbc.OracleDriver") ;     

      

      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","HR","password");
      
      
	  stmt=con.createStatement();
//  Adds the given SQL commands to the current list 
		//of commmands for this Statement object
		stmt.addBatch("insert into MyStudentJava values(4,'c14','Pune')");
		stmt.addBatch("insert into MyStudentJava values(2,'c11','Pune')");
		stmt.addBatch("insert into MyStudentJava values(3,'c23','Nasik')");
		stmt.addBatch("delete from MyStudentJava where name='c23'");

      stmt.executeBatch(); //int[] executeBatch()
	   //Submits a batch of commands to the database for execution

		System.out.println("Successful execution of all the commands");
	  con.close(); // use finally block
	 
    

    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
  }
}