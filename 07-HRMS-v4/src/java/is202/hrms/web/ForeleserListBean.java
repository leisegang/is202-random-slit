

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.ForeleserEJB;
import is202.hrms.entity.Foreleser;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author Vetle, Kjetil, Vlorjan
 */
@Named("foreleserlistbean")
@RequestScoped
public class ForeleserListBean implements Serializable {


    @EJB ForeleserEJB foreleserEjb;

    public ForeleserListBean() {
    }

    public List<Foreleser> getForelesers() {
        List<Foreleser> l = foreleserEjb.findAll();
        return l;
    }

}
