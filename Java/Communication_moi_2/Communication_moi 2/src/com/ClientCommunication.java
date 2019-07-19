/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.Math.log;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author epsi
 */
public class ClientCommunication extends Thread {

    private String nomClient;

    private int identifiant;

    private Socket s = null;

    private Boolean isMe = false;

    private InputStream is;
    private BufferedReader br;
    private PrintWriter pw;
    private OutputStream os;

    public static List<ClientCommunication> listClientCommunication = new ArrayList<ClientCommunication>();

    public ClientCommunication(Socket soc) {
        try {
            s = soc;
            //J'ecris
            os = s.getOutputStream();

            //Je lis 
            is = s.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            pw = new PrintWriter(os);
        } catch (IOException ex) {
            Logger.getLogger(ClientCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        OutputStream os = null;
        try {
            //J'ecris
            os = s.getOutputStream();

            //Je lis 
            is = s.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            pw = new PrintWriter(os);

            pw.println("Cc > Votre identifiant sur ce chat est " + this.getIdentifiant());
            pw.println("Cc > Quel est votre nom ? ");
            pw.flush();  // permet d'envoyer le flux 

            String ligne;

            while (true && !s.isClosed()) {

                ligne = ( br.readLine() ); // != null ) ? br.readLine() : "Deconnexion" ; 
                decoupeProtocol(ligne);
                System.out.println("Cc > [" + ligne + ";] ");
                ecrireLog("Date : " + new Date() + " / Id : " + getIdentifiant() + " / Nom :  " + getNomClient() + " / Content : " + ligne);

            }

        } catch (IOException ex) {
            Logger.getLogger(ClientCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public List<ClientCommunication> getListClientCommunication() {
        return listClientCommunication;
    }

    public void setListClientCommunication(List<ClientCommunication> listClientCommunication) {
        this.listClientCommunication = listClientCommunication;
    }

    public void sendMessageToAll(String st) {

        for (ClientCommunication cc : listClientCommunication) {

            try {
                PrintWriter pw = new PrintWriter(cc.getS().getOutputStream());
                {
                    pw.println(this.nomClient + " > " + st);
                    pw.flush();
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void sendMessageToClientById(int i, String st) {
        for (ClientCommunication cc : listClientCommunication) {

            try {
                PrintWriter pw = new PrintWriter(cc.getS().getOutputStream());
                //System.out.println("Cc > [All: " + st + "]");
                if (i == cc.getIdentifiant()) {
                    pw.println(nomClient + ">" + st);
                    pw.flush();
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void affiche() {
        System.out.println("Identifiant : " + identifiant + " Nom : " + nomClient);
    }

    public void decoupeProtocol(String st) {

        String[] mots = st.split(";");
        String message = "";
        // On récupère le message Si il existe 

        try {
            if (!mots[1].isEmpty()) {
                message = mots[1];
            }
        } catch (Exception e) {
            System.out.println(" Pas d'élements 1 ");
        }

        if (mots[0].equals("All") || mots[0].equals("A>")) {

            this.sendMessageToAll(message);
        } else if (mots[0].equals("To")) {

            int i = Integer.parseInt(mots[2]);
            this.sendMessageToClientById(i, mots[1]);

        } else if (mots[0].equals("Pseudo") || mots[0].equals("P")) {
            this.setNomClient(mots[1]);
            ecrire("Votre pseudo est " + message, true);

        } else if (mots[0].equals("Quit") || mots[0].equals("Q")) {
            try {
                listClientCommunication.remove(this);
                sendMessageToAll(this.nomClient + " se deconnecte");
                envoyerNbreParticipants();

                // On ecrit dans le fichier log que le client se deconnecte 
                ClientCommunication.ecrireLog(this.nomClient + " se deconnecte");

                // On transforme notre int taille de la liste en un string 
                String taille = String.valueOf(ClientCommunication.listClientCommunication.size());
                // On ecrit dans notre fichier log la taille de notre liste 
                ClientCommunication.ecrireLog("Il y a " + taille + " client(s) connecté(s)");

                s.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientCommunication.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (mots[0].equals("List") || mots[0].equals("L")) {
            envoyerList();
        }

    }

    public void ecrire(String message, boolean boo) {
        if (boo == true) {
            pw.println(">  " + new Date());
        }
        System.out.println("Cc ecrire >  " + new Date());

        pw.println(message);
        pw.flush();
    }

    public void AfficheListe() {
        for (ClientCommunication cc : listClientCommunication) {
            cc.affiche();
        }
    }

    public int rechercherByNom(String nom) {
        for (ClientCommunication cc : listClientCommunication) {
            if (cc.getNomClient().equals(nom)) {
                return cc.getIdentifiant();
            }
        }
        return -404;
    }

    public String rechercherById(int ide) {
        for (ClientCommunication cc : listClientCommunication) {
            if (cc.getIdentifiant() == ide) {
                return cc.getNomClient();
            }
        }
        return "";
    }

    public ClientCommunication rechercherClienTCommById(int ide) {
        ClientCommunication ccAux = null;
        for (ClientCommunication cc : listClientCommunication) {
            if (cc.getIdentifiant() == ide) {
                return cc;
            }
        }
        return ccAux;
    }

    public static void envoyerNbreParticipants() {
        for (ClientCommunication cc : listClientCommunication) {

            try {
                PrintWriter pw = new PrintWriter(cc.getS().getOutputStream());
                pw.println("[Serveur] Vous etes maintenant " + listClientCommunication.size() + " membres connecté(es)");
                pw.flush();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void envoyerList() {
        for (ClientCommunication cc : listClientCommunication) {

            ecrire(cc.getIdentifiant() + "  : " + cc.getNomClient(), false);
        }
    }

    public static void ecrireLog(String message) throws IOException {

        File file = new File("log.txt");

        // créer le fichier s'il n'existe pas
        if (!file.exists()) {
            file.createNewFile();
        }
        message = message + "\r\n";
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(message);
        bw.close();

    }

}
