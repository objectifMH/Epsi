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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucien
 */
public class Client extends Thread{

    private BufferedReader br;

    public Client(String host, int port) {
        try {
            Socket s = new Socket(host, port);
            InputStream is = s.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run(){
        affiche();
    }
    public void affiche() {
        while (true) {
            try {
                System.out.println(br.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        //for (int i = 0; i < 1000; i++) {
            Client c = new Client("127.0.0.1", 2000);
            //if(i %100 == 0){
                c.start();
            //}
       // }
    }

}
