package jdbc;

import java.sql.*;
public class OraclePreparedStatementBatch {
  public static void main(String [] args) {
    Connection con = null;
	 PreparedStatement pst ;
		
    try {


      Class.forName("oracle.jdbc.OracleDriver") ;          

         con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","HR","password");
     
	    String sql ="insert into MyStudentJava values(?,?,?)";
            pst = con.prepareStatement(sql);
           pst.setString(1, "119");
            pst.setString(2, "Dhanu");
            pst.setString(3, "Mumbai");
			pst.addBatch();			

			 pst.setString(1, "120");
            pst.setString(2, "Vishwa");
			pst.setString(3, "Pune");
			pst.addBatch();
		

            pst.executeBatch();
            System.out.println(" Rows inserted ");

			pst.close();
      con.close();
	  
    

    } catch (Exception e) {
      System.err.println("Exception: "+e);
    }
  }
}