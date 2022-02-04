package project;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 

class first2 extends JFrame implements ActionListener{

    Label user = new Label("username");
    Label pass = new Label("Password");
    TextField u = new TextField("username");
    TextField p = new TextField("password");
    Button a = new Button("Login");

    public Container c;

    public first2(){

        Scanner scan = new Scanner(System.in);

        setTitle("LOGIN FORM");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane(); 
        c.setLayout(null);

        user.setBounds(100, 200, 100, 25);
        c.add(user);
        u.setBounds(300, 200, 100, 25);
        c.add(u);
        c.add(pass);
        c.add(p);
        p.setBounds(300, 250, 100, 25);
        a.setBounds(150, 400, 50, 30);
        a.addActionListener(new ActionListener());
        c.add(a);

        c.setVisible(true);
    }

    public void actionPerformed(ActionEvent d){

        String e = u.getText();
        String f = p.getText();

         if(e.equals("ketan") && f.equals("aggarwal")){
        
            JOptionPane.showMessageDialog(frame, "you are sucessful");

            }else{

               JOptionPane.showMessageDialog(frame, "please try agian");;
                
            }

        } 
    }    


class ui2 {

    public static void main(String[] args) {
        
        first2 k = new first2();

    }
}