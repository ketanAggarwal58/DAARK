package loginPage.client;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.io.*;

public class profile extends JFrame implements ActionListener {

    //awt variables

    JPanel p1;
    JLabel l,l1,l2,l3,l4,l5,l6;
    JLabel t1,t2,t3,t4,t5;
    ImageIcon img;
    JOptionPane o = new JOptionPane();
    JButton B1,B2,B3; 
    //SQL variables

    Connection con;
    Statement st;
    PreparedStatement stm;
    ResultSet rs; 

    profile(){

        p1 = new JPanel();
        p1.setBackground(new Color(231,76,60));
        p1.setLayout(null);
        p1.setBounds(0,0,500,35);

        l = new JLabel("Profile".toUpperCase());
        l.setBounds(205,5,70,25);
        l.setForeground( Color.BLACK);
        l.setFont(new Font("Segoe UI",Font.ITALIC,12));
    
        p1.add(l);

        l1 = new JLabel();
        l1.setBounds(160,50,144,144);
        l1.setBackground(Color.LIGHT_GRAY);
 
        img =  new ImageIcon("library/user.png");
        Image G = img.getImage();
        Image J = G.getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon K = new ImageIcon(J);
        l1.setIcon(K);
   
        l2 = new JLabel("Name");
        l2.setBounds(90,215,70,30);
        l2.setFont(new Font("Segoe UI",Font.ITALIC,12));

        t1 = new JLabel();
        t1.setBounds(230,215,180,27);
        // t1.setEditable(false);   
        t1.setFont(new Font("Segoe UI",Font.ITALIC,12));     

        l3 = new JLabel("Last Name");
        l3.setBounds(90,245,70,30);
        l3.setFont(new Font("Segoe UI",Font.ITALIC,12));

        t2 = new JLabel();
        t2.setBounds(230,245,180,27);
        // t2.setEditable(false);
        t2.setFont(new Font("Segoe UI",Font.ITALIC,12));

        l4 = new JLabel("E-mail");
        l4.setBounds(90,275,70,30);
        l4.setFont(new Font("Segoe UI",Font.ITALIC,12));
        
        t3 = new JLabel();
        t3.setBounds(230,275,180,27);
        // t3.setEditable(false);
        t3.setFont(new Font("Segoe UI",Font.ITALIC,12));

        l5 = new JLabel("Password");
        l5.setBounds(90,305,70,30);
        l5.setFont(new Font("Segoe UI",Font.ITALIC,12));

        t4 = new JLabel();
        t4.setBounds(230,305,180,27);
        // t4.setEditable(false);
        t4.setFont(new Font("Segoe UI",Font.ITALIC,12));

        l6 = new JLabel("Country");
        l6.setBounds(90,335,70,30);
        l6.setFont(new Font("Segoe UI",Font.ITALIC,12));

        t5 = new JLabel();
        t5.setBounds(230,335,180,27);
        t5.setFont(new Font("Segoe UI",Font.ITALIC,12));
        // t5.setEditable(false);

        B1 = new JButton("Update");
        B1.setBounds(80,405,120,27);
        B1.addActionListener(this);
        B1.setFont(new Font("Segoe UI",Font.ITALIC,12));
        B1.setBackground(new Color(183,21,64));
        B1.setForeground(new Color(255,255,255));

        B2 = new JButton ("Close");
        B2.setBounds(240,405,120,27);
        B2.setFont(new Font("Segoe UI",Font.ITALIC,12));
        B2.addActionListener(this);
        B2.setBackground(new Color(30,55,153));
        B2.setForeground(new Color(225,225,225));

        B3 = new JButton("Delete Account");
        B3.setBounds(80,455,280,27);
        B3.setFont(new Font("Segoe UI",Font.ITALIC,12));
        B3.addActionListener(this);
        B3.setBackground(Color.red);
        B3.setForeground(new Color(225,225,225));


        // add(l);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(p1);
        add(B1);
        add(B2);
        add(B3);

        setLayout(null);
        setVisible(true);
        setResizable(false);
        setTitle("profile");
        setSize(500,580);
        
        db();

    }

public void db(){

    try{

        Class.forName("com.mysql.jdbc.Driver");
      
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
     
        String query = "Select * from project where name = '"+LoginPage.set+"'";
      
        st = con.createStatement();
      
        rs = st.executeQuery(query);

        while(rs.next()){

            String A = rs.getString("name");
            String B= rs.getString("last_name");
            String C = rs.getString("email");
            String D = rs.getString("password");
            String E = rs.getString("country");
            Blob F = rs.getBlob("image");
            byte[] g = F.getBytes(1, (int) F.length());
            
            File file = new File("library/Profile_pic/test_image.png");
            FileOutputStream fout = new FileOutputStream(file);
            fout.write(g);
            

            t1.setText(A);
            t2.setText(B);
            t3.setText(C);
            t4.setText(D);
            t5.setText(E);

            fout.close();
        }

        ImageIcon image =  new ImageIcon("library/Profile_pic/test_image.png");
        Image H = image.getImage();
        Image I = H.getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon M = new ImageIcon(I);
        l1.setIcon(M);

    }
    catch(Exception k10){

        System.out.println(k10);

    }

}

    public static void main(String[] args) {
        
        new profile();

    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == B1){

            //update button

            new update();
            this.dispose();
            
        }

        if(e.getSource() == B2){

            //homepage button

            this.dispose();
        }

        if(e.getSource() == B3){

            //delete button

            int a = JOptionPane.showConfirmDialog(o,"Are you sure?");

            if(a==JOptionPane.YES_OPTION){

                try{

                    String t = t1.getText();

                    Class.forName("com.mysql.jdbc.Driver");

                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");

                    String query  = "Delete from project Where name = '"+t+"'";
                    String table = "DROP TABLE "+t;

                    st = con.createStatement();

                    st.executeUpdate(query);
                    st.executeUpdate(table);

                    con.close();
                    this.dispose();
                    this.dispose();
                    new Register();

                }catch(Exception ex){

                    System.out.println("error: "+ ex);

                }
            
            }
        }
    }
}