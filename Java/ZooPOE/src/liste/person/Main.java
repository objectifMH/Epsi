/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liste.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author lucien
 */
public class Main {

    public static void main(String[] args) {
        Adresse a = new Adresse("102", "rue du Pilat", "34580", "CARNON");
        Adresse a1 = new Adresse("1", "rue du Pilat", "34580", "CARNON");
        Adresse a2 = new Adresse("10", "rue du Pilat", "34680", "MONTPELLIER");
        Adresse a3 = new Adresse("1002", "rue du Pilat", "34880", "NIMES");
        Adresse a4 = new Adresse("402", "rue du Pilat", "34580", "CARNON");
        Adresse a5 = new Adresse("502", "rue du Pilat", "34380", "BEZIERS");
        Adresse a6 = new Adresse("1802", "rue du Pilat", "34580", "CARNON");
        Adresse a7 = new Adresse("1092", "rue du Pilat", "34580", "CARNON");
        Adresse a8 = new Adresse("1062", "rue du Pilat", "34580", "CARNON");
        Personne p = new Personne("TOTO", new Date());
        Personne p1 = new Personne("TATA", new Date());
        Personne p2 = new Personne("TITI", new Date());
        p.ajouterAdresse(a);
        p.ajouterAdresse(a1);
        p.ajouterAdresse(a2);
        
        p1.ajouterAdresse(a3);
        p1.ajouterAdresse(a4);
        p1.ajouterAdresse(a6);
        p1.ajouterAdresse(a7);
        p1.ajouterAdresse(a8);
        
        p2.ajouterAdresse(a5);
        //?  Comment rechercher les personnes qui ont une résidence à CARNON
        List<Personne> carnonsiens = new ArrayList<>();
        ajoutePersonneSiCarnonsien(p1, carnonsiens);
        ajoutePersonneSiCarnonsien(p2, carnonsiens);
        ajoutePersonneSiCarnonsien(p, carnonsiens);
        
        for(Personne pc : carnonsiens){
            System.out.println("carnonsien : "+pc.getNom());
        }
    }



    private static void ajoutePersonneSiCarnonsien(Personne p1, List<Personne> carnonsiens) {
        List<Adresse> adP1 = p1.getAdresses();
        Iterator<Adresse> it = adP1.iterator();
        boolean pasTrouve = true;
        while(it.hasNext() && pasTrouve){
            Adresse a = it.next();
            if(a.getVille().equals("CARNON")){
                pasTrouve=false;
                carnonsiens.add(p1);
            }
        }
        
     /*   
        for(Adresse ad : adP1){
            System.out.println(ad.toString());
            if(ad.getVille().equals("CARNON")){
                carnonsiens.add(p1);
            }
        }
*/
    }
}
