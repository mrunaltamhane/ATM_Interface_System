import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 

public class Balance_Inquiry {
	 
	private JTextField text_for_Balance_Display;
	public Balance_Inquiry(int pinNo_atm3) {
		int pin_balance=pinNo_atm3;
		JFrame fbalanceInquiry = new JFrame("Balance Inquiry");
		fbalanceInquiry.setTitle("Balance Inquiry");
		fbalanceInquiry.getContentPane().setBackground(Color.WHITE);
		fbalanceInquiry.getContentPane().setEnabled(false);
		fbalanceInquiry.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 9));
		fbalanceInquiry.setBounds(0, 0, 1450, 735);//to set dimensions of the frame
		fbalanceInquiry.setLocationRelativeTo(null);
		fbalanceInquiry.getContentPane().setLayout(null);
		
		JLabel logolbl = new JLabel("");
		logolbl.setIcon(new ImageIcon(Atm2.class.getResource("/images/transparent_logo.png")));
		logolbl.setBounds(0, 0, 478, 182);
		fbalanceInquiry.getContentPane().add(logolbl);
		
		
		JButton btnBalance = new JButton("BALANCE");
		btnBalance.setForeground(new Color(255, 255, 255));
		btnBalance.setBackground(new Color(51, 51, 102));
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {

				 
				 
				float balance = 0;
			 
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pin_no","root","MBT@mysql07");
				
				String sql = "select Balance FROM pinno WHERE pin_no=?";
				PreparedStatement st= con.prepareStatement(sql);
				st.setInt(1, pin_balance );
				ResultSet rs =st.executeQuery();
				while(rs.next())
				{
					balance = rs.getFloat(1);
					//System.out.println(balance+"balance inquiry wala balance");
				}
				text_for_Balance_Display = new JTextField();
				text_for_Balance_Display.setHorizontalAlignment(SwingConstants.CENTER);
				text_for_Balance_Display.setFont(new Font("Tahoma", Font.BOLD, 33));
				text_for_Balance_Display.setEditable(false);
				text_for_Balance_Display.setText("Your Current Balance is Rs " +balance);
				 
				text_for_Balance_Display.setBounds(484, 290, 668, 90);
				fbalanceInquiry.getContentPane().add(text_for_Balance_Display);
				text_for_Balance_Display.setColumns(10);
				 
				 
				
				
				
				
			}catch(Exception e1) {
				e1.printStackTrace();
				System.out.println("error1");
			}
				
			
			
			
			
			//JTextArea txtrGhfg = new JTextArea();
			//txtrGhfg.setText("Your current Balance is" +balance);
			////txtrGhfg.setText("Your Current Balance is "+balance);
			//txtrGhfg.setEditable(false);
			//txtrGhfg.setBounds(556, 387, 1000, 3000);
			//fbalanceInquiry.getContentPane().add(txtrGhfg);
			
			
			
			
				
			}
		});
		btnBalance.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnBalance.setBounds(225, 290, 240, 90);
		fbalanceInquiry.getContentPane().add(btnBalance);
		
		JLabel balanceinstlbl = new JLabel("Click on the BALANCE button ");
		balanceinstlbl.setHorizontalAlignment(SwingConstants.CENTER);
		balanceinstlbl.setForeground(Color.WHITE);
		balanceinstlbl.setFont(new Font("Times New Roman", Font.BOLD, 50));
		balanceinstlbl.setBounds(361, 114, 744, 113);
		fbalanceInquiry.getContentPane().add(balanceinstlbl);
		
		JLabel balanceinstlbl2 = new JLabel("to know your current Balance");
		balanceinstlbl2.setHorizontalAlignment(SwingConstants.CENTER);
		balanceinstlbl2.setForeground(Color.WHITE);
		balanceinstlbl2.setFont(new Font("Times New Roman", Font.BOLD, 50));
		balanceinstlbl2.setBounds(349, 166, 744, 113);
		fbalanceInquiry.getContentPane().add(balanceinstlbl2);
		
		JButton btnBack = new JButton("Back to Transaction Menu");
		btnBack.setBackground(new Color(51, 51, 102));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Atm3(pin_balance );
				fbalanceInquiry.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnBack.setBounds(811, 433, 423, 90);
		fbalanceInquiry.getContentPane().add(btnBack);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThankyouPg();
				fbalanceInquiry.setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(51, 51, 102));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(811, 548, 423, 90);
		fbalanceInquiry.getContentPane().add(btnNewButton);
		
		
		
		JLabel Balancebglbl = new JLabel("");
		Balancebglbl.setHorizontalAlignment(SwingConstants.CENTER);
		Balancebglbl.setIcon(new ImageIcon(Balance_Inquiry.class.getResource("/images/Balance1370x696.png")));
		Balancebglbl.setBounds(0, 0, 1370, 696);
		fbalanceInquiry.getContentPane().add(Balancebglbl);
		
		
		
	
		
		
		 
		
		
		
		
		
		
		
		
		fbalanceInquiry.setVisible(true);
	}
		
	 
	 

		public static void main(String[] args) {
			new  Balance_Inquiry(0);
		}
}
