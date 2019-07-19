/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoopoe;

import java.util.Collection;
import zoo.montpellier.*;

/**
 *
 * @author lucien
 */
public class ZooPOE {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lion monLion = new Lion();
        monLion.manger();
        Aigle monaigle = new Aigle();
        monaigle.setRegion("Cocase");
        monaigle.manger();

        System.out.println("*********************************************");

        Carnivore monSecondAigle = new Aigle();
        ((Aigle )monSecondAigle).setRegion("Mercantour");
        Carnivore monAigleNonConforme = new Carnivore();

        monSecondAigle.manger();

        

        monaigle.voler();
        ((Aigle)monSecondAigle).voler();
        
        
        
        Animal[] mesAnimals = new Animal[5];

        mesAnimals[0] = new Lion();
        mesAnimals[1] = new Girafe();
        mesAnimals[2] = new Chien();
        mesAnimals[3] = new Aigle();
        mesAnimals[4] = new Vache();
        
        for(int i = 0; i< mesAnimals.length; i++){
            mesAnimals[i].manger();
        }
        
        Collection c;
    }

}
