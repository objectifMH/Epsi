
import com.ClientCommunication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    public static int compteur = 0;

    public static int nombreClient = 0;

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(2000);
            System.out.println("Serveur > Welcome Tchat serveur ");
            Socket s = new Socket();

            while (true) {

                s = ss.accept(); //ecoute , c'est une méthode bloquante
                nombreClient++;
                System.out.println("Serveur > Il y a " + nombreClient + " connect(é)s");

                ClientCommunication cc = new ClientCommunication(s);
                ClientCommunication.listClientCommunication.add(cc);
                ClientCommunication.envoyerNbreParticipants();
                
                // On transforme notre int taille de la liste en un string 
                String taille = String.valueOf(ClientCommunication.listClientCommunication.size());
                // On ecrit dans notre fichier log la taille de notre liste 
                ClientCommunication.ecrireLog("Il y a "+taille+" client(s) connecté(s)" );
                
                System.out.println("Serveur > liste Cc : " + ClientCommunication.listClientCommunication);
                cc.setIdentifiant(compteur);
                compteur++;
                cc.start();

            }

        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
