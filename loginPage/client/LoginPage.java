package loginPage.client;

import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.Border;
import java.sql.*;

class LoginPage extends JFrame implements ActionListener {

	// Variable for the database conncetion

	Connection con;
	Statement st;
	ResultSet rs;
	
	// varibales for User interface

	JPanel p2;
	JLabel l1,l2,Background,title,l3,l4;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	ImageIcon I ;
	Font f = new Font("Segoe UI",Font.BOLD,25);
    Font f1 = new Font("Segoe UI",Font.BOLD,55);
	Font f2 = new Font("Segoe UI",Font.ITALIC,15);
	Font f3 = new Font("Seoge UI",Font.BOLD,75);
	static String set;
	
	LoginPage(){

		// p1 = new JPanel();
		// p1.setBounds(130,0,1405,820);
		// p1.setLayout(null);
		// p1.setOpaque(false);
		//p1.setBackground(Color.white);
		// p1.setBorder(blackline);
		
		p2 = new JPanel();
		p2.setBounds(0,0,130, 825);
	    p2.setBackground(new Color(189, 195, 199));
		//p2.setOpaque(false);
		// p2.setBorder(blackline);
		p2.setLayout(null);

		l3 = new JLabel("<html>D<br/>A<br/>A<br/>R<br/>K</html>");
		l3.setBounds(30,0,90,700);
		l3.setForeground(new Color(44, 62, 80));
		l3.setFont(f3);
		p2.add(l3);

		// l4 = new JLabel();
		// l4.setBounds(115,0,15,825);
		// l4.setBackground(new Color(0,0,0));
		// l4.setForeground(new Color(0,0,0));
		// p2.add(l4);

		b1 = new JButton("Login");
		b1.setFont(new Font("Segoe UI",Font.ITALIC,12));
		b2 = new JButton("Sign Up");
		b2.setFont(new Font("Segoe UI",Font.ITALIC,12));
		b1.setBounds(600,360,100,27);
        b2.setBounds(735,360,100,27);
		t1 = new JTextField(20);
		t1.setBounds(730,227,140,27);
		t1.setOpaque(false);
        t1.setForeground(Color.white);
        t1.setCaretColor(Color.white);
        t1.setFont(f2);
        t2 = new JPasswordField(20);
		t2.setBounds(730,280,140,27);
		t2.setOpaque(false);
        t2.setForeground(Color.white);
        t2.setCaretColor(Color.white);
        t2.setFont(f2);
		l1 = new JLabel("Username");
		l1.setBounds(560,210,140,60);
        l1.setFont(f);
        l1.setForeground(Color.white);
        l2 = new JLabel("Password");
		l2.setBounds(560,265,140,60);
        l2.setFont(f);
        l2.setForeground(Color.white);
        title = new JLabel("LOGIN");
        title.setBounds(625,50,200,200);
        title.setFont(f1);
        title.setForeground(Color.white);
		
		add(l1);
		add(l2);
		add(t1);
		add(t2);
        add(title);
		add(b1);
		add(b2);
		// add(p1);
		add(p2);
	
		setExtendedState(JFrame.MAXIMIZED_BOTH);
			  
		//setBounds(250,10,750,500);

		setTitle("Login Page");
		setLayout(null);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		I = new ImageIcon("C:/Users/Munish Aggarwal/Desktop/education/java/library/laptop.jpeg");
		Background = new JLabel();
		Background.setBounds(0,0,1600,800);
		Background.setIcon(new ImageIcon(I.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH  )));
		add(Background);
		setVisible(true);
		Image icon = Toolkit.getDefaultToolkit().getImage("library/logo.jpeg");
		setIconImage(icon);
	
		addWindowListener(new WindowAdapter() {

              public void windowClosing(WindowEvent e) {

                System.exit(0);
                  
			}
			  
        });
		
	}

public static void main(String[] args) {
	
	new LoginPage();

}
 
public void actionPerformed(ActionEvent ae) {

	if(ae.getSource()== b1) {

		//Validation of the login page code

		String error = "";
		String textF = t1.getText().trim();
		String passF = t2.getText().trim();
		
		if((textF.equals("")) || (passF.equals(""))){

			error += "Enter an valid Username and Password";

			JOptionPane.showMessageDialog(null, error);

		}

			//Login Source code

			try{

				Class.forName("com.mysql.jdbc.Driver");
		
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");

				String query = "SELECT * FROM project WHERE name = '"+textF+"'";

				st = con.createStatement();
				
				//st.setString(1 ,textF);

				rs = st.executeQuery(query);

				while(rs.next()){
				
					String username = rs.getString("name");
					String password = rs.getString("password");

					System.out.println(username);
					System.out.println(password);

					if((textF.equals(username)) && (passF.equals(password))){

						JOptionPane.showMessageDialog(null, "YAY! You loged in");			
						
						set = t1.getText();

						String per = t1.getText();

						Daark c = new Daark(per,"localhost");
						//h.dbc();
						c.person(per);
						c.setLayout(null);
						c.setResizable(true);
						c.setVisible(true); 

						this.dispose();

					}else {

						error += "enter an valid username and password";

						JOptionPane.showMessageDialog(null, error);

					}
				
				}
	
			}catch(Exception e){

				System.out.println(e);

			}

		//this.dispose();

		addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent e) {
			
				System.exit(0);
			}
		
		});
	}

	if(ae.getSource()== b2) {

		 this.dispose();
		 Register r = new Register();
		 r.setVisible(true);
		 
		addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
				 
				System.exit(0);
                 
            }
        });
		 
	}
}
}