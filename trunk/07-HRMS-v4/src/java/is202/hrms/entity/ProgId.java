/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.entity; 

import java.io.Serializable; // Biblioteker 

/**
 *
 * @author Vetle
 */
public class ProgId implements Serializable { /** en klasse som heter ProgID */ 
    private long student; /* en variabel i klassen ProgID som heter student. "Long" betyr at den kan inneholde mange tall */
    private long modul;  /* en variabel i klassen ProgID som heter modul */
    
    public ProgId() {  
    
      /* Her har vi konstruktoren til ProgID.   
       * Konstruktorer har en spesiell rolle,
       * De skal sørge for at objektene er i stand til å bli brukt når de blir opprettet */
        
    }
    public ProgId(long student, long modul) {
        this.student = student;
        this.modul = modul;
    }    

    public long getStudent() { 
        return student;
    }

    public long getModule() {
        return modul;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.student ^ (this.student >>> 32));
        hash = 89 * hash + (int) (this.modul ^ (this.modul >>> 32));
        return hash;
        
        /* Denne koden sjekker at IDene ikke er like. F.eks at 2 studenter ikke har samme ID.*/
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProgId other = (ProgId) obj;
        if (this.student != other.student) {
            return false;
        }
        if (this.modul != other.modul) {
            return false;
        }
        return true;
    }
    
}
