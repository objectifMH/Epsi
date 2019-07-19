/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo.montpellier;

/**
 * cagorise les animaux de la hierarchie Animal
 * en carnassier
 * @author lucien
 */
public class Carnivore extends Animal{

    /**
     * nous donne l'information sur la console 
     * de ce que mange l'animal
     */
    @Override
    public void manger() {
        System.out.println("Je mange de la viande ");
    }
    
}
