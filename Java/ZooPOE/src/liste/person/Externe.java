/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liste.person;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author lucien
 */
public class Externe {
    
    private Date dn;
    public Externe(){
        dn = new Date();
        Calendar c = Calendar.getInstance(Locale.FRANCE);
        //c.getTime();
        c.set(2000, 10, 1);
        dn = c.getTime();
        
    }
    
    public class Interne implements Comparable<Object>{
        public Interne(){
            
        }

        @Override
        public int compareTo(Object o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}

 class Autre{
    
}
