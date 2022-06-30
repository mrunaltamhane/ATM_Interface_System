import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class Atm3{
	 public Atm3(int pinNo) {
		 int pinNo_atm3= pinNo;
		 JFrame f3 = new JFrame("Enter PIN");
		 f3.setTitle("Select your Transaction.");
			f3.getContentPane().setBackground(Color.WHITE);
			f3.getContentPane().setEnabled(false);
			f3.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 9));
			 f3.setBounds(0, 0, 1450, 735);//to set dimensions of the frame
			f3.setLocationRelativeTo(null);//to put frame in center of screen
			f3.getContentPane().setLayout(null);
			
			JButton balanceInquiry = new JButton("");
			balanceInquiry.setIcon(new ImageIcon(Atm3.class.getResource("/images/balanceinquiry388x116.png")));
			balanceInquiry.setBackground(new Color(0, 255, 255));
			balanceInquiry.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					f3.setVisible(false);
					
					new  Balance_Inquiry(pinNo_atm3);
				}
			});
			balanceInquiry.setFont(new Font("Tahoma", Font.BOLD, 18));
			balanceInquiry.setBounds(648, 279, 388, 116);
			f3.getContentPane().add(balanceInquiry);
			
			JButton fastcashbtn = new JButton("");
			fastcashbtn.setIcon(new ImageIcon(Atm3.class.getResource("/images/fastcashbtn388x116.png")));
			fastcashbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					f3.setVisible(false);
					new  Fast_cash(pinNo_atm3);
					
				}
			});
			fastcashbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
			fastcashbtn.setBounds(531, 555, 388, 116);
			f3.getContentPane().add(fastcashbtn);
			
			JButton deposit = new JButton("");
			deposit.setIcon(new ImageIcon(Atm3.class.getResource("/images/depositbtn388x116.png")));
			deposit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					f3.setVisible(false);
					new Deposit( pinNo_atm3);
				}
			});
			deposit.setFont(new Font("Tahoma", Font.BOLD, 18));
			deposit.setBounds(648, 425, 388, 116);
			f3.getContentPane().add(deposit);
			
			JButton withdrawal = new JButton("");
			withdrawal.setIcon(new ImageIcon(Atm3.class.getResource("/images/Withdrawbutton388x116.png")));
			withdrawal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					f3.setVisible(false);
					new   Withdrawal(pinNo_atm3);
				}
			});
			withdrawal.setFont(new Font("Tahoma", Font.BOLD, 18));
			withdrawal.setBounds(531, 138, 388, 116);
			f3.getContentPane().add(withdrawal);
			
			JLabel logolbl = new JLabel("");
			logolbl.setIcon(new ImageIcon(Atm2.class.getResource("/images/transparent_logo.png")));
			logolbl.setBounds(-12, -16, 478, 182);
			f3.getContentPane().add(logolbl);
			
			
			JLabel bglbl = new JLabel("");
			bglbl.setIcon(new ImageIcon(Atm3.class.getResource("/images/transcationpagebg1370x696.png")));
			bglbl.setBounds(0, 0, 1370, 696);
			f3.getContentPane().add(bglbl);
			
			f3.setVisible(true);
	 }
	 public static void main(String[] args) {
		  new Atm3(0);
		  
	}
	 
	 //public Balance{
		// try {
			//	Class.forName("com.mysql.cj.jdbc.Driver");
				//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pin_no","root","MBT@mysql07");
			//	String sql="SELECT * FROM pinno where pin_no='"pinNo_atm3"'";
	 //}
 }