/**
 * Dette er Brukerklassen. Den lager brukerobjekter
 * 
 * @author Kjetil Homme 
 * @version 14.10.2013
 */
package is202.hrms.entity;

/**
 *
 * @author kjetil
 */
public class Bruker {
    
    private String fornavn;
    private String etternavn;
    private String epost;
    private String brukernavn;
    private String passord;
    private String tilgang;
    
    
public Bruker() {
        
       
    
    }

/**
 * getters og setters for alle feltene. 
 * @return 
 */
    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getTilgang() {
        return tilgang;
    }

    public void setTilgang(String tilgang) {
        this.tilgang = tilgang;
    }


    
    
    
    
    
    
}
