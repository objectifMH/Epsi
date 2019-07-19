
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
    private PrintWriter pr; 
    private Socket s ; 
    
    public Client(String host, int port) {
        try {
            s = new Socket(host, port);
            InputStream is  = s.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            
            String st = br.readLine();
            System.out.println(" Serveur : "+st);
            
            //new 
            /*
            pr = new PrintWriter(s.getOutputStream());
            pr.println(st);
            pr.flush();
           	*/
            
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    
    @Override
    public void run(){  
    	String st = null;
		try {
			st = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	while(true)
    	{
    		try {
				pr = new PrintWriter(s.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            pr.println(st);
            pr.flush();
    	}
      
    }
    
    public static void main(String[] args) throws InterruptedException {
        Client c = new Client( "127.0.0.1" , 2000);
        c.start();
    }
}
