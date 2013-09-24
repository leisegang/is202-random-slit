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
@Named("modulelistbean")
@SessionScoped
public class ModuleListBean implements Serializable {
    
    ArrayList<Module> modules;
    Module module;
    
    
    public ModuleListBean() {
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

    public void setModule(Module module) {
        this.module = module;
    }
        
    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
    
}
