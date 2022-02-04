package loginPage.client;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Settings extends JFrame implements ActionListener {

	//sql Variables

	Connection con;
	Statement st;
	ResultSet rs;

	// awt variables

	JLabel l,l1,l2;
	JPanel p1;
	JButton b4,b7;
	JComboBox c;
	Border whiteline = BorderFactory.createLineBorder(Color.white);
	String Theme[] = {" ","Normal Mode","Dark Mode"};
	String nm = LoginPage.set;

	Settings(){

		p1 = new JPanel();
		p1.setBounds(0,0,500,50);
		p1.setVisible(true);
		p1.setLayout(null);
		// p1.setBorder(blackline);
		p1.setBackground(new Color(52,152,219));

		l = new JLabel("Settings".toUpperCase());
		l.setFont(new Font("Segoe UI",Font.ITALIC,12));
		l.setBounds(210,13,70,25);
		l.setForeground(new Color(0,0,0));
		p1.add(l);

		l1 = new JLabel("Theme");
		l1.setBounds(70,100,50,30);
		l1.setFont(new Font("Segoe UI",Font.ITALIC,12));

		l2 = new JLabel("Profile");
		l2.setBounds(70,200,50,30);
		l2.setFont(new Font("Segoe UI",Font.ITALIC,12));

		b4 = new JButton("ok");
		b4.setBounds(370,105,70,20);
		b4.setFont(new Font("Segoe UI",Font.ITALIC,12));

		b7 = new JButton("View");
		b7.setBounds(175,205,120,20);
		b7.setFont(new Font("Segoe UI",Font.ITALIC,12));
		b7.setBackground(new Color(231,76,60));
		b7.addActionListener(this);

		c = new JComboBox(Theme);
		c.setBounds(175,105,160,20);
		c.setFont(new Font("Segoe UI",Font.ITALIC,12));
		
		add(c);
		add(l1);
		add(l2);
		add(b4);
		add(b7);
		add(p1);

		setSize(500,500);
		setLayout(null);
		b4.addActionListener(this);
		setVisible(true);
	
	}

	public static void main(String[] args) {
		
		new Settings();
	}

	void dbc1(String name){

		try{
			
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");

			String query = "UPDATE project SET '"+name+"' =  WHERE = '"+nm+"'";
		
		}catch(Exception e){

			System.out.println(e);

		}

	}

	public void actionPerformed(ActionEvent e) {
	
		String n = "Normal Mode";
		n.trim();
		String m = "Dark Mode";
		m.trim();

		if(e.getSource()==b4) {
			
			String v1= (String) c.getSelectedItem();
			v1.trim();

			if(v1.equals(n)) {
				
				this.dispose();
				Daark.p1.setBackground(new Color(24,44,97));
				Daark.p2.setBackground(new Color(255,255,255));
				Daark.p3.setBackground(Color.black);
				Daark.p4.setBackground(new Color(44,58,71));
				Daark.n1.setBackground(new Color(245, 246, 250));
				Daark.n1.setForeground(Color.WHITE);
				// Daark.n1.setBorder(whiteline);
				Daark.n2.setBackground(new Color(245, 246, 250));
				Daark.n2.setForeground(Color.WHITE);
				// Daark.n2.setBorder(whiteline);
				Daark.t3.setBorder(whiteline);
				//Home.t3.setBackground(new Color(245, 246, 250));
				Daark.a.setBackground(new Color(236,240,241));
				Daark.a.setForeground(Color.black);
				Daark.t3.setBackground(new Color(255, 255, 255));
				Daark.t3.setForeground(Color.black);
				Daark.b1.setBackground(new Color(211, 84, 0)); //send
				Daark.b1.setForeground(Color.white);
				//Home.b1.setBorder(whiteline);
				Daark.b2.setBackground(new Color(46, 204, 113)); //add
				Daark.b2.setForeground(Color.white);
				//Home.b2.setBorder(blackline);
				Daark.b3.setBackground(new Color(52, 152, 219)); //setting
				Daark.b3.setForeground(Color.white);
				//Home.b3.setBorder(whiteline);
				Daark.b4.setBackground(new Color(127, 143, 166)); //chat head
				Daark.b4.setForeground(Color.white);
				Daark.b4.setBorder(whiteline);
				Daark.b5.setBackground(new Color(231,76,60));
				Daark.b6.setBackground(new Color(155,89,182));
				Daark.b5.setForeground(Color.white); //logout
				Daark.b6.setForeground(Color.white); //save				


			}
				
			if(v1.equals(m)) {

				this.dispose();

				Daark.p1.setBackground(new Color(47, 54, 64));
				Daark.p2.setBackground(new Color(220, 221, 225));
				Daark.p3.setBackground(Color.black);
				Daark.p4.setBackground(new Color(47, 54, 64));
				Daark.n1.setBackground(new Color(245, 246, 250));
				Daark.n1.setForeground(Color.WHITE);
				// Daark.n1.setBorder(whiteline);
				Daark.n2.setBackground(new Color(245, 246, 250));
				Daark.n2.setForeground(Color.WHITE);
				//Daark.n2.setBorder(whiteline);
				Daark.t3.setBorder(whiteline);
				//Home.t3.setBackground(new Color(245, 246, 250));
				Daark.a.setBackground(Color.LIGHT_GRAY);
				Daark.a.setForeground(Color.black);
				Daark.t3.setBackground(new Color(245, 246, 250));
				Daark.t3.setForeground(Color.black);
				Daark.b1.setBackground(new Color(0, 168, 255)); //send
				Daark.b1.setForeground(Color.white);
				//Home.b1.setBorder(whiteline);
				Daark.b2.setBackground(new Color(251, 197, 49)); //add
				Daark.b2.setForeground(Color.white);
				//Home.b2.setBorder(blackline);
				Daark.b3.setBackground(new Color(0, 151, 230)); //setting
				Daark.b3.setForeground(Color.white);
				//Home.b3.setBorder(whiteline);
				Daark.b4.setBackground(new Color(127, 143, 166)); //chat head
				Daark.b4.setForeground(Color.white);
				Daark.b4.setBorder(whiteline);
				Daark.b5.setForeground(Color.white); //logout
				Daark.b6.setForeground(Color.white); //save
		
			}
		}

		if(e.getSource()==b7){

			new profile();
	
			this.dispose();

		}
	}
}