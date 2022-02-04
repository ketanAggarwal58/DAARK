package loginPage.client;

import java.util.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.net.*;
import static java.lang.System.out;

public class server {

    Vector<String> user = new Vector<String>();
    Vector<Manageuser> clients = new Vector<Manageuser>(); 

    public void createserver() {

        try{
                
            ServerSocket server = new ServerSocket(1201,10);
            out.println("now server is running");
                
            while(true){

                Socket client = server.accept();
                Manageuser c;
                c = new Manageuser(client); 
                clients.add(c);
                            
            }
        
        }catch(Exception e){

            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        
        new server().createserver();

    }

    public void sendtoall(String user, String message){

        for(Manageuser c : clients){

            if(!c.getchatusers().equals(user)){

                c.sendMessage(user, message);
            }
        }
    }

    class Manageuser extends Thread{

        String gotuser = "";
        BufferedReader input;
        PrintWriter output;

        public Manageuser(Socket client) throws Exception{

            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            output = new PrintWriter(client.getOutputStream(),true);
            gotuser = input.readLine();
            user.add(gotuser);
            start();


        }

        public void sendMessage(String chatuser, String chatmsg){

            output.println(chatuser+" says: "+chatmsg);

        }

        public String getchatusers(){

            return gotuser;

        } 
        @Override

        public void run(){

            String line;

            try {
                
                while(true){

                    line = input.readLine();
                    
                    if(line.equals("end")){

                        clients.remove(this);
                        user.remove(gotuser);
                        break;

                    }
                    sendtoall(gotuser, line);
                }
            } catch (Exception e) {
               
                System.out.println(e.getMessage());
            }
        }
    }
}