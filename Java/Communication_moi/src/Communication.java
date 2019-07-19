
import com.ClientCommunication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author epsi
 */
public class Communication {
    
    public static void main(String[] args)  {
        
                 
        try {
            ServerSocket ss = new ServerSocket(2000);
            System.out.println("Serveur ecoute le port 2000");
            Socket s = new Socket() ; 
            int CompteurClient  = 0 ; 
            while ( true)
            {
                CompteurClient++ ; 
                s = ss.accept(); //ecoute , c'est une méthode bloquante
                System.out.println("Il y a "+ CompteurClient + " connect(é)s");
                ClientCommunication cc = new ClientCommunication(s);
                cc.start();
                
            }
        
        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
