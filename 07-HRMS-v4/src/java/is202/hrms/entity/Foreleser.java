/*
 * Klassen Foreleser arver fra klassen Bruker. 
 * 
 */
package is202.hrms.entity;

/**
 *
 * @author kjetil
 */
public class Foreleser extends Bruker {
    
    private String ansattNR;
    
    
public Foreleser() {
    
}

    public String getAnsattNR() {
        return ansattNR;
    }

    public void setAnsattNR(String ansattNR) {
        this.ansattNR = ansattNR;
    }


}
