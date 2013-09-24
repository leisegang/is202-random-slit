/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.entity.Module;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Vetle
 */
@Named("modulebean")
@SessionScoped
public class Modulebean implements Serializable {
    
    ArrayList<Module> modules;
    Module module;
    

    public Modulebean() {
        modules = new ArrayList<Module>();
        module = new Module();
    }
    
    public String getModuleName() {
        return modules.get(0).getName();
    }
    
    public View save() {
        modules.add(module);
        module = new Module();
        return View.module;
    }
    

    public Module getModule() {
        return module;
    }
    
    

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
    
}
