package project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class assignment extends Frame implements ActionListener{

    Label login, user, pass, forget, signup;
    TextField username, test;
    JPasswordField password;
    Button submit;

    assignment(){

        setVisible(true);
        setLayout(null);
        setSize(1000, 1000);
        setTitle("Login page");

        login = new Label("Login".toUpperCase());
        login.setBounds(500,50,100,100);
        login.setFont(new Font("Times New Roman", Font.PLAIN, 20));   

        user = new Label("Username".toUpperCase());
        user.setBounds(250,150,80,20);

        username = new TextField("Username");
        username.setBounds(450,150,150,20);

        pass = new Label("password".toUpperCase());
        pass.setBounds(250,200,80,30);

        password  = new JPasswordField("password");
        password.setBounds(450,200,150,30);

        submit = new Button("Submit");
        submit.setBounds(350,300,80,40);
        submit.addActionListener(this);

        forget = new Label("forget".toUpperCase());
        forget.setBounds(300,350,60,30);

        signup = new Label("sign up".toUpperCase());
        signup.setBounds(400,350,60,30);
        
        test = new TextField();
        test.setBounds(100,700,100,100);

        add(login);
        add(user);
        add(username);
        add(pass);
        add(password);
        add(submit);
        add(forget);
        add(signup);
        add(test);

        addWindowListener(new WindowAdapter(){  

            public void windowClosing(WindowEvent e) {  
        
                dispose();  
                 
            }

        });

    }

    public void actionPerformed(ActionEvent f){

        String a, c = "ketan", d = "aggarwal";

        a = username.getText();

        String b = new String(password.getPassword());

        if((a == c) && (b == d)){

            test.setText("yay login works");
        
        }else{

            test.setText("sorry try again with fresh code");
        }

    }

    public static void main(String[] args){

        new assignment();

    }
}