/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

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

/**
 *
 * @author lucien
 */
public class Communication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ServerSocket ss = new ServerSocket(2000);
            System.out.println("Serveur ecoute sur le port 2000");
            Socket s = null;
            while (true) {
                s = ss.accept();
                System.out.println("apres accept");
                ClientCommunication cc = new ClientCommunication(s);
                cc.start();
                //communication(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void communication(Socket s) throws IOException, InterruptedException {
        OutputStream os = s.getOutputStream();
        InputStream is = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        //String ligne = br.readLine();
        PrintWriter pw = new PrintWriter(os);
        pw.println("Bienvenue sur le serveur d'heure ");
        while (true) {
            pw.println(new Date());
            pw.flush();
            Thread.sleep(1000);
        }
    }

}
