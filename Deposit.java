import java.awt.Color;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

//import Atm2.SharedData;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Deposit {
	 
	private JTextField amount_to_deposit;
	public Deposit(int pinNo_atm3) {
		//String Pin_no;
		//Pin_no= Atm2.SharedData();
		//int Pin_no_i = Integer.parseInt(Pin_no) ;
		//System.out.println(Pin_no);
		
		int pinNo_deposit=pinNo_atm3;
		//System.out.println(pinNo_deposit);
		JFrame fDeposit = new JFrame("Deposit");
		fDeposit.setTitle("Deposit");
		fDeposit.getContentPane().setBackground(Color.WHITE);
		fDeposit.getContentPane().setEnabled(false);
		fDeposit.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 9));
		fDeposit.setBounds(0, 0, 1450, 735);//to set dimensions of the frame
		fDeposit.setLocationRelativeTo(null);//to put frame in center of screen
		fDeposit.getContentPane().setLayout(null);
		
		JLabel enter_the_amt_inst_lbl = new JLabel("ENTER THE AMOUNT TO BE DEPOSITED");
		enter_the_amt_inst_lbl.setForeground(Color.WHITE);
		enter_the_amt_inst_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		enter_the_amt_inst_lbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		enter_the_amt_inst_lbl.setBounds(311, 94, 836, 87);
		fDeposit.getContentPane().add(enter_the_amt_inst_lbl);
		
		amount_to_deposit = new JTextField();
		amount_to_deposit.setHorizontalAlignment(SwingConstants.CENTER);
		amount_to_deposit.setFont(new Font("Tahoma", Font.BOLD, 33));
		amount_to_deposit.setBounds(543, 319, 272, 108);
		fDeposit.getContentPane().add(amount_to_deposit);
		amount_to_deposit.setColumns(10);
		
		JButton btnNewButton = new JButton("DEPOSIT");
		btnNewButton.setBackground(new Color(255, 102, 51));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 32));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
				  
				 
					 
					 
					float balance = 0;
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pin_no","root","MBT@mysql07");
					
					

					String sql = "select Balance FROM pinno WHERE pin_no=?";
					PreparedStatement st= con.prepareStatement(sql);
					st.setInt(1, pinNo_deposit);
					ResultSet rs =st.executeQuery();
					while(rs.next())
					{
						balance = rs.getFloat(1);
						 
					}
					
					
					 
					
					
					//Statement stmt= con.createStatement();
					//String query ="update pinno set balance='"+amount_to_deposit.getText()+"'"+" where pin_no in (1,pinNo_deposit)";
					//UPDATE `pin_no`.`pinno` SET `Balance` = '120' WHERE (`pin_no` = '1456');

					//ResultSet rs =stmt.executeQuery(query);
					String deposit_amount=amount_to_deposit.getText();
					float deposit_amount_F=Float.parseFloat(deposit_amount);
					float depositf=deposit_amount_F+balance;
					//System.out.println(depositf+"after deposit ka balance");
					//String query ="update pinno set Balance =?where pin_no=?";
					//PreparedStatement preparedStmt = con.prepareStatement(query);
					//preparedStmt.setFloat(1,depositf);
					//preparedStmt.executeUpdate();
					//con.close();
					if(deposit_amount_F>200000)
					{
						JOptionPane.showMessageDialog(null,"Please Enter an amount less than or equal to Rs 2,00,000" );
						amount_to_deposit.setText("");
					}
					else {
					 
					String query ="UPDATE pinno set Balance =?where pin_no=?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setFloat(1,depositf);
					pst.setInt(2,pinNo_deposit);
					int i = pst.executeUpdate();
					if(i>0)
					{
						JOptionPane.showMessageDialog(null,"Successfully Deposited:Rs " +deposit_amount_F + "\n"+"Current Balance:Rs "+depositf);
						new BacktoTransactionPage(pinNo_deposit);
						fDeposit.setVisible(false);
						amount_to_deposit.setText("");
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
		btnNewButton.setBounds(1013, 433, 265, 106);
		fDeposit.getContentPane().add(btnNewButton);
		
		JLabel novaclbl = new JLabel("");
		novaclbl.setIcon(new ImageIcon(Fast_cash.class.getResource("/images/novacbgremoved.png")));
		novaclbl.setBounds(1075, 0, 295, 127);
		fDeposit.getContentPane().add(novaclbl);
		
		
		JLabel logolbl = new JLabel("");
		logolbl.setIcon(new ImageIcon(Atm2.class.getResource("/images/transparent_logo.png")));
		logolbl.setBounds(0, -31, 478, 182);
		fDeposit.getContentPane().add(logolbl);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1370, 696);
		fDeposit.getContentPane().add(lblNewLabel);
		
		
		
		JLabel bglbl = new JLabel("");
		bglbl.setIcon(new ImageIcon(Deposit.class.getResource("/images/depositpagebg1370x696.png")));
		bglbl.setBounds(0, 0, 1370, 696);
		fDeposit.getContentPane().add(bglbl);
		
		
		
		
		
		
		fDeposit.setVisible(true);
	}
		
		public static void main(String[] args) {
			new  Deposit(0);
		}
		 
		}

