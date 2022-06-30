import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Balance {
	public Balance(int pinNo) {
		int pin =pinNo;
		 
		float balance = 0;
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pin_no","root","MBT@mysql07");
		
		String sql = "select Balance FROM pinno WHERE pin_no=?";
		PreparedStatement st= con.prepareStatement(sql);
		st.setInt(1, pin);
		ResultSet rs =st.executeQuery();
		while(rs.next())
		{
			balance = rs.getFloat(1);
			System.out.println(balance+"ja re");
		}
		 
		 
		
		
		 
		
		
	}catch(Exception e1) {
		e1.printStackTrace();
		System.out.println("error1");
	}
	 
	 
 
	}
	
	 	
	
	public static void main(String[] args) {
      new Balance(0);
	}
	}







	
	


