import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Withdrawal   {
	private JTextField txtRs;

	 
	public Withdrawal(int pinNo_atm3 ) {
		int pin_withdrawal =pinNo_atm3;
		JFrame fWithdrawal = new JFrame("Withdrawal");
		fWithdrawal.setTitle("Withdrawal");
		fWithdrawal.getContentPane().setBackground(Color.WHITE);
		fWithdrawal.getContentPane().setEnabled(false);
		fWithdrawal.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 9));
		fWithdrawal.setBounds(0, 0, 1450, 735);//to set dimensions of the frame
		fWithdrawal.setLocationRelativeTo(null);//to put frame in center of screen
		fWithdrawal.getContentPane().setLayout(null);
		//f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		JLabel logolbl = new JLabel("");
		logolbl.setIcon(new ImageIcon(Atm2.class.getResource("/images/transparent_logo.png")));
		logolbl.setBounds(3, 0, 478, 182);
		fWithdrawal.getContentPane().add(logolbl);
		
		JLabel text = new JLabel("Enter the Amount to be Withdrawn ");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Tahoma", Font.BOLD, 44));
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setBounds(325, 134, 812, 134);
		fWithdrawal.getContentPane().add(text);
		
		txtRs = new JTextField();
		txtRs.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtRs.setForeground(new Color(0, 0, 0));
		txtRs.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtRs.setBounds(598, 357, 211, 88);
		fWithdrawal.getContentPane().add(txtRs);
		txtRs.setColumns(10);
		
		JButton withdrawal_yes = new JButton("WITHDRAW");
		withdrawal_yes.setForeground(new Color(255, 255, 255));
		withdrawal_yes.setBackground(new Color(255, 51, 0));
		withdrawal_yes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			
				
				try {
					
					 
					 
					float balance = 0;
					  

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pin_no","root","MBT@mysql07");
				
				

				String sql = "select Balance FROM pinno WHERE pin_no=?";
				PreparedStatement st= con.prepareStatement(sql);
				st.setInt(1, pin_withdrawal);
				ResultSet rs =st.executeQuery();
				while(rs.next())
				{
					balance = rs.getFloat(1);
					 
				}
				
				String Withdraw_Money = txtRs.getText();
				float moneytobewithdrawn = Float.parseFloat(Withdraw_Money);
				
				if(moneytobewithdrawn> 10000)
				{
					JOptionPane.showMessageDialog(null,"Please Enter an amount less than or equal to Rs 10000" );
					txtRs.setText("");
					
				}
				else if(moneytobewithdrawn > balance) {
					JOptionPane.showMessageDialog(null,"Withdrawal Not Possible \n Insufficient Balance." );
					txtRs.setText("");
					
					
				}
				else 
				{float balanceafterwithdrawal = Math.abs( balance - Float.parseFloat(Withdraw_Money));
				
				//System.out.println("Withdrawal ke baad ka balance" + balanceafterwithdrawal);
				 
				String query ="UPDATE pinno set Balance =?where pin_no=?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setDouble(1,balanceafterwithdrawal );
				pst.setInt(2,pin_withdrawal);
				int i = pst.executeUpdate();
				if(i>0)
				{
					JOptionPane.showMessageDialog(null,"Withdrawal Successful !Kindly Collect Your Cash!!\n Current Balance:Rs "+balanceafterwithdrawal);
					new Receipt(pin_withdrawal,balanceafterwithdrawal,moneytobewithdrawn);
					fWithdrawal.setVisible(false);
					txtRs.setText("");
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
		withdrawal_yes.setFont(new Font("Tahoma", Font.BOLD, 29));
		withdrawal_yes.setBounds(958, 480, 229, 95);
		fWithdrawal.getContentPane().add(withdrawal_yes);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Withdrawal.class.getResource("/images/Withdrawal1370x696.png")));
		lblNewLabel.setBounds(0, 0, 1370, 696);
		fWithdrawal.getContentPane().add(lblNewLabel);
		
		
		fWithdrawal.setVisible(true);
	}
	
	public static void main(String[] args) {
		new  Withdrawal(0);
	}
}
