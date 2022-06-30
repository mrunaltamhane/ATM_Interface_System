import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Atm2{
	 
	private static JPasswordField passwordField;
	public Atm2(){
		JFrame f2 = new JFrame("Enter PIN");
		f2.getContentPane().setBackground(Color.WHITE);
		f2.getContentPane().setEnabled(false);
		f2.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 9));
		f2.setBounds(0, 0, 1450, 735);//to set dimensions of the frame
		f2.setLocationRelativeTo(null);//to put frame in center of screen
		f2.getContentPane().setLayout(null);
		//f.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JLabel pin_no_getter_lbl = new JLabel("Enter PIN");
		pin_no_getter_lbl.setForeground(Color.WHITE);
		pin_no_getter_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		pin_no_getter_lbl.setFont(new Font("Tahoma", Font.BOLD, 58));
		pin_no_getter_lbl.setBounds(531, 73, 292, 114);
		f2.getContentPane().add(pin_no_getter_lbl);
		

		
		
		JButton entetbtn = new JButton("PROCEED");
		entetbtn.setForeground(Color.WHITE);
		entetbtn.setBackground(new Color(0, 153, 0));
		entetbtn.setSelectedIcon(null);
		entetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pin_no","root","MBT@mysql07");
					Statement stmt= con.createStatement();
					String sql="SELECT * FROM pinno where pin_no='"+passwordField.getText().toString()+"'";
					String Pin_nostring=passwordField.getText().toString();
					int PinNo= Integer.parseInt(Pin_nostring);
					ResultSet rs =stmt.executeQuery(sql);
					if(rs.next())
					{
						//JOptionPane.showMessageDialog(null,"Welcome!!");
						f2.setVisible(false);
						new Atm3(PinNo);
					}	
					
					else {
						JOptionPane.showMessageDialog(null,"Incorret PIN");
						passwordField.setText(null);
					}
					    
					
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		entetbtn.setFont(new Font("Tahoma", Font.BOLD, 28));
		entetbtn.setBounds(1150, 330, 190, 89);
		f2.getContentPane().add(entetbtn);
		
		JLabel logolbl = new JLabel("");
		logolbl.setIcon(new ImageIcon(Atm2.class.getResource("/images/transparent_logo.png")));
		logolbl.setBounds(27, 22, 478, 182);
		f2.getContentPane().add(logolbl);
		
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(72, 61, 139));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBackground(Color.WHITE);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 42));
		passwordField.setBounds(551, 354, 233, 89);
	 
		f2.getContentPane().add(passwordField);
		
		JButton clearbtn = new JButton("CLEAR");
		clearbtn.setForeground(Color.WHITE);
		clearbtn.setBackground(new Color(255, 51, 51));
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText("");
				
			}
		});
		clearbtn.setFont(new Font("Tahoma", Font.BOLD, 28));
		clearbtn.setBounds(1150, 485, 190, 89);
		f2.getContentPane().add(clearbtn);
		
		JLabel atm2instlbl1 = new JLabel("If PIN-code entered incorrectly,\r\n");
		atm2instlbl1.setForeground(Color.WHITE);
		atm2instlbl1.setFont(new Font("Tahoma", Font.BOLD, 25));
		atm2instlbl1.setBounds(531, 516, 423, 80);
		f2.getContentPane().add(atm2instlbl1);
		
		JLabel atm2instlbl2 = new JLabel("Press <CLEAR> and Enter the PIN-code again");
		atm2instlbl2.setForeground(Color.WHITE);
		atm2instlbl2.setFont(new Font("Tahoma", Font.BOLD, 25));
		atm2instlbl2.setBounds(531, 573, 590, 64);
		f2.getContentPane().add(atm2instlbl2);
		
		JLabel bglbl = new JLabel("");
		bglbl.setIcon(new ImageIcon(Atm2.class.getResource("/images/Enter_Pin_No_Page1370x696.png")));
		bglbl.setBounds(0, 0, 1370, 696);
		f2.getContentPane().add(bglbl);
		
		
		
		
		
		
		
		
	 
		
		
		
		
		
		
		
		f2.setVisible(true);
	}
	//public static   String SharedData() {
	//	String Pin_no =passwordField.getText().toString();
	//	return Pin_no;
		
	//}
	
	
 
  public static void main(String[] args) {
	  new Atm2();
	  
}	
}