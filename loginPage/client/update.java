package loginPage.client;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.sql.*;
import java.awt.event.*;
import java.io.*;

public class update extends JFrame implements ActionListener {

    //awt variables

    JPanel p1;
    JLabel l,l1,l2,l3,l4,l5,l6;
    TextField t1,t2,t3,t4,t5;
    ImageIcon img;
    JButton B1,B2,b3,b4,b5,b6,b7,b8; 
    String s = "",s1,s2,s3,s4,s5;

    //SQL variables

    Connection con;
    Statement st;
    PreparedStatement stm;
    ResultSet rs; 

    update(){

        p1 = new JPanel();
        p1.setBackground(new Color(231,76,60));
        p1.setLayout(null);
        p1.setBounds(0,0,500,35);

        l = new JLabel("update".toUpperCase());
        l.setBounds(205,5,70,25);
        l.setForeground( Color.BLACK);
        l.setFont(new Font("Segoe UI",Font.ITALIC,12));
    
        p1.add(l);

        l1 = new JLabel();
        l1.setBounds(160,45,144,120);
        l1.setBackground(Color.LIGHT_GRAY);

        b3 = new JButton("Change");
        b3.setBounds(168,175,120,20);
        b3.setFont(new Font("Segoe UI",Font.ITALIC,10));
        b3.addActionListener(this);
   
        l2 = new JLabel("Name");
        l2.setBounds(50,215,70,30);
        l2.setFont(new Font("Segoe UI",Font.ITALIC,12));

        t1 = new TextField(20);
        t1.setBounds(160,215,180,27);
        t1.setEditable(false);   
        t1.setFont(new Font("Segoe UI",Font.ITALIC,12));     

        b4 = new JButton("Update");
        b4.setBounds(360,215,90,27);
        b4.setFont(new Font("Segoe UI",Font.ITALIC,12));
        b4.addActionListener(this);

        l3 = new JLabel("Last Name");
        l3.setBounds(50,245,70,30);
        l3.setFont(new Font("Segoe UI",Font.ITALIC,12));

        t2 = new TextField(20);
        t2.setBounds(160,245,180,27);
        t2.setEditable(false);
        t2.setFont(new Font("Segoe UI",Font.ITALIC,12));

        b5 = new JButton("Update");
        b5.setBounds(360,245,90,27);
        b5.setFont(new Font("Segoe UI",Font.ITALIC,12));
        b5.addActionListener(this);

        l4 = new JLabel("E-mail");
        l4.setBounds(50,275,70,30);
        l4.setFont(new Font("Segoe UI",Font.ITALIC,12));
        
        t3 = new TextField(20);
        t3.setBounds(160,275,180,27);
        t3.setEditable(false);
        t3.setFont(new Font("Segoe UI",Font.ITALIC,12));

        b6 = new JButton("Update");
        b6.setBounds(360,275,90,27);
        b6.setFont(new Font("Segoe UI",Font.ITALIC,12));
        b6.addActionListener(this);

        l5 = new JLabel("Password");
        l5.setBounds(50,305,70,30);
        l5.setFont(new Font("Segoe UI",Font.ITALIC,12));

        t4 = new TextField(20);
        t4.setBounds(160,305,180,27);
        t4.setEditable(false);
        t4.setFont(new Font("Segoe UI",Font.ITALIC,12));

        b7 = new JButton("Update");
        b7.setBounds(360,305,90,27);
        b7.setFont(new Font("Segoe UI",Font.ITALIC,12));
        b7.addActionListener(this);

        l6 = new JLabel("Country");
        l6.setBounds(50,335,70,30);
        l6.setFont(new Font("Segoe UI",Font.ITALIC,12));

        t5 = new TextField(20);
        t5.setBounds(160,335,180,27);
        t5.setFont(new Font("Segoe UI",Font.ITALIC,12));
        t5.setEditable(false);

        b8 = new JButton("Update");
        b8.setBounds(360,335,90,27);
        b8.setFont(new Font("Segoe UI",Font.ITALIC,12));
        b8.addActionListener(this);

        B1 = new JButton("Save");
        B1.setBounds(90,385,120,27);
        B1.addActionListener(this);
        B1.setFont(new Font("Segoe UI",Font.ITALIC,12));
        B1.setBackground(new Color(183,21,64));
        B1.setForeground(new Color(255,255,255));

        B2 = new JButton ("Cancel");
        B2.setBounds(240,385,120,27);
        B2.setFont(new Font("Segoe UI",Font.ITALIC,12));
        B2.addActionListener(this);
        B2.setBackground(new Color(30,55,153));
        B2.setForeground(new Color(225,225,225));

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
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);

