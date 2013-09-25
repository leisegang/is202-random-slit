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
    int count = 1;
    
    
    public ModuleListBean() {
        modules = new ArrayList<Module>();
        module = new Module();
    }
    
    public String getModuleName() {
        return modules.get(0).getName();
    }
    
    public void getModule(int id) {
        Module tempModule = null;
        for(Module modul : modules) {
          if(modul.getId() == id) {
              tempModule = modul;
          }  
        }
        module = tempModule;
    }
    
    public void setId(int id) {
        Module tempModule = null;
        for(Module modul : modules) {
          if(modul.getId() == id) {
              tempModule = modul;
          }  
        }
        module = tempModule;        
    }
    
    public int getId() {
        return module.getId();
    }
    
    public View save() {
        module.setId(count);
        modules.add(module);
        module = new Module();
        count++;
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
