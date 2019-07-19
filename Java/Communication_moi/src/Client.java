
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
public class Client extends Thread {

    private BufferedReader br ; 
    
    public Client(String host, int port) {
        try {
            Socket s = new Socket(host, port);
            InputStream is  = s.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    public void affiche() throws InterruptedException{
        while(true)
        {
            try {
                System.out.println(br.readLine());
                System.out.println(new Date());
                Thread.sleep(1000);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    @Override
    public void run(){    
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        Client c = new Client( "127.0.0.1" , 2000);
        c.affiche();
    }
}
