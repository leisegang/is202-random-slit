package is202.hrms.web;

import is202.hrms.ejb.DepartmentEJB;
import is202.hrms.entity.Department;
import is202.hrms.entity.Employee;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * The backing bean for department.xhtml. The Named annotation marks it
 * as a CDI backing bean. The ConversationScoped annotation controls
 * the lifecycle of the bean. The lifetime of a ConversationScoped bean is
 * explicitly managed in the code.
 *
 * @author even
 */
@Named("depbean")
@ConversationScoped
public class DepartmentBean implements Serializable {

    // The @Inject annotation is a request to the server to
    // give us a Conversation object, and store it in conv
    @Inject private Conversation conv;
    @EJB DepartmentEJB depEjb;
    private Department department;
    private boolean updating;

    // Department properties - These properties will be copied to a Department
    // object, when the time comes to save the data in the database.
    private long depNo;
    private String name;
    private List<Employee> employees;

    public DepartmentBean() {
    }

    /**
     * called when the user selects a department from the list in
     * departments.xhtml.
     */
    public void setDepNo(long depNo) {
        if (conv.isTransient()) {
            conv.begin();
        }

        Department dep = depEjb.find(depNo);
        if (null == dep) {
            // we will get here if depNo is not a valid, or if
            // depNo is valid but there is no department with that depno
            updating = false;
            depNo = 0;
            name = "";
            employees = new ArrayList<Employee>();
        }
        else {
            updating = true;
            this.depNo = dep.getDepNo();
            name = dep.getName();
            employees = dep.getEmployees();
        }
    }

    public long getDepNo() {
        return depNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public boolean isUpdating() {
        return updating;
    }

    private Department createDepObject() {
        // Create a department object containing the data
        // from the form. The object can be passed on to
        // depListBean
        Department dep = new Department();
        dep.setDepNo(depNo);
        dep.setName(name);
        return dep;
    }

    public View saveDepartment() {
        Department dep = createDepObject();
        if (dep.getDepNo() > 0) depEjb.update(dep);
        else depEjb.insert(dep);
        conv.end();
        return View.departments;
    }

    public View deleteDepartment() {
        Department dep = createDepObject();
        depEjb.delete(dep);
        conv.end();

        return View.departments;
    }
}
