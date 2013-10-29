/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.ModuleEJB;
import is202.hrms.entity.Modul;
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
    private boolean updating; //hva brukes dette feltet til
    @EJB private ModuleEJB moduleEjb; //dette er jeg ikke sikker på


    private Modul module;
    private boolean moduleExists;
    private String errorMessage;
    private long param;

    
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
        if (updating) moduleEjb.update(module); //Vil kunne trenge denne
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
    

    public View delete() {
        if (updating) moduleEjb.delete(module);
        return View.modules;
    }

    public boolean isUpdating() {
        return updating;
    }    

    
}

