/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.OfficeEJB;
import is202.hrms.entity.Office;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author even
 */
@Named("officelistbean")
@RequestScoped
public class OfficeListBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB OfficeEJB officeEjb;

    public OfficeListBean() {
    }

    public List<Office> getOffices() {
        List<Office> l = officeEjb.findAll();
        return l;
    }

}
