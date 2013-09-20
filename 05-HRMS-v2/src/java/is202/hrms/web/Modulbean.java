/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Vetle
 */
@Named("modulbean")
@SessionScoped
public class Modulbean implements Serializable {
    
    private String modulnavn;
    private String beskrivelse;
    private String kriterier;
    private String ressurser;
    

    public Modulbean() {
    }

    public String getModulnavn() {
        return modulnavn;
    }

    public void setModulnavn(String modulnavn) {
        this.modulnavn = modulnavn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getKriterier() {
        return kriterier;
    }

    public void setKriterier(String kriterier) {
        this.kriterier = kriterier;
    }

    public String getRessurser() {
        return ressurser;
    }

    public void setRessurser(String ressurser) {
        this.ressurser = ressurser;
    }
    
}
