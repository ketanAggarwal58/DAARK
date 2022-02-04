package loginPage.client;

import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;  
import java.sql.*;  
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class SwingSearchApp extends JFrame implements ActionListener {  

    JLabel l1;
    JTextArea ta;
    JTextField t1, t2;
    JPanel p1;
    JButton b1,b2,b3,b4;
    String name,email;

    //sql variables

    Connection con;
    Statement st;
    PreparedStatement stm;
    ResultSet rs;
    
    SwingSearchApp(){

        setLayout(null);
        setVisible(true);
        setSize(400, 550);
        setTitle("Add New CHit-CHater");
        setBackground(new Color(223, 230, 233));

        l1 = new JLabel("Enter Name");
        l1.setBounds(30,30,70,35);

        t1 = new JTextField();
        t1.setBounds(120,32,240,30);

        b1 = new JButton("Search");
        b1.setBounds(140,90,80,30);
        b1.addActionListener(this);
        b1.setBackground(new Color(129, 236, 236));

        p1 = new JPanel();
        p1.setBounds(30,150,340,200);
        p1.setLayout(null);
        p1.setBackground(Color.LIGHT_GRAY);

        ta = new JTextArea();
        ta.setBounds(5,5,200,200);
        ta.setBackground(Color.white);
        ta.setBackground(Color.LIGHT_GRAY);
        p1.add(ta);

        b2 = new JButton("Select");
        b2.setBounds(260,5,80,30);
        b2.setBackground(new Color(129, 236, 236));
        b2.addActionListener(this);
        p1.add(b2);
        
        t2 = new JTextField();
        t2.setBounds(30,400,340,30);

        b3 = new JButton("add");
        b3.setBounds(80,450,80,30);
        b3.addActionListener(this);
        b3.setBackground(new Color(255, 118, 117));

        b4 = new JButton("Cancel");
        b4.setBounds(200,450,80,30);
        b4.addActionListener(this);
        b4.setBackground(new Color(162, 155, 254));

        add(t2);
        add(l1);
        add(t1);
        add(b1);
        add(p1);
        add(b3);
        add(b4);

    }

    void db(){

        try{
        
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
        
        }catch(Exception e){

            System.out.println(e);
        
        }
    
    }

    public static void main(String[] args) {
        
        new SwingSearchApp();

    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==b1){

            //search

            name = t1.getText();

            try{
    
               db();
    
                st = con.createStatement();

                System.out.println("connected");
    
                String query = "SELECT * FROM project WHERE name = '"+name+"'";
    
                rs = st.executeQuery(query);
    
                while(rs.next()){
    
                    String b = rs.getString("email");
    
                    ta.setText(b+"\n");
                   
                } 
    
            }catch(Exception ex){
    
                System.out.println(ex);
    
            }

        }
        
        if(e.getSource()==b2){

            //select

            t2.setText(ta.getText());

        }

        if(e.getSource()==b3){

            //add

            try{

                db();

                email = t2.getText();

                st = con.createStatement();

                System.out.println("connected");
    
                String query = "SELECT * FROM project WHERE email = '"+email+"'";
    
                rs = st.executeQuery(query);
    
                while(rs.next()){
    
                    String b = rs.getString("name");
                    String c = rs.getString("last_name");
                    String d = rs.getString("email");   
                    String f = rs.getString("password");
                    String g = rs.getString("country");
                    String h = rs.getString("image");

                    String sql = "insert into "+Daark.kfc+" (id, name, last_name, email, password, country, image)" + "Values('0',?,?,?,?,?,?)";
                    
                    stm = con.prepareStatement(sql);
                    stm.setString(1,b);
                    stm.setString(2,c);
                    stm.setString(3,d);
                    stm.setString(4,f);
                    stm.setString(5,g);
                    stm.setString(6,h);

                    stm.execute();
    
                } 

            }catch(Exception ex){

                System.out.println(ex);

            }

        }

        if(e.getSource()==b4){

            //cancel

            t1.setText("");
            ta.setText("");
            t2.setText("");

            // this.dispose();
            
        }

    }

}