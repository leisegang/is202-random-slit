/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.ModuleEJB;
import is202.hrms.entity.Module;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;


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
    


    private Module module;
    private boolean moduleExists;
    private String errorMessage;

    
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
        if (conv.isTransient()) {
            conv.begin();
        }

        if (moduleId > 0) {
            updating = true;
            module = moduleEjb.find(moduleId);
            
        }
        else {
            updating = false;
            module = new Module(); //modulen har en Id allerede fra den entrer siden (metadataen).
        }

    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
    
    public String save() {
        conv.end();
        if (updating) moduleEjb.update(module);
        else {
            for(Module m : moduleEjb.findAll()) {
                if(module.getModuleName().equals(m.getModuleName()) ) {
                    moduleExists = true;
                }
            }
            if(!moduleExists) {
                moduleEjb.insert(module);
            }
            else{
                errorMessage="modulen eksisterer";
                return "module?moduleName=0";
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
        conv.end();
        if (updating) moduleEjb.delete(module);
        return View.modules;
    }

    public boolean isUpdating() {
        return updating;
    }    

    
}

