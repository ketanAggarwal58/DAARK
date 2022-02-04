package project;

import java.util.*;

class loginForm2{

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        String a,b, user = "ketan" , pass = "aggarwal";

        System.out.println("login form");

        System.out.println("please enter your username");
        a = scan.nextLine();
        
        System.out.println("please enter your password");
        b = scan.nextLine();

        if(a.equals(user)){
        
            if(b.equals(pass)){

            System.out.println("YAY! you loged in");

            }else{

                System.out.println("please check your password");
                
            }

        } else{

            System.out.println("please check your username");
        }

        scan.close();

    }
}