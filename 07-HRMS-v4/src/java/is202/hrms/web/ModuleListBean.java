/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.ModuleEJB;
import is202.hrms.entity.Module;
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
    private static final long serialVersionUID = 1L; //hva holder dette feltet på?

    @EJB ModuleEJB moduleEjb;

    public ModuleListBean() {
    }

    public List<Module> getModules() {
        List<Module> l = moduleEjb.findAll();
        return l;
    }

}
