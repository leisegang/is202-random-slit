/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.DepartmentEJB;
import is202.hrms.entity.Department;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author evenal
 */
@Named("deplistbean")
@RequestScoped
public class DepartmentListBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB DepartmentEJB depEjb;

    public DepartmentListBean() {
    }

    public List<Department> getDepartments() {
        List<Department> l = depEjb.findAll();
        return l;
    }
}
