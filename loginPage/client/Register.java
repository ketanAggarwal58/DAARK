package loginPage.client;

import java.awt.*;
import java.io.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeListener;

public class Register extends JFrame implements ActionListener {

	/*
	* @author's 
	* 
	* ketan Aggarwal
	* Deepak kumar
	* Raghav Ananad
	*
	*	
	*/
	
	JButton b1 , b2 , b3, b4;
	ImageIcon I ;
	// JRadioButton rb1,rb2,rb3;
	ButtonGroup g;
	JPanel p,p1,p2;
	JOptionPane o = new JOptionPane();
	JLabel l,l1,l2,l3,l4,l7,l10,l11,l12;
	JTextField t1,t2,t3,t7;
	JPasswordField t4;
	ImageIcon img;
	//JTextArea t8;
	//String city[] = {"   ","Karnal","Delhi","Karachi"};
	String country[] = {"   ","India","America","Germany","France","Europe","Russia","Canada"};
	JScrollBar j;
	//JComboBox c1 = new JComboBox(city);
	JComboBox c2 = new JComboBox(country);
	//JMenu m,n;
	//JMenuItem m1,m2,m3,m4;
    JLabel Background;
    Font f = new Font("Segoe UI",Font.BOLD,25);
    Font f1 = new Font("Segoe UI",Font.BOLD,45);
    Font f2 = new Font("Segoe UI",Font.ITALIC,17);
	Border br = BorderFactory.createLineBorder(Color.white);
	
	//SQL variables

	Connection con, conn;
	PreparedStatement st;
	Statement stm;
	ResultSet rs;
	String s;
	Font f3 = new Font("Seoge UI",Font.BOLD,75);

