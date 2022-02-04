package project;

import java.util.*;

class login {

    String a, b;

    Scanner scan = new Scanner(System.in);

    void l1() {

        System.out.println("login form");

        System.out.println("please enter your username");
        a = scan.nextLine();

        System.out.println("please enter your password");
        b = scan.nextLine();


        scan.close();

    }
}

class login2 extends login {
   
    void l2() {
        System.out.println(a);
        System.out.println(b);

        final String username = "ketan", password = "hr05m1252";

        if(a.equals(username) && b.equals(password)){

            System.out.println("yay! you loged in..");

        }else {

            System.out.println("please check your username and password");

        }
    }
}

class loginForm {

    public static void main(final String[] args) {

        final login2 l3 = new login2();

        l3.l1();
        l3.l2();

    }
}