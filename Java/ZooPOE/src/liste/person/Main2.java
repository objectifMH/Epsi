/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liste.person;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author lucien
 */
public class Main2 {

    public static void main(String[] args) {
        List<String> liste = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            liste.add("tutu" + i);
        }
        liste.add("tutu0");
        System.out.println("Avant tri");
        for (String s : liste) {
            System.out.println(s);
        }

        Collections.sort(liste);

        System.out.println("Apres tri");
        for (String s : liste) {
            System.out.println(s);
        }

        List<Personne> pers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            pers.add(new Personne("epsi" + i));
        }
        pers.add(new Personne("epsi0"));
        System.out.println("Affichage Personne non trie");
        for (Personne p : pers) {
            System.out.println(p.getNom());
        }

        Collections.sort(pers);

        Collections.sort(pers,
                new Comparator<Personne>() {
            @Override
            public int compare(Personne o1, Personne o2) {
                return (o1.getNom().compareTo(o2.getNom()));
            }

        });

        System.out.println("Affichage Personne trie");
        for (Personne p : pers) {
            System.out.println(p.getNom());
        }
    }
}
