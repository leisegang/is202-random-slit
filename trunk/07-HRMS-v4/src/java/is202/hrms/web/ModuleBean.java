/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.ModuleEJB;
import is202.hrms.entity.Module;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vetle
 */
@Named ("modulebean")
@ConversationScoped //finn ut hva denne typen Scope gjør
public class ModuleBean implements Serializable{
    private boolean updating; //hva brukes dette feltet til
    @EJB private ModuleEJB moduleEjb; //dette er jeg ikke sikker på
    @Inject private Conversation conv; //dette er jeg ikke sikker på
    
    //Module felter
    private String moduleName;
    private String description;
    private String criteria;
    private int numberOfStudents;
    private String difficulty;
    @Temporal(TemporalType.DATE)
    private Date timeLimit;
    
    public ModuleBean() {
        //konstruktør
    }
    
    //Brukes ikke
    public String getParam() {
        return null;
    }
    
    //Denne metoden brukes til å sende med parametere inn i modulen
    public void setParam(String moduleName) {
        if (conv.isTransient()) {
            conv.begin();
        }

        Module m = moduleEjb.find(moduleName);
        if (null != m) {
            updating = true;
            this.moduleName = m.getModuleName();
            this.description = m.getDescription();
            this.criteria = m.getCriteria();
            this.numberOfStudents = m.getNumberOfStudents();
            this.difficulty = m.getDifficulty();
            this.timeLimit = m.getTimeLimit();
            
        }
        else {
            updating = false;
        }

    }
    
    public View save() {
        conv.end();
        Module m = new Module(moduleName, description, criteria, numberOfStudents, difficulty, timeLimit);
        if (updating) moduleEjb.update(m);
        else moduleEjb.insert(m);
        return View.modules;
    }

    public View delete() {
        conv.end();
        Module m = new Module(moduleName, description, criteria, numberOfStudents, difficulty, timeLimit);
        if (updating) moduleEjb.delete(m);
        return View.modules;
    }

    public boolean isUpdating() {
        return updating;
    }    

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Date getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Date timeLimit) {
        this.timeLimit = timeLimit;
    }
    
    
    
}

