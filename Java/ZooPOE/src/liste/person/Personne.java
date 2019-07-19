/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liste.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lucien
 */
public class Personne implements Comparable<Personne>{
    private String nom;
    private Date dn;
    private List<Adresse> adresses = new ArrayList<>();

    public Personne(String nom, Date dn, List<Adresse> adresses) {
        
        this.nom = nom;
        this.dn = dn;
        this.adresses = adresses;
    }

    public Personne(String nom, Date dn) {
        this.nom = nom;
        this.dn = dn;
    }
    
    public Personne(String nom) {
        
        this.nom = nom;
    }
    
    public Personne(){
        
    }

    public void ajouterAdresse(Adresse a){
        adresses.add(a);
    }
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the dn
     */
    public Date getDn() {
        return dn;
    }

    /**
     * @param dn the dn to set
     */
    public void setDn(Date dn) {
        this.dn = dn;
    }

    /**
     * @return the adresses
     */
    public List<Adresse> getAdresses() {
        return adresses;
    }

    /**
     * @param adresses the adresses to set
     */
    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }

    @Override
    public int compareTo(Personne o) {
        return nom.compareTo(o.getNom());
    }
    

}
