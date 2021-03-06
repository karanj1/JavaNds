package jdbc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;	

class JdbcSwingExample extends JFrame implements ActionListener
{	// button click , ActionEvent ,ActionListener ,
	JLabel lrno,lname;
	JTextField trno,tname;
	JButton first,prev,next,last,del,ser,cnt,ins,upd,exit,clr;
	Connection cn;
	Statement stmt;
	ResultSet rs,rs1;
	PreparedStatement pstmt,pstmt2,pstmt3;
	String num,nm,dt;
	//String sarr[]=new String[10];
	JdbcSwingExample() //constructor
	{
		try
		{
		     Class.forName("oracle.jdbc.OracleDriver") ;      

    cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","HR","password");
      
		cn.setAutoCommit(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stmt=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		pstmt=cn.prepareStatement("insert into myStudentJava2 values(?,?)");
		pstmt2=cn.prepareStatement("update myStudentJava2 set name=? where rno=?");
		pstmt3=cn.prepareStatement("delete from myStudentJava2 where rno=?");


		
 		rs=stmt.executeQuery("select * from myStudentJava2" ); //return the resultset

		lrno=new JLabel("Roll Num : ");
		lname=new JLabel("Name : ");
		
		trno=new JTextField(20);
		tname=new JTextField(20);
		
		first=new JButton("First");
		prev=new JButton("Prev");
		next=new JButton("Next");
		last=new JButton("Last");
		del=new JButton("Delete");
		ser=new JButton("Search");
		cnt=new JButton("RecordCount");
		ins=new JButton("Insert");
		upd=new JButton("Update");
		
		clr=new JButton("Clear");

		first.addActionListener(this);
		prev.addActionListener(this);
		next.addActionListener(this);
		last.addActionListener(this);
		upd.addActionListener(this);
		del.addActionListener(this);
		ser.addActionListener(this);
		cnt.addActionListener(this);
		ins.addActionListener(this);
		
		clr.addActionListener(this);

		//Container c=getContentPane();
		setLayout(new GridLayout(8,2));
		add(lrno);
		add(trno);
		add(lname);
		add(tname);
		
		
		add(first);
		add(prev);
		add(next);
		add(last);
		add(del);
		add(ser);
		add(ins);
		add(cnt);
		add(upd);

		add(clr);

		//rs.first();

	  }catch(Exception e)
	  {
		  System.out.println("Sql Error------------->"+e);
	  }
		setTitle("JDBC");
		setSize(300,300);
		setVisible(true);

	}

  void showdata() // any user defined method , get data from resultset and show it in textField
	{
		try
		{
				trno.setText(Integer.toString(rs.getInt(1)));
				tname.setText(rs.getString(2));
		
	}
	catch(Exception e)
		  {
			  System.out.println("Sql Error------------->"+e);
	  }


	}


	public void actionPerformed(ActionEvent e)
	{
		try
		{
			
			if(e.getActionCommand()=="Clear")
			{
				trno.setText("");
				tname.setText("");
				trno.requestFocus(); // cursor , set the input focus
					

			}
			if(e.getActionCommand()=="RecordCount")
			{

				int l=1;
				/*rs.first();
				while(rs.next())
				{
					System.out.println("l="+l);
					l++;
				}*/
				rs.last();
				l=rs.getRow(); // row number
				JOptionPane.showMessageDialog(this,"Row count "+ l);
			
			}


			if(e.getActionCommand()=="Update")
			{
					pstmt2.clearParameters();
					num=trno.getText();
					nm=tname.getText();
					pstmt2.setInt(2,Integer.parseInt(num));
					pstmt2.setString(1,nm);
					pstmt2.executeUpdate();
					JOptionPane.showMessageDialog(this,"Record Updated","Update",1);
					rs.close();
					rs=stmt.executeQuery("select * from myStudentJava2" );
			}

			if(e.getActionCommand()=="Insert")
			{
				pstmt.clearParameters();
				num=trno.getText();
				nm=tname.getText();
		
		
				pstmt.setInt(1,Integer.parseInt(num));
				pstmt.setString(2,nm);
		
				pstmt.executeUpdate();
				rs.close();
				rs=stmt.executeQuery("select * from myStudentJava2" );


			}

			if(e.getActionCommand()=="Search")
			{
				String sn=JOptionPane.showInputDialog(this,"Enter Roll number to search ");
				rs.close();
				try
				{
				rs1=stmt.executeQuery("select * from myStudentJava2 where rno="+sn );
				rs1.first(); // cursor is before the first row , so call next or first method
				trno.setText(Integer.toString(rs1.getInt(1)));
				tname.setText(rs1.getString(2));
		
				rs1.close();

				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(this,"Not found","sorry",1);
				}
				rs=stmt.executeQuery("select * from myStudentJava2" );

			}
			if(e.getActionCommand()=="Delete")
			{
				int pos;
			pstmt3.clearParameters();
					num=trno.getText();
					
					pstmt3.setInt(1,Integer.parseInt(num));

					pstmt3.executeUpdate();
					
		    	

		    	if(!rs.isLast())// if not is last
		    	{
		  			rs.next();
		  			  pos=rs.getRow()-1;
		  			JOptionPane.showMessageDialog(this,"Record deleted","Delete",1);
			    }
		  		else
		  		{
		  		  rs.previous();
		  		  pos=rs.getRow();
		  		JOptionPane.showMessageDialog(null,"Record deleted","Delete",1);
		  		}

		  	 showdata();
		  	
		  	 rs.close();
				rs=stmt.executeQuery("select * from myStudentJava2" );
				
				rs.absolute(pos); // moves the cursor to the given row number
		  	
			}
		if(e.getActionCommand()=="First")
		{
			  rs.first();
			 
			  showdata();
		}
		if(e.getActionCommand()=="Prev")
         {
			if(!rs.isFirst())
			{
			  rs.previous();
			  showdata();
		    }
			
		 }
		if(e.getActionCommand()=="Next")
		{
			if(rs.isLast())
			{
						JOptionPane.showMessageDialog(this,"MESSAGE","Sorry Last Record",0);
			}
		else
		    {
		  	 rs.next();
		  	 showdata();
		    }

		}
		if(e.getActionCommand()=="Last")
		{
		 rs.last();
		 showdata();
	    }


	  }
	  catch(SQLException e2)
	  {
		  System.out.println(e2);

	  }

	}

	public static void main(String args[])
	//throws ClassNotFoundException,SQLException
	{
		JdbcSwingExample s=new JdbcSwingExample();
	}
}