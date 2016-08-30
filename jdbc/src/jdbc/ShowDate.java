package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowDate {

	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","HR","password");
						
			PreparedStatement ps=con.prepareStatement("select * from STD5A");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			
			System.out.println(rs.getString(2)); //name
			
			Date date=rs.getDate(3); // 3rd column is of Date type
			//System.out.println(date); //default date format
			SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-YYYY");
			System.out.println(formatter2.format(date));
			}
			
			rs.close();
			con.close();
	
			}catch (Exception e) {e.printStackTrace();	}

	}

}