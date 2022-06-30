import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class Atm{
	public Atm(){
		JFrame f1 = new JFrame("Welcome");
		f1.getContentPane().setEnabled(false);
		f1.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 9));
		f1.setBounds(0, 0, 1450, 735);//to set dimensions of the frame
		f1.setLocationRelativeTo(null);//to put frame in center of screen
		f1.getContentPane().setLayout(null);
		//f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	
		
	 
		
		JLabel Welcome = new JLabel("Welcome!");
		Welcome.setForeground(Color.WHITE);
		Welcome.setHorizontalAlignment(SwingConstants.CENTER);
		Welcome.setFont(new Font("Tahoma", Font.BOLD, 64));
		Welcome.setBounds(517, 111, 369, 137);
		f1.getContentPane().add(Welcome);
		
		JLabel logolbl = new JLabel("");
		logolbl.setIcon(new ImageIcon(Atm2.class.getResource("/images/transparent_logo.png")));
		logolbl.setBounds(0, 0, 478, 182);
		f1.getContentPane().add(logolbl);
		
		JLabel insertcard = new JLabel("Please Insert your Card.");
		insertcard.setForeground(Color.WHITE);
		insertcard.setFont(new Font("Times New Roman", Font.BOLD, 53));
		insertcard.setHorizontalAlignment(SwingConstants.CENTER);
		insertcard.setBounds(579, 321, 832, 86);
		f1.getContentPane().add(insertcard);
		
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Atm2();
				f1.setVisible(false);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(Atm.class.getResource("/images/cardhere.PNG")));
		btnNewButton.setBounds(722, 428, 543, 144);
		f1.getContentPane().add(btnNewButton);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Atm.class.getResource("/images/Welcome1370x696.png")));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(0, 0, 1370, 696);
		f1.getContentPane().add(lblNewLabel);
		
		
		f1.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Atm();
	}
}