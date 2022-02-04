package project;

import javax.swing.*;
import java.awt.*;
import java.awt.color.*;
import java.awt.event.*;

class RP extends JFrame implements ActionListener{

    JLabel signup, name, lastName, email, contact, pass, cpass, signin;
    TextField nm, lm, em, con;
    JPasswordField password, conformpass;
    JButton sign;
    JScrollBar hBar, vBar;

    RP(){

        setLayout(null);
        setVisible(true);
        setSize(500,500);
        setTitle("Sign up".toUpperCase());
        setResizable(true);

        hBar = new JScrollBar(JScrollBar.HORIZONTAL, 30, 20, 0, 800);
        vBar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500);

        signup = new JLabel("sign up".toUpperCase());
        signup.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        signup.setBounds(200,50,120,30);

        name = new JLabel("Name".toUpperCase());
        name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        name.setBounds(70,100,70,30);

        nm = new TextField("username");
        nm.setBounds(200,100,120,30);

        lastName = new JLabel("Last name".toUpperCase());
        
        add(hBar);
        add(vBar);
        add(signup);
        add(name);
        add(nm);

        addWindowListener(new WindowAdapter(){  

            public void windowClosing(WindowEvent e) {  
        
                dispose();  
                 
            }

        });

    }

    public void actionPerformed(ActionEvent f){}

    public static void main(String[] args){
        
        new RP();

    }
}