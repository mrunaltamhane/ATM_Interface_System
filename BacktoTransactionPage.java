import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BacktoTransactionPage{
	 public BacktoTransactionPage(int pinno) {
		 int pin  =pinno;
		 JFrame backtotrans = new JFrame("Back to Transaction Menu");
		 backtotrans.getContentPane().setBackground(Color.WHITE);
		 backtotrans.getContentPane().setEnabled(false);
		 backtotrans.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 9));
		 backtotrans.setBounds(0, 0, 1450, 735);//to set dimensions of the frame
		 backtotrans.setLocationRelativeTo(null);//to put frame in center of screen
		 backtotrans.getContentPane().setLayout(null);
		 
		 JLabel lblNewLabel = new JLabel("Would you like to go back to the Transaction Menu?");
		 lblNewLabel.setForeground(Color.WHITE);
		 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		 lblNewLabel.setBounds(205, 80, 979, 79);
		 backtotrans.getContentPane().add(lblNewLabel);
		 
		 JButton Yesbtnbacktotrans = new JButton("YES");
		 Yesbtnbacktotrans.setForeground(new Color(0, 153, 102));
		 Yesbtnbacktotrans.setBackground(new Color(255, 255, 255));
		 Yesbtnbacktotrans.setFont(new Font("Tahoma", Font.BOLD, 47));
		 Yesbtnbacktotrans.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		new Atm3(pin);
		 		backtotrans.setVisible(false);
		 	}
		 });
		 Yesbtnbacktotrans.setBounds(1060, 280, 213, 124);
		 backtotrans.getContentPane().add(Yesbtnbacktotrans);
		 
		 JButton Nobtnbacktotrans = new JButton("NO");
		 Nobtnbacktotrans.setBackground(new Color(255, 255, 255));
		 Nobtnbacktotrans.setForeground(new Color(0, 153, 102));
		 Nobtnbacktotrans.setFont(new Font("Tahoma", Font.BOLD, 47));
		 Nobtnbacktotrans.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		new ThankyouPg();
		 		backtotrans.setVisible(false);
		 		
		 	}
		 });
		 Nobtnbacktotrans.setBounds(1060, 477, 213, 124);
		 backtotrans.getContentPane().add(Nobtnbacktotrans);
		 
		 JLabel logolbl = new JLabel("");
		logolbl.setIcon(new ImageIcon(Atm2.class.getResource("/images/transparent_logo.png")));
		logolbl.setBounds(-18, -42, 478, 182);
		backtotrans.getContentPane().add(logolbl);
		
		JLabel bglbl = new JLabel("");
		bglbl.setForeground(new Color(0, 153, 102));
		bglbl.setIcon(new ImageIcon(BacktoTransactionPage.class.getResource("/images/back_to_trans1370x696.png")));
		bglbl.setBounds(0, 0, 1370, 696);
		backtotrans.getContentPane().add(bglbl);
		 
		 
		 backtotrans.setVisible(true);
	 }
	 
	 public static void main(String args[]) {
		 new BacktoTransactionPage(0);
	 }
 }
