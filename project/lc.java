package project;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

class lc extends JFrame implements ActionListener {
    
    JTextField t1;
    JPasswordField p1;
    Label user, pass;
    JButton submit;

    private Connection con;
    private Statement st;
    private ResultSet rs;

    lc(){

        setLayout(null);
        setVisible(true);
        setResizable(true);
        setTitle("test Login page".toUpperCase());

        user = new Label("Username");
        user.setBounds(100, 100, 50, 30);

        t1 = new JTextField();
        t1.setBounds(250, 100, 80, 30);

        pass = new Label("Password");
        pass.setBounds(100, 250, 60, 30);

        p1 = new JPasswordField();
        p1.setBounds(250, 250, 80, 30);

        submit = new JButton("login");
        submit.setBounds(150, 350, 90, 50);
        submit.addActionListener(this);

        add(user);
        add(t1);
        add(pass);
        add(p1);
        add(submit);

        addWindowListener(new WindowAdapter(){  

            public void windowClosing(WindowEvent e) {  
        
                dispose();  
                 
            }

        });

    }

    public void actionPerformed(ActionEvent f){

        String a = t1.getText().trim();
        String b = p1.getText().trim();
        String error = "";

        if(a.equals("")){

            error += "username is required  ";

            JOptionPane.showMessageDialog(null, error);

        }

        if(b.equals("")){

            error += "password is required";

            JOptionPane.showMessageDialog(null, error);

        }


        try {
            
            System.out.println(a);

            System.out.println(b);

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            st = con.createStatement();

            String query = "select * from login where name = '"+a+"'";

            rs = st.executeQuery(query);

            while(rs.next()){

                String c = rs.getString("name");
                String d = rs.getString("password");

                if(t1.getText().trim().equals(c) && p1.getText().trim().equals(d)){

                    System.out.println("yay! we loged in");

                    JOptionPane.showMessageDialog(null, "yay! you loged in");

                }else{

                    System.out.println("please try again later");

                    JOptionPane.showMessageDialog(null, "please try again later");
                } 

                System.out.println(c);
                System.out.println(d);
            }

        } catch (Exception e) {
            
            System.out.println(e);

        }

    }

    public static void main(String[] args) {
        
        new lc();

    }

}