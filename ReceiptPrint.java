import java.awt.Color;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.util.Date;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReceiptPrint {
	public ReceiptPrint(int pin, float balance, float donewithdrawal){
		
		int pinno = pin;
		float currentbalance = balance;
		float amountwithdrawn = donewithdrawal;
		 JFrame Rprint = new JFrame("Receipt");
		 Rprint.getContentPane().setBackground(Color.WHITE);
		 Rprint.getContentPane().setEnabled(false);
		 Rprint.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 9));
		 Rprint.setBounds(0, 0,420, 450);//to set dimensions of the frame
		 Rprint.setLocationRelativeTo(null);//to put frame in center of screen
		 Rprint.getContentPane().setLayout(null);
		 
		 JLabel lblNewLabel = new JLabel("New label");
		 lblNewLabel.setBounds(787, 11, 390, 340);
		 Rprint.getContentPane().add(lblNewLabel);
		 
		 JTextPane receiptpane = new JTextPane();
		 receiptpane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 String date_time=  GettingCurrentDate();
		  String cardno = getRandomNumberString6()+"XXXXXXXXX"+getRandomNumberString1();
		  String txn_no = getRandomNumberString4();
		  //System.out.println(cardno);
		 receiptpane.setText("************************************************\n"+
		 "WADALA Branch \n\n DATE\t\tTime\t\tATM ID\n"+date_time+"\t\tN6VO157987273"+
				 "\nCARD NUMBER :"+ cardno+"\n\nTXN NO :"+txn_no+"\nWithdrawal :Rs "+amountwithdrawn+
				 "\nAvailable Balance :Rs "+currentbalance+"\n\nThank you for using our ATM\n\nVisit us at www.nvcbank.com"
				 +"\n************************************************\n");
		 receiptpane.setEditable(false);
		 receiptpane.setBounds(10, 80, 390, 239);
		 Rprint.getContentPane().add(receiptpane);
		 
		 JButton collectbtn = new JButton("COLLECT");
		 collectbtn.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Rprint.setVisible(false);
		 		 new BacktoTransactionPage(pinno);
		 	}
		 });
		 collectbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		 collectbtn.setBackground(new Color(0, 0, 205));
		 collectbtn.setForeground(Color.WHITE);
		 collectbtn.setBounds(138, 330, 116, 55);
		 Rprint.getContentPane().add(collectbtn);
		 
		 JLabel atmlogo = new JLabel("");
		 atmlogo.setHorizontalAlignment(SwingConstants.CENTER);
		 atmlogo.setIcon(new ImageIcon(ReceiptPrint.class.getResource("/images/transparent_logo.png")));
		 atmlogo.setBounds(0, 0, 390, 101);
		 Rprint.getContentPane().add(atmlogo);
		 
		 Rprint.setVisible(true);
		 
	 }
	
	public  String GettingCurrentDate ()
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yy"+"\t\t"+"HH:mm:ss");
		Date dateobj = new Date();
		String date_time = df.format(dateobj);
		return date_time;
		
	}
	
	public static String getRandomNumberString6() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	}
 
	public static String getRandomNumberString1() {
		Random rnd = new Random();
		int number = rnd.nextInt(9);
		return String.format("%01d", number);
	}
	
	public static String getRandomNumberString4() {
		Random rnd = new Random();
		int number = rnd.nextInt(9999);
		return String.format("%04d", number);
	}
 

public static void main(String args[])
{
	new ReceiptPrint(0, 0, 0);
}
 }
