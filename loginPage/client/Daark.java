package loginPage.client;

import javax.swing.border.Border;
import java.awt.*;
import swing.ComboBox;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.sql.*;
import java.io.*;
import java.net.*;
import java.util.Set;
import static java.lang.System.out;

public class Daark extends JFrame implements ActionListener{

	//sql variables
	Connection con;
	Statement st;
	PreparedStatement stm;
	ResultSet rs;

	//soket variables
    String username;
    PrintWriter pw;
	BufferedReader br;
	Socket chatusers;
	
	//awt variables
	static JPanel p1,p2,p3,p4;
	static JMenuBar mb;
	JMenu m,n;
	JMenuItem m1,m2,m3,m4;
	static JTextField t3;
	static JLabel dp,n1,dp2,n2;
	static JButton b1,b2,b3,b4,b5,b6;
	static JTextArea a;
	JScrollPane s1,s2;
	Border blackline = BorderFactory.createLineBorder(Color.black);
	Border whiteline = BorderFactory.createLineBorder(Color.white);
	static String name;
	static String kfc;
	Font f2 = new Font("Segoe UI",Font.ITALIC,15);
	
	public Daark(String uname, String servername) throws Exception{

		super(uname);
        this.username = uname;
        chatusers = new Socket(servername,1201);
        br = new BufferedReader(new InputStreamReader(chatusers.getInputStream()));
        pw = new PrintWriter(chatusers.getOutputStream(),true);
        pw.println(uname);
        buildInterface();
		new MessageThread().start();
		
	}

