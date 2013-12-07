/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.ProgressionEJB;
import is202.hrms.ejb.ProveEJB;
import is202.hrms.entity.ProgId;
import is202.hrms.entity.Progression;
import is202.hrms.entity.Prove;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Vetle
 */
@RequestScoped
@Named("provebean")
public class ProveBean implements Serializable {
@EJB private ProveEJB proveEjb;
@EJB private ProgressionEJB progressionEjb;
private String reflectionNote;
private boolean understood;
private boolean updating;
private int proveId;


    public ProveBean() {
    }
    

    public ProveEJB getProveEjb() {
        return proveEjb;
    }

    public void setProveEjb(ProveEJB proveEjb) {
        this.proveEjb = proveEjb;
    }


    public String getReflectionNote() {
        return reflectionNote;
    }

    public void setReflectionNote(String reflectionNote) {
        this.reflectionNote = reflectionNote;
    }

    public boolean isUnderstood() {
        return understood;
    }

    public void setUnderstood(boolean understood) {
        this.understood = understood;
    }
    
    
    
    public long getParam() {
        if(proveId == 0) {
            return 0;
        }
        else return proveId;
    }
    
    //Denne metoden brukes til å sende med parametere inn i modulen
    public void setParam(long moduleId) {

        if (moduleId > 0) {
       updating = true;
            
        }
        else {
            updating = false;
            
        }

    }
    
    public void setProgression(long student, long modul, Prove prove) {
        ProgId p = new ProgId(student, modul);
        Progression pro = progressionEjb.find(p);
        pro.setProve(prove);
        progressionEjb.update(pro);
    }
    
    public Prove createProve() {
        Prove prove = new Prove();
          
        prove.setReflectionNote(reflectionNote);
        prove.setUnderstood(understood);

        return prove;
    }
    
    
    public String save(long student, long modul) {
        Prove p = createProve(); 
        
        if (updating) proveEjb.update(p); 
        else {

                proveEjb.insert(p);
            
        }
        setProgression(student, modul, p);
        
        return "indexS";
    }    
    
}
