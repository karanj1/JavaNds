//ResultSetMetaData

package jdbc;

import java.sql.*;
import java.io.*;
public class OracleResultSetMetaData {
	public static void main(String [] args) {
		Connection con = null;
		BufferedReader br=new BufferedReader(new InputStreamReader (System.in));
		try {

			// Load the Oracle JDBC driver
			Class.forName("oracle.jdbc.OracleDriver") ;

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","HR","password");
			// Create Oracle DatabaseMetaData object
			DatabaseMetaData meta = con.getMetaData();// Object of DatabaseMetaData

			// gets driver info:
			System.out.println("JDBC driver version is : " + meta.getDriverVersion());
			System.out.println("JDBC Driver Name is : " + meta.getDriverName());
			//gets database info
			System.out.println("Database  Product Name is : " + meta.getDatabaseProductName());
			System.out.println("Database Product Version : " + meta.getDatabaseProductVersion()); 


			String tableName;
			System.out.println("\n\nEnter table name : ");
			tableName=br.readLine();
			String qs = "select * from " + tableName;
			Statement smnt = con.createStatement();
			ResultSet res = smnt.executeQuery( qs );

			ResultSetMetaData rsmd = res.getMetaData(); //imp
			//java.sql , Interface ResultSetMetaData
			//An object that can be used to get information about 
			//the types and properties of the columns in a ResultSet object.
			/*
			When the getMetaData method is called using a ResultSet object, the method returns a 
			ResultSetMetaData object describing the columns of that ResultSet object. 
			 */


			int n = 0;

			for ( n = 1; n <= rsmd.getColumnCount(); n++ )
			{
				System.out.println("Col " + n + " Name: " + rsmd.getColumnName( n )+
						" \tType : " +rsmd.getColumnTypeName(n));
			}

			System.out.println("\n\tTable Data");
			while ( res.next()) // fetch 1 record/row
			{
				for ( n = 1; n <= rsmd.getColumnCount(); n++ ) // information of all column data //fetch one by one column
				{
					System.out.print(   res.getString( n )+  "\t\t");
				}
				System.out.println( );
			}
			con.close();



		} 
		catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
		}
	}
}
