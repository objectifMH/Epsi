/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaxmlbinding;

import chienp.Chien;
import chienp.Personne;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;

/**
 *
 * @author epsi
 */
public class JavaXmlBinding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        String st = "C:\\Users\\epsi\\Desktop\\JavaXml\\milou.xml";
        String newFile = "C:\\Users\\epsi\\Desktop\\JavaXml\\Tenefix.xml";
        try {
            // TODO code application logic here

            JAXBContext jc = JAXBContext.newInstance("chienp");
            Unmarshaller u = jc.createUnmarshaller();
            Chien mimi
                    = (Chien) u.unmarshal(new FileInputStream(st));
            System.out.println("nom du chien :" + mimi.getNom());
            Personne mait = mimi.getMaitre();
            System.out.println("nom du maitre :" + mait.getNom());
            System.out.println("adresse du maitre : " + mait.getAdresse());
            System.out.println("nombre de puces = " + mimi.getPuces());
            
            
            
            
            Chien ch = new Chien();
            ch.setNom("Tenefix");
            ch.setPuces(0);

            Personne MaitreP  = new Personne();
            MaitreP.setAdresse("Bordeaux");
            MaitreP.setNom("Tintin");
            
             ch.setMaitre(MaitreP);

            Marshaller msh;
            msh = jc.createMarshaller();
            msh.marshal(ch, new FileOutputStream(newFile));
            
            
        } catch (JAXBException ex) {
            Logger.getLogger(JavaXmlBinding.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
        

    }

}
