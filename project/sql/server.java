package project.sql;

//import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
//
public class server extends JFrame implements ActionListener {

    static JTextArea ta1;
    JTextField t1;
    JButton b1;

    Connection con;
    Statement st;
    PreparedStatement stm;
    ResultSet rs;

    static ServerSocket ss;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;

    server(){

        setLayout(null);
        setVisible(true);
        setResizable(true);
        setTitle("test server app".toUpperCase());
        setSize(500,400);

        ta1 = new JTextArea();
        ta1.setBounds(50,50,400,300);
        add(ta1);
        
        t1 = new JTextField();
        t1.setBounds(50, 360, 320, 40);
        add(t1);

        b1 = new JButton("Send");
        b1.setBounds(380, 360, 70, 40);;
        b1.addActionListener(this);
        add(b1);
    
    addWindowListener(new WindowAdapter(){  

        public void windowClosing(WindowEvent e) {  
    
            dispose();  
             
        }

    });    

}

public void db(){

    try{

        Class.forName("com.jdbc.mysql.Driver");

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

    }catch(Exception e){

        System.out.println(e);
    }
}

public void actionPerformed(ActionEvent f){

    try{
    
        //soketing
        String msgout = "";
        msgout = t1.getText().trim();
        dout.writeUTF(msgout);

        //mysql

        db();
        
        String query = "update chat_system set chats = ?" +" where name = 'ketan'";

        stm = con.prepareStatement(query);

        stm.setString(1, msgout);

        stm.executeQuery();


    }catch(Exception e){

        System.out.println(e);

    }

}

    public static void main(String[] args) {
        
        new server();

        String magin = "";

        try{
    
            ss = new ServerSocket(1201);
            s = ss.accept();
    
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
    
            while (!magin.equals("exit")) {
    
                magin = din.readUTF();
                ta1.setText(ta1.getText().trim()+"\n"+magin);
                
            }
    
        }catch(Exception e){

            System.out.println(e);
    
        }
    
    }

}