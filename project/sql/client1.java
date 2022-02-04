package project.sql;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

public class client1 extends JFrame implements ActionListener{

    static JTextArea ta2;
    JTextField t2;
    JButton b2;

    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;

    client1(){

        setLayout(null);
        setVisible(true);
        setResizable(true);
        setTitle("test client app".toUpperCase());
        setSize(550,550);

        ta2 = new JTextArea();
        ta2.setBounds(50,50,400,300);
        add(ta2);
        
        t2 = new JTextField();
        t2.setBounds(50, 360, 320, 40);
        add(t2);

        b2 = new JButton("Send");
        b2.setBounds(380, 360, 70, 40);;
        b2.addActionListener(this);
        add(b2);
    
        addWindowListener(new WindowAdapter(){  

            public void windowClosing(WindowEvent e) {  
    
                dispose();  
             
            }

        });    
    }

public void actionPerformed(ActionEvent f){

    try{

        String msgout = "";
        msgout = t2.getText().trim();
        dout.writeUTF(msgout);
    
    }catch(Exception e){

        System.out.println(e);

    }

}

    public static void main(String[] args) {
        
        new client1();

        try{

            s = new Socket("127.0.0.1",1201);
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            
            String magin = "";

            while(!magin.equals("exit")){

                magin = din.readUTF();
                ta2.setText(ta2.getText().trim()+"\n server:"+magin);
            }

        }catch(Exception e){

            System.out.println(e);

        }
    
    }

}