/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastatic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucien
 */
public class Chat {

    /**
     * @return the chef
     */
    public  Chat getChef() {
        return chef;
    }

    /**
     * @param chef the chef to set
     */
    public  void setChef(Chat c) {
        chef = c;
    }
    public static Chat chef;
    
    
    private static Chat lePlusIntelligentParQI(List<Chat> chats) {
        int cuit =(int) (Math.random()*chats.size());
        System.out.println(cuit);
        return chats.get(cuit);
    }


    private String nom;
    
    public Chat(String s){
        this.nom = s;
        
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
    
    
    
    public static void main(String[] args) {
        
        List<Chat> chats = new ArrayList<>();
        
        for(int i = 0; i < 10; i++){
            chats.add(new Chat("Chat"+i));
        }
        
        Chat chef = lePlusIntelligentParQI(chats);
        
     //   for(Chat c : chats){
     //       c.setChef(chef);
     //   }
        Chat.chef = chef;
        
        System.out.println(chef.getNom());
        System.out.println(Chat.chef.getNom());
        chats.get(0).getChef().getNom();
        
    }
}
