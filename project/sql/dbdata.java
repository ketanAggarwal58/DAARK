package project.sql;

import java.sql.*;
import java.util.*;

class dbdata{

    public static void main(String[] args) {
        
        dbconnection f = new dbconnection();
        
    }

}

class dbconnection{

    private Connection con;
    private Statement st;
    private ResultSet rs;

    dbconnection(){
        
      try{

        Class.forName("com.mysql.jdbc.Driver");

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        st = con.createStatement();

      } catch(Exception ex){

        System.out.println("Error: "+ex);

      }

    }

    public void getData() {

        try{

            String query = "select * from person";

            rs = st.executeQuery(query);
            System.out.println("records from database");

            while(rs.next()){

                String name = rs.getString("name");
                String lastname = rs.getString("last name");
                String age = rs.getString("age");

                System.out.println("name: "+name+" "+"lastname: "+lastname+" "+"age: "+age);
                
            }

        }catch(Exception ex){

            System.out.println(ex);
        }

    }

}