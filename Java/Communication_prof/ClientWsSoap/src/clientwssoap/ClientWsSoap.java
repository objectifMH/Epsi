/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientwssoap;

import fr.epsi.mtp.poe.ws.Exception_Exception;

/**
 *
 * @author epsi
 */
public class ClientWsSoap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception_Exception {
        // TODO code application logic here
        System.out.println("Multiplication 89  x 3 = "+multiplication(89, 3));
        
        System.out.println("Addition 89  + 3 = "+addition(89, 3));
        
        System.out.println("Soustraction 89 - 3 = "+soustraction(89, 3));
        
        System.out.println("Division 89  / 3 = "+division(89, 3));
        
        
    }

    private static double multiplication(double a, double b) {
        fr.epsi.mtp.poe.ws.Calculatrice_Service service = new fr.epsi.mtp.poe.ws.Calculatrice_Service();
        fr.epsi.mtp.poe.ws.Calculatrice port = service.getCalculatricePort();
        return port.multiplication(a, b);
    }

    private static double division(double a, double b) throws Exception_Exception {
        fr.epsi.mtp.poe.ws.Calculatrice_Service service = new fr.epsi.mtp.poe.ws.Calculatrice_Service();
        fr.epsi.mtp.poe.ws.Calculatrice port = service.getCalculatricePort();
        return port.division(a, b);
    }

    private static double soustraction(double a, double b) {
        fr.epsi.mtp.poe.ws.Calculatrice_Service service = new fr.epsi.mtp.poe.ws.Calculatrice_Service();
        fr.epsi.mtp.poe.ws.Calculatrice port = service.getCalculatricePort();
        return port.soustraction(a, b);
    }

    private static String addition(double a, double b) {
        fr.epsi.mtp.poe.ws.Calculatrice_Service service = new fr.epsi.mtp.poe.ws.Calculatrice_Service();
        fr.epsi.mtp.poe.ws.Calculatrice port = service.getCalculatricePort();
        return port.addition(a, b);
    }
    
    
    
}
