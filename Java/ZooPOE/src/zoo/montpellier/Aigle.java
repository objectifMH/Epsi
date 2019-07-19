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
public class Aigle extends Carnivore {

    private String region;

    /**
     *
     */
    public Aigle() {
        //super();
    }

    /**
     *
     * @param r
     */
    public Aigle(String r) {
        //this();
        this.region = r;
    }

    @Override
    public void manger() {
        super.manger();
        System.out.println("plus exactement de la charogne !!!");
    }

    /**
     *
     * @param a
     */
    public void manger(String a) {
        
    }

    /**
     *
     */
    public void voler() {
        System.out.println("Je vole !!!");
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }
}