        setLayout(null);
        setVisible(true);
        setResizable(false);
        setTitle("update");
        setSize(500,500);
        
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
            String B = rs.getString("last_name");
            String C = rs.getString("email");
            String D = rs.getString("password");
            String E = rs.getString("country");
            Blob F = rs.getBlob("image");

            t1.setText(A);
            t2.setText(B);
            t3.setText(C);
            t4.setText(D);
            t5.setText(E);

            byte[] g = F.getBytes(1, (int) F.length());
        

            if(F.length() > 0){

                File file = new File("library/Profile_pic/test_image.png");
                FileOutputStream fout = new FileOutputStream(file);
                fout.write(g);

                ImageIcon image =  new ImageIcon("library/Profile_pic/test_image.png");
                Image H = image.getImage();
                Image I = H.getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon M = new ImageIcon(I);
                l1.setIcon(M);
            
            }else{

                img =  new ImageIcon("library/user.png");
                Image G = img.getImage();
                Image J = G.getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon K = new ImageIcon(J);
                l1.setIcon(K);

            }

           
        }

    }
    catch(Exception k10){

        System.out.println(k10);

    }

}

    public static void main(String[] args) {
        
        new update();

    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == B1){

            //save button

            //update db code

            if(s == ""){

                try{

                    Class.forName("com.mysql.jdbc.Driver");

                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");

                    String query = "update project set name = ?,last_name = ?,email = ?,password = ?,country = ? "+ " where name = '"+LoginPage.set+"'";

                    stm = con.prepareStatement(query);

                    s1 = t1.getText();
                    s2 = t2.getText();
                    s3 = t3.getText();
                    s4 = t4.getText();
                    s5 = t5.getText();

                    stm.setString(1, s1);
                    stm.setString(2, s2);
                    stm.setString(3, s3);
                    stm.setString(4, s4);
                    stm.setString(5, s5);

                    stm.executeUpdate();

                }catch(Exception ex){

                    System.out.println(ex);

                }

            }else{

                try{

                    Class.forName("com.mysql.jdbc.Driver");

                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");

                    String query = "update project set name = ?,last_name = ?,email = ?,password = ?,country = ? , image = ?"+ " where name = '"+LoginPage.set+"'";

                    stm = con.prepareStatement(query);

                    s1 = t1.getText();
                    s2 = t2.getText();
                    s3 = t3.getText();
                    s4 = t4.getText();
                    s5 = t5.getText();

                    FileInputStream fin = new FileInputStream(s);

                    stm.setString(1, s1);
                    stm.setString(2, s2);
                    stm.setString(3, s3);
                    stm.setString(4, s4);
                    stm.setString(5, s5);
                    stm.setBinaryStream(6, fin, fin.available());

                    stm.executeUpdate();

                }catch(Exception ex){

                    System.out.println(ex);

                }

            }

        }

        if(e.getSource() == B2){

            //cancel button

            new profile();
            this.dispose();

        }

        if(e.getSource() == b3){

            // image change button

            JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
			fileChooser.addChoosableFileFilter(filter);
            int result = fileChooser.showSaveDialog(null);
            
            if(result == JFileChooser.APPROVE_OPTION){
				
				File selectedFile = fileChooser.getSelectedFile();
				String path = selectedFile.getAbsolutePath();
				l1.setIcon(ResizeImage(path));
				s = path;

				// t7.setText(s);
				 
			}else if(result == JFileChooser.CANCEL_OPTION){

				System.out.println("No Data");

			}

        }

        if(e.getSource() == b4){

            //update button

            t1.setEditable(true);

        }

        if(e.getSource() == b5){

            //update button

            t2.setEditable(true);

        }

        if(e.getSource() == b6){

            //update button

            t3.setEditable(true);

        }

        if(e.getSource() == b7){

            //update button

            t4.setEditable(true);

        }

        if(e.getSource() == b8){

            //update button

            t5.setEditable(true);

        }
    }

    private Icon ResizeImage(String path) {

		ImageIcon MyImage = new ImageIcon(path);
		Image img = MyImage.getImage();
		Image newImage = img.getScaledInstance(l1.getWidth(), l1.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImage);
        return image;    
    
    }
}