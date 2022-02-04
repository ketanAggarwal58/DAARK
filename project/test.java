package project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class test extends Frame implements ActionListener {

    // all the varibale including SQL Statement and for GUI

    Label name, lastname, age;
    TextField nm, lm, a;
    Button signup;

    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;
   
    test(){

        // elements

        setLayout(null);
        setVisible(true);
        setResizable(true);
        setTitle("test registration page".toUpperCase());

        name = new Label("Name".toUpperCase());
        name.setBounds(50,100,60,30);
        nm = new TextField();
        nm.setBounds(150,100,80,30);
        lastname = new Label("Lastname".toUpperCase());
        lastname.setBounds(50,200,80,30);
        lm = new TextField();
        lm.setBounds(150,200,80,30);
        age = new Label("age".toUpperCase());
        age.setBounds(50,300,60,30);
        a = new TextField();
        a.setBounds(150,300,80,30);
        signup = new Button("Register");
        signup.setBounds(100,400,70,30);
        signup.addActionListener(this);

        // adding all the elements in the frame of GUI

        add(name);
        add(nm);
        add(lastname);
        add(lm);
        add(age);
        add(a);
        add(signup);

        // disposal system for GUI

        addWindowListener(new WindowAdapter(){  

            public void windowClosing(WindowEvent e) {  
        
                dispose();  
                 
            }

        });

    }

    public void actionPerformed(ActionEvent f){

        /*
        *
        varibles resposible for taking and storing the value enter
        in the textfield in the GUI        
        *
        */

        String b = nm.getText().trim();
        String c = lm.getText().trim();
        String d = a.getText().trim();
        JFrame k = new JFrame();

        try {

            // eastablishing the connection to the database

            Class.forName("com.mysql.jdbc.Driver");

            //database - localhost, username - root, password - NULL

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

            //table person
            
            String query = "insert into person (id, name, last_name, age)" + "Value('0',?,?,?)";

            st = con.prepareStatement(query);
            
            //set the data in the above query strting

            st.setString(1, b);
            st.setString(2, c);
            st.setString(3, d);

            // execute the statement

            st.execute();

            // here we break the connection from the database 

            con.close();

            JOptionPane.showMessageDialog(k, "registration complete");
    

        } catch (Exception ex) {
            
            System.out.println("error: "+ex);

            JOptionPane.showMessageDialog(k, ex, "Registration", JOptionPane.CANCEL_OPTION);


        }

    }

    public static void main(String[] args) {
        
        new test();        

    }

}