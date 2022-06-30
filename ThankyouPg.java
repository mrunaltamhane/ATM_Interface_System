import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.awt.event.ActionEvent;

public class ThankyouPg{
	 public ThankyouPg( ) {
		 
		 JFrame fthankyou = new JFrame("Thank You");
		 fthankyou.getContentPane().setBackground(Color.WHITE);
		 fthankyou.getContentPane().setEnabled(false);
		 fthankyou.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 9));
		 fthankyou.setBounds(0, 0, 1450, 735);//to set dimensions of the frame
		 fthankyou.setLocationRelativeTo(null);//to put frame in center of screen
		 fthankyou.getContentPane().setLayout(null);
		
		JLabel bglbl = new JLabel("");
		bglbl.setForeground(new Color(0, 153, 102));
		bglbl.setIcon(new ImageIcon(ThankyouPg.class.getResource("/images/thankyou1370x696.png")));
		bglbl.setBounds(0, 0, 1370, 696);
		fthankyou.getContentPane().add(bglbl);
		 
		 fthankyou.setVisible(true);
	 }
	 
	 public static void main(String args[]) {
		 new ThankyouPg();
	 }
}