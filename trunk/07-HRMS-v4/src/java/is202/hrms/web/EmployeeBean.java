/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.DepartmentEJB;
import is202.hrms.ejb.EmployeeEJB;
import is202.hrms.entity.Department;
import is202.hrms.entity.Employee;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Backing bean for employee.xhtml
 *
 * @author even
 */
@Named("empbean")
@ConversationScoped
public class EmployeeBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB private EmployeeEJB empEjb;
    @EJB private DepartmentEJB depEjb;
    @Inject private Conversation conv;

    private boolean updating;

    // employee properties
    private long empId;
    private String name;
    private int salary;
    private Department dep;

    public EmployeeBean() {
    }

    public void setEmpId(long empId) {
        if (conv.isTransient()) {
            conv.begin();
        }

        Employee emp = empEjb.find(empId);
        if (null == emp) {
            // illegal or unused empId - create a new one
            updating = false;
            this.empId = 0;
            this.name = null;
            this.salary = 0;
            this.dep = depEjb.getDefaultDepartment();
        }
        else {
            this.empId = emp.getId();
            this.name = emp.getName();
            this.salary = emp.getSalary();
            this.dep = emp.getDepartment();
            updating = true;
        }
    }

    public long getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return dep;
    }

    public void setDepartment(Department dep) {
        this.dep = dep;
    }

    public boolean isUpdating() {
        return updating;
    }

    private Employee createEmployeeObject() {
        Employee emp = new Employee();
        emp.setId(empId);
        emp.setName(name);
        emp.setSalary(salary);
        emp.setDepartment(dep);
        return emp;
    }

    public View saveEmployee() {
        Employee emp = createEmployeeObject();
        if (updating) empEjb.update(emp);
        else empEjb.insert(emp);
        conv.end();
        return View.employees;
    }

    public View deleteEmployee() {
        Employee emp = createEmployeeObject();
        empEjb.delete(emp);
        return View.employees;
    }

    public View cancel() {
        conv.end();
        return View.employees;
    }
}
