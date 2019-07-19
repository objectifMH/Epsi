/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author epsi
 */
public class ClientCommunication extends Thread{
    
    private Socket s = null ; 
    public ClientCommunication(Socket soc){
        s = soc ;
    }

    @Override
   public void run() {
       OutputStream os = null ; 
       try {
           os = s.getOutputStream();
           InputStream is = s.getInputStream();
           BufferedReader br = new BufferedReader ( new InputStreamReader(is));
           PrintWriter pw = new PrintWriter(os);
                    
            pw.println("Super serveur");
            pw.println("Quel est votre nom ? ");
            pw.flush();                                 // permet d'envoyer le flux 
            
            String ligne = br.readLine();               //bloquant 
            int compteur = 0;            
            while (true) {
                if (compteur == 0) {
                    pw.println("Bienvenue sur mon serveur " + ligne);
                }
                compteur++;
                pw.println(new Date());
                pw.flush();                             // vide le buffer , et envoie 
                Thread.sleep(1000);
            }
           
           
       } catch (IOException ex) {
            Logger.getLogger(ClientCommunication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ClientCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   } 
    
}
