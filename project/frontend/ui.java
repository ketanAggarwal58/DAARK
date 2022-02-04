package project;

import java.awt.*;
import javax.swing.*;

class First extends JFrame{

Container a;
Label title, user, pass;
TextField c,d;
Button b;

    First(){

        setTitle("login Form"); 
        setBounds(300, 90, 500, 500); 
        //setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 

        a = getContentPane(); 
        a.setLayout(null); 
        
        title = new Label("lOGIN");
        title.setBounds(100,200,50,30);
        title.setFont(new Font("Times new roman", Font.PLAIN, 30));
        a.add(title);
       
        c = new TextField("user name");
        c.setBounds(200,200,50,30);
        a.add(c); 
    
    }
}

class ui{
    public static void main(String[] args){

        First k = new First();
        
    }
}
