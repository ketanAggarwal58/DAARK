package project.sql;

import java.util.*;
import java.sql.*;

class main2{

    public static void main(String[] args) {
        
       dbconnections k = new dbconnections();
       k.setData();
    
    }

}

class dbconnections {

    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    String a,b,c;

    dbconnections(){

        try {
    
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            // st = con.prepareStatement();

        } catch (Exception e) {
            
            System.out.println("error: "+e);

        }

    }

    public void setData(){

        Scanner scan = new Scanner(System.in);

        System.out.println("please enter your name: ");
        a = scan.nextLine();

        System.out.println("please enter your lastname: ");
        b = scan.nextLine();

        System.out.println("please enter your age");
        c = scan.nextLine();

        try{
        
            String update = "INSERT INTO person" + "VALUES (?,''+a,''+b,''+c)";
            // rs = st.executeUpdate(update);

        }catch(Exception e){

            System.out.println("error: "+e);

        }
        
        scan.close();
        
    }
}