/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo.montpellier;

/**
 *
 * @author lucien
 */
public class Herbivore extends Animal{

    /**
     * nous donne l'information sur la console 
     * de ce que mange l'animal
     */
    @Override
    public void manger() {
        System.out.println("Je mange de l'herbe ");
    }
    
}