    Register(){

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

		l12 = new JLabel("<html>D<br/>A<br/>A<br/>R<br/>K</html>");
		l12.setBounds(30,0,90,700);
		l12.setForeground(new Color(127, 140, 141));
		l12.setFont(f3);
		p2.add(l12);

		//Scroll Bar
		
    	j = new JScrollBar();
       	j.setBounds(1510,0,20,800);
        j.setLayout(null);
		
		//Menu Bar

        // m = new JMenu("File");
		// n = new JMenu("Edit");
		// JMenuBar mb = new JMenuBar();
		// m1 = new JMenuItem("New");
		// m2 = new JMenuItem("Open");
		// m3 = new JMenuItem("Cut");
		// m4 = new JMenuItem("Copy");
		// m.add(m1);
		// m.add(m2);
		// n.add(m3);
		// n.add(m4);
		// mb.add(m);
		// mb.add(n);
		// setJMenuBar(mb);

		//Text field and Labels

		img = new ImageIcon("src/Library/jas.jpeg");
        l11 = new JLabel();
		l11 = new JLabel(s);
		l11.setBounds(780, 80, 350, 350);
	    t1 = new JTextField(20);
		t2 = new JTextField(20);
		t1.setBounds(360,165,250,27);
		t2.setBounds(360,215,250,27);
		l = new JLabel("REGISTER");
		l.setBounds(285,0,500,200);
		l.setFont(f1);
        l.setForeground(Color.white);
		l1 = new JLabel("First Name");
		l1.setBounds(210,150,140,60);
		l2 = new JLabel("Lastname");
		l2.setBounds(210,200,120,60);
	    t3 = new JTextField(20);
		t4 = new JPasswordField();
		t3.setBounds(360,265,250,27);
		t4.setBounds(360,315,250,27);
		l3 = new JLabel("Email ID");
		l3.setBounds(210,250,120,60);
		l4 = new JLabel("Password");
		l4.setBounds(210,300,120,60);
	    // t5 = new JTextField("holla");
		// t5.setBounds(360,365,250,27);
		// l5 = new JLabel("Conform Password");
		// l5.setBounds(210,350,120,60);
		// l6 = new JLabel("Gender");
    	// l6.setBounds(860,350,120,60);
         t7 = new JTextField();
		// //t8 = new JTextArea(10,9);
		 t7.setBounds(360,415,250,27);
		//t8.setBounds(980,160,450,150);
		 l7 = new JLabel("Image");
		 l7.setBounds(210,400,120,60);
		// l8 = new JLabel("Address");
		// l8.setBounds(860,150,120,60);
		// l9 = new JLabel("City");
		// l9.setBounds(210,450,120,60);
		l10 = new JLabel("Country");
		l10.setBounds(210,350,120,60);

		//button

		b1 = new JButton("Submit");
		b2 = new JButton("Reset");
		b3 = new JButton("Browse");
		b4 = new JButton("Sign-In");
		b1.setBounds(255,500,80,27);
		b1.setBackground(new Color(46, 204, 113));
		b1.setFont(new Font("Segoe UI",Font.ITALIC,12));
		b1.setForeground(new Color(0,0,0));
		b2.setBounds(370,500,80,27);
		b2.setFont(new Font("Segoe UI",Font.ITALIC,12));
		b2.setBackground(new Color(231, 76, 60));
		b2.setForeground(new Color(0,0,0));
		b4.setBounds(480,500,80,27);
		b4.setBackground(new Color(155, 89, 182));
		b4.setForeground(new Color(0,0,0));
		b4.setFont(new Font("Segoe UI",Font.ITALIC,12));
		b3.setBounds(630,415,90,27);
		b3.setFont(new Font("Segoe UI",Font.ITALIC,12));
		b3.setBackground(new Color(52, 152, 219));
		b3.setForeground(new Color(0,0,0));
	
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		// ComboBox

	   // c1.setBounds(360,465,140,27);
		//c1.setVisible(true);
		c2.setBounds(360,365,250,27);
		c2.setVisible(true);

		// radioButtons

		g = new ButtonGroup();
		// rb1 = new JRadioButton(); 
		// rb1.setText("Male"); 
		// rb1.setFont(f);
		// rb1.setForeground(Color.white);
		// rb1.setOpaque(false);
	    // rb1.setBounds(975,365,120,30);
	    // rb2 = new JRadioButton();
	    // rb2.setText("Female");
        // rb2.setBounds(1065,365,120,30);
        // rb2.setFont(f);
		// rb2.setForeground(Color.white);
		// rb2.setOpaque(false);
        // rb3 = new JRadioButton();
        // rb3.setText("Other");
        // rb3.setBounds(1185,365,120,30);
        // rb3.setFont(f);
		// rb3.setForeground(Color.white);
		// rb3.setOpaque(false);

		// Setting font

        l1.setFont(f);
        l1.setForeground(Color.white);
        l2.setFont(f);
        l2.setForeground(Color.white);
        l3.setFont(f);
        l3.setForeground(Color.white);
        l4.setFont(f);
        l4.setForeground(Color.white);
        // l5.setFont(f);
       	// l5.setForeground(Color.white);
        // l6.setFont(f);
        // l6.setForeground(Color.white);
         l7.setFont(f);
         l7.setForeground(Color.white);
        // l8.setFont(f);
        // l8.setForeground(Color.white);
        // l9.setFont(f);
        // l9.setForeground(Color.white);
        l10.setFont(f);
		l10.setForeground(Color.white);
		l11.setFont(f);
		l11.setForeground(Color.white);
		
        t1.setOpaque(false);
        t1.setForeground(Color.white);
        t1.setCaretColor(Color.white);
        t1.setFont(f2);
        t2.setOpaque(false);
        t2.setForeground(Color.white);
        t2.setCaretColor(Color.white);
        t2.setFont(f2);
        t3.setOpaque(false);
        t3.setForeground(Color.white);
        t3.setCaretColor(Color.white);
        t3.setFont(f2);
        t4.setOpaque(false);
        t4.setForeground(Color.white);
        t4.setCaretColor(Color.white);
        t4.setFont(f2);
        // t5.setOpaque(false);
        // t5.setForeground(Color.white);
        // t5.setCaretColor(Color.white);
        // t5.setFont(f2);
        t7.setOpaque(false);
        t7.setForeground(Color.white);
        t7.setCaretColor(Color.white);
        t7.setFont(f2);
       // t8.setOpaque(false);
        //t8.setBorder(BorderFactory.createCompoundBorder(br,BorderFactory.createEmptyBorder(10,10,10,10)));
       // t8.setForeground(Color.white);
      //  t8.setCaretColor(Color.white);
       // t8.setFont(f2);
       // c1.setOpaque(false);
       // c1.setBackground(Color.black);
       // c1.setForeground(Color.white);
        //c1.setFont(f2);
        c2.setOpaque(false);
        c2.setBackground(Color.black);
        c2.setForeground(Color.WHITE);
        c2.setFont(f2);
		c2.setOpaque(false);
		c2.setRenderer(new DefaultListCellRenderer(){
			
			@Override

			public Component getListCellRendererComponent(JList list, Object value,
					int index, boolean isSelected, boolean cellHasFocus) {
				JComponent result = (JComponent)super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				result.setOpaque(false);
				return result;
			}});
			
		c2.getEditor().getItem();
		c2.setVisible(true);
		
		//adding components to frame
		
        // g.add(rb1);
        // g.add(rb2);
        // g.add(rb3);
        // add(rb1);
        // add(rb2);
        // add(rb3);
        // add(l6);
        add(l);
		add(o);
		add(c2);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(j);
	//	add(c1);
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		add(l3);
		add(l4);
		add(t3);
		add(t4);
		add(l12);
		//add(l5);
		// add(t5);
		 add(l7);
		// add(l8);
		 add(t7);
		//add(t8);
		// add(l9);
		add(l10);
		add(l11);

		//

		setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Registration Page");
        setLayout(null);
		//setDefaultLookAndFeelDecorated(true);

		// Background Image
		
		I = new ImageIcon("C:/Users/Munish Aggarwal/Desktop/education/java/library/laptop.jpeg");
		Background = new JLabel();
		add(Background);
		Background.setBounds(0,0,1600,800);
		Background.setIcon(new ImageIcon(I.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH  )));
		setLayout(null);
		setVisible(true);
		setResizable(true);
		  
		}

		public static void main(String[] args){

			new Register();

		}

		void register(){

			// this function is used to insert all data in the databse.

			String b = t1.getText();
			String c = t2.getText();
			String d = t3.getText();
			String e = t4.getText();
			String f = c2.getSelectedItem().toString();
			String g = t7.getText();

			try{

				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");

				String query = "insert into project (id, name, last_name, email, password, country, image)" + "Values('0',?,?,?,?,?,?)";

				st = con.prepareStatement(query);

				if(g == ""){


					FileInputStream fin = new FileInputStream(g);

					st.setString(1,b);
					st.setString(2,c);
					st.setString(3,d);
					st.setString(4,e);
					st.setString(5,f);
					st.setBinaryStream(6, fin,fin.available());

					st.execute();

				}else{

					FileInputStream fin = new FileInputStream(g);

					st.setString(1,b);
					st.setString(2,c);
					st.setString(3,d);
					st.setString(4,e);
					st.setString(5,f);
					st.setBinaryStream(6, fin,fin.available());

					st.execute();

				}

				con.close();

			}catch(Exception ex){

				System.out.println("error: "+ex);
				
			}

		}

		void table(){

			// this function creates a new table with the tabel name of the user

			try{

				String str = t1.getText();

				Class.forName("com.mysql.jdbc.Driver");

				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");

				String CREATE_TABLE = "CREATE TABLE "+str+" ("
                    + "id INT,"
                    + "name VARCHAR(45),"
                    + "last_name VARCHAR(45),"
					+ "email VARCHAR(50),"
					+ "password VARCHAR(50),"
					+ "country VARCHAR(50),"
					+ "image LONGBLOB,"
					+ "chats TEXT,"
					+ "PRIMARY KEY (id))";

				stm = conn.createStatement();

				stm.execute(CREATE_TABLE);
			
			}catch(Exception e){

				System.out.println(e);

			}

		}
	
	public void actionPerformed(ActionEvent ae) {
	
		if(ae.getSource()== b1) {
		
			if((t1.getText().trim().length()==0)||(t2.getText().trim().length()==0)||(t3.getText().trim().length()==0)||(t4.getText().trim().length()==0)) {
		
			JOptionPane.showMessageDialog(o,"All Fields are Mandatory.","Alert",JOptionPane.WARNING_MESSAGE);	
			
			}else {

			 	int a = JOptionPane.showConfirmDialog(o,"Are you sure?");  
			
				if(a==JOptionPane.YES_OPTION){  

					register();
					table();
					this.dispose();	
					new LoginPage();
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
				}  

			}
		}

		if(ae.getSource()== b2) {

		 	t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			//  t5.setText("");
			t7.setText("");
			// t8.setText("");
			// c1.setSelectedIndex(0);
			c2.setSelectedIndex(0);

		}

		if(ae.getSource()== b3){

			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
			fileChooser.addChoosableFileFilter(filter);
			int result = fileChooser.showSaveDialog(null);

			if(result == JFileChooser.APPROVE_OPTION){
				
				File selectedFile = fileChooser.getSelectedFile();
				String path = selectedFile.getAbsolutePath();
				l11.setIcon(ResizeImage(path));
				s = path;

				t7.setText(s);
				 
			}else if(result == JFileChooser.CANCEL_OPTION){

				System.out.println("No Data");

			}

	 	}

		 if(ae.getSource()== b4){

			this.dispose();	
			new LoginPage();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}

	}

	private Icon ResizeImage(String path) {

		ImageIcon MyImage = new ImageIcon(path);
		Image img = MyImage.getImage();
		Image newImage = img.getScaledInstance(l11.getWidth(), l11.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImage);
		return image;    
	
	}

}