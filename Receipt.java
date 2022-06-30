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

public class Receipt{
	
	public Receipt(int pinNo_atm3,float balanceafterwithdrawal,float moneytobewithdrawn)
	{
		int pin  =pinNo_atm3;
		float balance = balanceafterwithdrawal;
		float donewithdrawal= moneytobewithdrawn;
		JFrame fReceipt = new JFrame("Receipt");
		fReceipt.getContentPane().setBackground(Color.WHITE);
		fReceipt.getContentPane().setEnabled(false);
		fReceipt.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 9));
		fReceipt.setBounds(0, 0, 1450, 735);//to set dimensions of the frame
		fReceipt.setLocationRelativeTo(null);//to put frame in center of screen
		fReceipt.getContentPane().setLayout(null);
		
		JLabel logolbl = new JLabel("");
		logolbl.setIcon(new ImageIcon(Atm2.class.getResource("/images/transparent_logo.png")));
		logolbl.setBounds(3, 0, 478, 182);
		fReceipt.getContentPane().add(logolbl);
		
		JLabel receiptinstlbl = new JLabel("Do you need a receipt?");
		receiptinstlbl.setHorizontalAlignment(SwingConstants.CENTER);
		receiptinstlbl.setFont(new Font("Tahoma", Font.BOLD, 45));
		receiptinstlbl.setForeground(Color.WHITE);
		receiptinstlbl.setBounds(423, 135, 563, 138);
		fReceipt.getContentPane().add(receiptinstlbl);
		
		JButton ryes = new JButton("YES");
		ryes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReceiptPrint(pin, balance, donewithdrawal);
				fReceipt.setVisible(false);
				
			}
		});
		ryes.setFont(new Font("Tahoma", Font.BOLD, 35));
		ryes.setForeground(new Color(255, 255, 255));
		ryes.setBackground(new Color(255, 51, 0));
		ryes.setBounds(1091, 350, 213, 96);
		fReceipt.getContentPane().add(ryes);
		
		JButton rno = new JButton("NO");
		rno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BacktoTransactionPage(pin);
				fReceipt.setVisible(false);
				
			}
		});
		rno.setFont(new Font("Tahoma", Font.BOLD, 35));
		rno.setBackground(new Color(0, 102, 0));
		rno.setForeground(new Color(255, 255, 255));
		rno.setBounds(1091, 483, 213, 84);
		fReceipt.getContentPane().add(rno);
		
		JLabel savetreesloganlbl = new JLabel("");
		savetreesloganlbl.setIcon(new ImageIcon(Receipt.class.getResource("/images/savetree350x350trasperancy70%.png")));
		savetreesloganlbl.setBounds(692, 319, 350, 350);
		fReceipt.getContentPane().add(savetreesloganlbl);
		
		JLabel receiptbglbl = new JLabel("");
		receiptbglbl.setFont(new Font("Tahoma", Font.BOLD, 29));
		receiptbglbl.setIcon(new ImageIcon(Receipt.class.getResource("/images/Receipt1370x696.png")));
		receiptbglbl.setBounds(0, 0, 1370, 696);
		fReceipt.getContentPane().add(receiptbglbl);
		
		
		
		
		
		
		
		
		
		
		fReceipt.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Receipt(0, 0, 0);
	}
}