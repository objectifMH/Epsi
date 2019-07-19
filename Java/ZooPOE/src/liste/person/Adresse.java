/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liste.person;

import java.util.Objects;

/**
 *
 * @author lucien
 */
public class Adresse {
    private String num;
    private String ad1;
    private String cp;
    private String ville;

    public Adresse(String num, String ad1, String cp, String ville) {
        this.num = num;
        this.ad1 = ad1;
        this.cp = cp;
        this.ville = ville;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getAd1() {
        return ad1;
    }

    public void setAd1(String ad1) {
        this.ad1 = ad1;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
  /*  @Override
    public String toString(){
        
        return num+ " "+ad1+" "+cp+" "+ville;
    }
*/

    @Override
    public String toString() {
        return "Adresse{" + "num=" + num + ", ad1=" + ad1 + ", cp=" + cp + ", ville=" + ville + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.num);
        hash = 29 * hash + Objects.hashCode(this.ad1);
        hash = 29 * hash + Objects.hashCode(this.cp);
        hash = 29 * hash + Objects.hashCode(this.ville);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Adresse other = (Adresse) obj;
        if (!Objects.equals(this.num, other.num)) {
            return false;
        }
        if (!Objects.equals(this.ad1, other.ad1)) {
            return false;
        }
        if (!Objects.equals(this.cp, other.cp)) {
            return false;
        }
        if (!Objects.equals(this.ville, other.ville)) {
            return false;
        }
        return true;
    }
    
    
}
