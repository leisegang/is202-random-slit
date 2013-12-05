/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.ModuleEJB;
import is202.hrms.entity.Modul;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Vetle
 */
@Named("modulelistbean")
@RequestScoped
public class ModuleListBean implements Serializable {
    
    @EJB
    ModuleEJB moduleEjb;
    
    public ModuleListBean() {
    }
    
    public List<Modul> getModules() {
        List<Modul> l = moduleEjb.findAll();
     
        return l;
    }
}
