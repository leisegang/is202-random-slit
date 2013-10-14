/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.ejb;

import is202.hrms.entity.Department;
import is202.hrms.entity.Employee;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Persistence handler for emmployees.
 * See comments in DepartmentEJB
 * @author evenal
 */
@Stateless
public class EmployeeEJB extends AbstractFacade<Employee> {
    @PersistenceContext(unitName = "slitdb")
    private EntityManager em;

    @EJB
    private DepartmentEJB depEJb;

    public EmployeeEJB() {
        super(Employee.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /** Employee has a relation to Department, so it is necessary to
     * overeride insert and update, to make sure they maintain the
     * relations */
    @Override
    public Employee insert(Employee newEmp) {
        Department dep = depEJb.find(newEmp.getDepartment().getDepNo());
        newEmp = super.insert(newEmp);
        dep.getEmployees().add(newEmp);
        newEmp.setDepartment(dep);
        return newEmp;
    }

    /** Update is a bit more complex, because the old and new departments
     * must both be updated. In addition we need to get managed objects
     * to ensure that everything propagates to the database */
    @Override
    public Employee update(Employee editedEmp) {
        Employee dbEmp = find(editedEmp.getId());
        if (null == dbEmp) insert(editedEmp);

        long newDepNo = editedEmp.getDepartment().getDepNo();
        Department newDep = depEJb.find(newDepNo);
        Department oldDep = dbEmp.getDepartment();
        editedEmp = super.update(editedEmp);

        editedEmp.setDepartment(newDep);
        if (!newDep.equals(oldDep)) {
            oldDep.getEmployees().remove(editedEmp);
            newDep.getEmployees().add(editedEmp);
            editedEmp.setDepartment(newDep);
        }
        return editedEmp;
    }

    @Override
    public void delete(Employee emp) {
        emp = em.merge(emp);
        Department dep = emp.getDepartment();
        dep.getEmployees().remove(emp);
        super.delete(emp);
    }
}
