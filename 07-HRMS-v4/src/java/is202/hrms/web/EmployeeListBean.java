/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.EmployeeEJB;
import is202.hrms.entity.Employee;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Backing bean for employee.xhtml
 *
 * @author even
 */
@Named("emplistbean")
@RequestScoped
public class EmployeeListBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @EJB EmployeeEJB empEJB;


    public EmployeeListBean() {
    }
    
    public List<Employee> getEmployees() {
        List<Employee> l = empEJB.findAll();
        return l;
    }
}
