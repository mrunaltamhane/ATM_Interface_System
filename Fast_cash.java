import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Fast_cash {
	public Fast_cash(int pinNo_atm3) {
		int pin= pinNo_atm3;
		
		JFrame ffastcash = new JFrame("FAST CASH");
		ffastcash.setTitle("FAST CASH");
		ffastcash.getContentPane().setBackground(Color.WHITE);
		ffastcash.getContentPane().setEnabled(false);
		ffastcash.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 9));
		ffastcash.setBounds(0, 0, 1450, 735);//to set dimensions of the frame
		ffastcash.setLocationRelativeTo(null);//to put frame in center of screen
		ffastcash.getContentPane().setLayout(null);
		
		
		JLabel logolbl = new JLabel("");
		logolbl.setIcon(new ImageIcon(Atm2.class.getResource("/images/transparent_logo.png")));
		logolbl.setBounds(3, 0, 478, 182);
		ffastcash.getContentPane().add(logolbl);
		
		JLabel novaclbl = new JLabel("");
		novaclbl.setIcon(new ImageIcon(Fast_cash.class.getResource("/images/novacbgremoved.png")));
		novaclbl.setBounds(1075, 0, 295, 127);
		ffastcash.getContentPane().add(novaclbl);
		
		JLabel instructionlbl = new JLabel("Select the Amount");
		instructionlbl.setForeground(Color.WHITE);
		instructionlbl.setHorizontalAlignment(SwingConstants.CENTER);
		instructionlbl.setFont(new Font("Tahoma", Font.BOLD, 49));
		instructionlbl.setBounds(446, 91, 548, 116);
		ffastcash.getContentPane().add(instructionlbl);
		
		JButton RS200 = new JButton("Rs 200");
		RS200.setBackground(new Color(255, 102, 51));
		RS200.setForeground(Color.WHITE);
		RS200.setFont(new Font("Tahoma", Font.BOLD, 32));
		RS200.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
				
				float r=200;
				float balance =0;	
				 
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pin_no","root","MBT@mysql07");
				String sql = "select Balance FROM pinno WHERE pin_no=?";
				PreparedStatement st= con.prepareStatement(sql);
				st.setInt(1, pin);
				ResultSet rs =st.executeQuery();
				while(rs.next())
				{
					balance = rs.getFloat(1);
					 
				}
				
				 if(r > balance) {
					JOptionPane.showMessageDialog(null,"Withdrawal Not Possible \n Insufficient Balance." );
				 }
				else 
				{
				float fastcash = Math.abs( balance - r);
				String query ="UPDATE pinno set Balance =?where pin_no=?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setDouble(1, fastcash);
				pst.setInt(2,pin );
				int i = pst.executeUpdate();
				if(i>0)
				{
					JOptionPane.showMessageDialog(null,"Withdrawal Successful !Kindly Collect Your Cash!!");
					new BacktoTransactionPage(pin);
					ffastcash.setVisible(false);
					 
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Failed");
				}
				
				}
				
				
				 
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
					
				 
					
					
				
				
				
			}
		});
		RS200.setIcon(null);
		RS200.setBounds(849, 269, 172, 127);
		ffastcash.getContentPane().add(RS200);
		
		JButton RS500 = new JButton("Rs 500");
		RS500.setForeground(Color.WHITE);
		RS500.setFont(new Font("Tahoma", Font.BOLD, 32));
		RS500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					float r=500;
					float balance =0;	
					 
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pin_no","root","MBT@mysql07");
					String sql = "select Balance FROM pinno WHERE pin_no=?";
					PreparedStatement st= con.prepareStatement(sql);
					st.setInt(1, pin);
					ResultSet rs =st.executeQuery();
					while(rs.next())
					{
						balance = rs.getFloat(1);
						 
					}
					
					 if(r > balance) {
						JOptionPane.showMessageDialog(null,"Withdrawal Not Possible \n Insufficient Balance." );
					 }
					else 
					{
					float fastcash = Math.abs( balance - r);
					String query ="UPDATE pinno set Balance =?where pin_no=?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setDouble(1, fastcash);
					pst.setInt(2,pin );
					int i = pst.executeUpdate();
					if(i>0)
					{
						JOptionPane.showMessageDialog(null,"Withdrawal Successful !Kindly Collect Your Cash!!");
						new BacktoTransactionPage(pin);
						ffastcash.setVisible(false);
						 
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Failed");
					}
					
					}
					
					
					 
						}
						catch(Exception e1) {
							e1.printStackTrace();
						}
				
				
				
			}
		});
		RS500.setIcon(null);
		RS500.setBackground(new Color(255, 102, 51));
		RS500.setBounds(1057, 269, 172, 127);
		ffastcash.getContentPane().add(RS500);
		
		JButton RS2000 = new JButton("Rs 2000");
		RS2000.setBackground(new Color(255, 102, 51));
		RS2000.setForeground(Color.WHITE);
		RS2000.setFont(new Font("Tahoma", Font.BOLD, 32));
		RS2000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					float r=2000;
					float balance =0;	
					 
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pin_no","root","MBT@mysql07");
					String sql = "select Balance FROM pinno WHERE pin_no=?";
					PreparedStatement st= con.prepareStatement(sql);
					st.setInt(1, pin);
					ResultSet rs =st.executeQuery();
					while(rs.next())
					{
						balance = rs.getFloat(1);
						 
					}
					
					 if(r > balance) {
						JOptionPane.showMessageDialog(null,"Withdrawal Not Possible \n Insufficient Balance." );
						
					 }
					else 
					{
					float fastcash = Math.abs( balance - r);
					String query ="UPDATE pinno set Balance =?where pin_no=?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setDouble(1, fastcash);
					pst.setInt(2,pin );
					int i = pst.executeUpdate();
					if(i>0)
					{
						JOptionPane.showMessageDialog(null,"Withdrawal Successful !Kindly Collect Your Cash!!");
						new BacktoTransactionPage(pin);
						ffastcash.setVisible(false);
						 
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Failed");
					}
					
					}
					
					
					 
						}
						catch(Exception e1) {
							e1.printStackTrace();
						}
			}
		});
		RS2000.setIcon(null);
		RS2000.setBounds(849, 433, 172, 127);
		ffastcash.getContentPane().add(RS2000);
		
		JButton RS5000 = new JButton("Rs 5000");
		RS5000.setBackground(new Color(255, 102, 51));
		RS5000.setForeground(Color.WHITE);
		RS5000.setFont(new Font("Tahoma", Font.BOLD, 32));
		RS5000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					float r=5000;
					float balance =0;	
					 
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pin_no","root","MBT@mysql07");
					String sql = "select Balance FROM pinno WHERE pin_no=?";
					PreparedStatement st= con.prepareStatement(sql);
					st.setInt(1, pin);
					ResultSet rs =st.executeQuery();
					while(rs.next())
					{
						balance = rs.getFloat(1);
						 
					}
					
					 if(r > balance) {
						JOptionPane.showMessageDialog(null,"Withdrawal Not Possible \n Insufficient Balance." );
					 }
					else 
					{
					float fastcash = Math.abs( balance - r);
					String query ="UPDATE pinno set Balance =?where pin_no=?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setDouble(1, fastcash);
					pst.setInt(2,pin );
					int i = pst.executeUpdate();
					if(i>0)
					{
						JOptionPane.showMessageDialog(null,"Withdrawal Successful !Kindly Collect Your Cash!!");
						new BacktoTransactionPage(pin);
						ffastcash.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Failed");
					}
					
					}
					
					
					 
						}
						catch(Exception e1) {
							e1.printStackTrace();
						}
			}
		});
		RS5000.setIcon(null);
		RS5000.setBounds(1057, 433, 172, 127);
		ffastcash.getContentPane().add(RS5000);
		
		JButton backbtn = new JButton("BACK TO TRANSACTION MENU");
		backbtn.setBackground(new Color(255, 102, 51));
		backbtn.setForeground(Color.WHITE);
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Atm3(pin);
				ffastcash.setVisible(false);
			}
		});
		backbtn.setBounds(847, 595, 382, 73);
		ffastcash.getContentPane().add(backbtn);
		
		
		JLabel fastcashbglbl = new JLabel("");
		fastcashbglbl.setIcon(new ImageIcon(Fast_cash.class.getResource("/images/fashcash1370x696.png")));
		fastcashbglbl.setBounds(0, 0, 1370, 696);
		ffastcash.getContentPane().add(fastcashbglbl);
		
		
		
	
		
		
		
		
		
		ffastcash.setVisible(true);
	}
		
		 
	

	 


		public static void main(String[] args) {
			new  Fast_cash(0);
		}
}
