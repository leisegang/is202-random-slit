/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.ModuleEJB;
import is202.hrms.ejb.ProgressionEJB;
import is202.hrms.entity.Modul;
import is202.hrms.entity.Progression;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;


/**
 *
 * @author Vetle
 */
@Named ("modulebean")
@SessionScoped //skal endres til SessionScoped!!
public class ModuleBean implements Serializable{
    private boolean updating; //Dette er en boolean verdi som setter modulen til å oppdatere
    @EJB private ModuleEJB moduleEjb; //Kobler til ModuleEJB fila (Enterprisebean) snakker med databasen
    @EJB private ProgressionEJB progressionEjb;


    private Modul module;
    private boolean moduleExists;
    private String errorMessage;
    private long param;
    private String deleteError;

    
    public ModuleBean() {
        //konstruktør

    }

    public long getParam() {
        if(module == null) {
            return 0;
        }
        else return module.getModuleId();
    }
    
    //Denne metoden brukes til å sende med parametere inn i modulen
    public void setParam(long moduleId) {
        param = moduleId;
        if (moduleId > 0) {
            updating = true;
            module = moduleEjb.find(moduleId);
            deleteError = null;

        }
        else {
            updating = false;
            module = new Modul(); //modulen har en Id allerede fra den entrer siden (metadataen).
        }

    }
    
    public void checkModuleName(FacesContext context, UIComponent component, Object value) {
        String input = (String)value;
        for(Modul m : moduleEjb.findAll()) {
            if(input.equals(m.getModuleName())) {
                if(m.getModuleId()==param) {
                //ikke error
                }
                else{
                errorMessage="Modulnavnet eksisterer";
                FacesMessage msg = new FacesMessage(getErrorMessage()); 
                    throw new ValidatorException(msg);
                }
                }
            }
        }
    
    public Modul getModule() {
        return module;
    }

    public void setModule(Modul module) {
        this.module = module;
    }
    
    public String save() {
        if (updating) moduleEjb.update(module); 
        else {
            for(Modul m : moduleEjb.findAll()) {
                if(module.getModuleName().equals(m.getModuleName()) ) {
                    moduleExists = true;
                }
            }
            if(!moduleExists) {
                moduleEjb.insert(module);
            }
        }
        return "modules";
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    

    public String delete() {
        if(updating) {
        for(Progression p : progressionEjb.findAll()) {
            if(module.getModuleId()==p.getModule().getModuleId()) {
                deleteError = "Modulen kan ikke slettes så lenge studenter har tilgang til den";
                return null;
            }}
        moduleEjb.delete(module);
        return "modules";
    }
        return null;
    }

    public boolean isUpdating() {
        return updating;
    }    

    public String getDeleteError() {
        return deleteError;
    }

    public void setDeleteError(String deleteError) {
        this.deleteError = deleteError;
    }

    
}