	public void buildInterface(){

		p1 = new JPanel();
		p1.setBounds(0, 0,1540, 80);
		p1.setLayout(null);
		p1.setBorder(blackline);
		

		p2 = new JPanel();
		p2.setBounds(0,80, 500, 735);
		p2.setBorder(blackline);
		p2.setLayout(null);
		
		p3 = new JPanel();
		p3.setBounds(500,80,790,503);
		p3.setBorder(blackline);
		p3.setLayout(null);
		
		p4 = new JPanel();
		p4.setBounds(500,553,790,90);
		p4.setBorder(blackline);
		p4.setLayout(null);
		
		m = new JMenu("File");
		n = new JMenu("Edit");
		mb = new JMenuBar();
		m1 = new JMenuItem("New");
		m2 = new JMenuItem("Open");
		m3 = new JMenuItem("Cut");
		m4 = new JMenuItem("Copy");

		m.add(m1);
		m.add(m2);
		n.add(m3);
		n.add(m4);
		mb.add(m);
		mb.add(n);
		setJMenuBar(mb);

		dp = new JLabel();
		dp.setBounds(20,16,35,35);
		p1.add(dp);

		ImageIcon user = new ImageIcon("library/user.png");
		Image G = user.getImage();
		Image J = G.getScaledInstance(dp.getWidth(), dp.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon K = new ImageIcon(J);
		dp.setIcon(K);

		pro_pic(LoginPage.set);

		ImageIcon image =  new ImageIcon("library/Profile_pic/test_image.png");
		Image H = image.getImage();
		Image I = H.getScaledInstance(dp.getWidth(), dp.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon M = new ImageIcon(I);
		dp.setIcon(M);

		n1 = new JLabel();
		n1.setBounds(100,20,150,35);
		name = LoginPage.set;
		n1.setText(""+name.substring(0,1).toUpperCase() + name.substring(1));
		n1.setForeground(new Color(255, 255, 255));
		// n1.setBorder(blackline);
		// n1.setEditable(false);
		n1.setFont(new Font("Segoe UI",Font.ITALIC,20));
		p1.add(n1);

		kfc =	n1.getText().toLowerCase();

		dp2 = new JLabel();
		dp2.setBounds(510,16,35,35);
		ImageIcon user2 = new ImageIcon("library/user.png");
		Image G1 = user2.getImage();
		Image J1 = G1.getScaledInstance(dp.getWidth(), dp.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon K1 = new ImageIcon(J1);
		dp2.setIcon(K1);
		dp2.setVisible(false);
		p1.add(dp2);

		n2 = new JLabel();
		n2.setBounds(590,20,150,35);
		n2.setForeground(new Color(255, 255, 255));
		// n2.setBorder(blackline);
		// n2.setEditable(false);
		n2.setFont(new Font("Segoe UI",Font.ITALIC,20));
		p1.add(n2);

		
		t3 = new JTextField("Write Your Messgae Here");
		t3.setFont(f2);
		t3.addKeyListener(o);
		//t3.setBorder(whiteline);
		p4.add(t3);
		t3.setBounds(4,38,539,35);
		a = new JTextArea();
		//a.setBounds(0,1,760,503);
		//a.setBorder(whiteline);
		a.setEditable(false);
		a.setFont(f2);
		a.setBackground(new Color(236,240,241));
		s1 = new JScrollPane(a);
		s1.setBounds(0,1,780,503);
		s1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		p3.add(s1);
		//p3.add(a);
		//add(a);
		
		b1 = new JButton("Send");
		b1.setBounds(555,38,100,35);
		//b1.setBorder(blackline);
		b1.setBackground(new Color(211, 84, 0));
		b1.setForeground(Color.black);
		b1.setFont(f2);
		p4.add(b1);
		
		b2 = new JButton("Add");
		b2.setBounds(860,20,100,35);
		b2.setBackground(new Color(46, 204, 113));
		b2.setFont(f2);
		//b2.setBorder(blackline);
		p1.add(b2);
		
		b3 = new JButton("Settings");
		b3.setBounds(1010,20,100,35);
		b3.setBorder(blackline);
		b3.setFont(f2);
		b3.setBackground(new Color(52, 152, 219));
		p1.add(b3);

		b4 = new JButton("Ketan");
		b4.setFont(f2);
		b4.setBackground(new Color(220, 221, 225));
		//b4.setBorder(whiteline);
		p2.add(b4);
		b4.setBounds(0, 2, 498, 70);

		b5 = new JButton("Logout");
		b5.setBounds(1160, 20, 100, 35);
		b5.setBackground(new Color(231,76,60));
		b5.setBorder(blackline);
		b5.setFont(f2);
		p1.add(b5);

		b6 = new JButton("Save");
		b6.setBounds(670,38,100,35);
		b6.setBackground(new Color(155,89,182));
		b6.setForeground(Color.black);
		b6.setFont(f2);
		p4.add(b6);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		p1.setBackground(new Color(24,44,97));
		p2.setBackground(new Color(255,255,255));
		p3.setBackground(Color.gray);
		p4.setBackground(new Color(44,58,71));

		add(p1);
		add(p2);
		add(p3);
		add(p4);
		setExtendedState(JFrame.MAXIMIZED_BOTH);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		//setResizable(false);
		setVisible(true);
		Image icon = Toolkit.getDefaultToolkit().getImage("library/logo.jpeg");
		setIconImage(icon);

	}


	void pro_pic(String nm){

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");

			String query = "Select * from project where name = '"+nm+"'";

			st = con.createStatement();

			rs = st.executeQuery(query);

			// while(true){

				// if(){

					while(rs.next()){

						Blob b = rs.getBlob("image");
						byte[] img = b.getBytes(1, (int) b.length());
						System.out.println(img);

						File file = new File("library/Profile_pic/test_image.png");
						FileOutputStream fout = new FileOutputStream(file);
						fout.write(img);

						fout.close();

					}
				// }

				// try{

				// 	// this.wait(1000);

				// }catch(Exception e){

				// 	System.out.println(e);

				// }

			// }
			
		} catch (Exception e) {
			
			System.out.println("error: "+e);

		}

	}

	void person(String per){

		try{

			// dbc();

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");

			System.out.println("connected !");

			String query = "SELECT * FROM "+per;

			st = con.createStatement();

			rs = st.executeQuery(query);

			while(rs.next()){

				String a = rs.getString("name");
				b4.setText(a);

			}

		}catch(Exception ex){

			System.out.println(ex);

		}

	}

	public void createAndShowGUI() {

        setTitle("DAARK");
        addComponentListener(new ComponentAdapter() {

			@Override
			
            public void componentResized(ComponentEvent e) {
				
				titleAlign();
			
			}

        });

       	pack();
        setLocationRelativeTo(null);

	}
	
	private void titleAlign() {

        Font font = getFont();

        String currentTitle = getTitle().trim();
        FontMetrics fm = getFontMetrics(font);
        int frameWidth = getWidth();
        int titleWidth = fm.stringWidth(currentTitle);
        int spaceWidth = fm.stringWidth(" ");
        int centerPos = (frameWidth / 2) - (titleWidth / 2);
        int spaceCount = centerPos / spaceWidth;
        String pad = "";
        pad = String.format("%" + (spaceCount - 14) + "s", pad);
        setTitle(pad + currentTitle);

	}
	
	class MessageThread extends Thread{

        @Override

        public void run(){

            String line;

            try {
                
                while(true){

                    line  = br.readLine();
                    a.append(line+"\n");

                }
                
            } catch (Exception e) {
            
                System.out.println(e.getMessage());
            }
        }
    }

	public static void main(String[] args) {
	
		// EventQueue.invokeLater(() -> {

		// 	new clienn2().createAndShowGUI();
		
		// });

		String SetUserName = JOptionPane.showInputDialog(null, "please enter your name Name: ","kA chat app.",JOptionPane.PLAIN_MESSAGE);

        String servername = "localhost";

        try{

            new Daark(SetUserName, servername);

        }catch(Exception e){

            System.out.println(e.getMessage());
        
        }

	}

	@Override
	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()== b1) {

			//send button

			if(t3.getText().equals("")) {

			}else{

				a.append("you: "+t3.getText()+"\n");

				pw.println(t3.getText());
            	t3.setText(null); 
				// t3.setText("");

			}
			
  		}
	
		if(e.getSource()==b2) {

			//add button

			new SwingSearchApp();
		
		}
	
		if(e.getSource()==b3) {

			//setting button
		
			new Settings();

		}

		if(e.getSource() == b4){

			//chat head button
			
			String c = b4.getText().trim();
			String HD =	n1.getText().trim();
			dp2.setVisible(true);

			pro_pic(c);

			ImageIcon image =  new ImageIcon("library/Profile_pic/test_image.png");
			Image H = image.getImage();
			Image I = H.getScaledInstance(dp.getWidth(), dp.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon M = new ImageIcon(I);
			dp2.setIcon(M);

			try{

				Class.forName("com.mysql.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");

				String query = "select * from "+HD+" where name = '"+c+"'";

				st = con.createStatement();

				rs = st.executeQuery(query);

				while(rs.next()){

					String merc = rs.getString("chats");

					if(merc != ""){

						a.setText(merc);

					}else{

						a.setText("");

					}
				}

			}catch(Exception ex){

				System.out.println(ex);
				
			}

			n2.setText(""+c.substring(0,1).toUpperCase() + c.substring(1));

		}

		if(e.getSource() == b5){

			//logout button
			try{
			
				con.close();
				pw.println("end");
				// System.exit(0);
				new LoginPage();
				this.dispose();

			}catch(Exception ex){

				System.out.println(ex);
				
			}

		}

		if(e.getSource() == b6){

			//save button

			JOptionPane.showMessageDialog(null, "Your all chats are saved! on our server");

			try{

				String bmw = n2.getText().toLowerCase();

				System.out.println(bmw);

				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");

				String query = "update "+n1.getText().toLowerCase()+" set chats = ?"+" where name = ?";

				stm = con.prepareStatement(query);
				
				String merc = a.getText();

				stm.setString(1,merc);
				stm.setString(2,bmw);

				stm.executeUpdate();

				con.close();
				

			}catch(Exception ex){

				System.out.println(ex);

			}
		}
	}

	KeyListener o = new KeyListener() {
					
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			
				if(t3.getText().equals("")) {

				}else {

					a.append("You: "+t3.getText()+"\n");
					pw.println(t3.getText());
					t3.setText("");
				
				}

			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			
		}

	};

}