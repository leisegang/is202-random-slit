/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.ejb;

import is202.hrms.entity.Progression;
import is202.hrms.entity.Student;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vlorjan
 */
@Stateless
public class StudentEJB extends AbstractFacade<Student> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentEJB() {
        super(Student.class);
    }

    @Override
    public Student insert(Student prog) {

        prog.addProgression(null);
        prog = super.insert(prog);
        return prog;

    }

    public Student find(long depNo) {
        Student dep = super.find(depNo);
        if (null != dep) {
            
            dep.getProgression();
            
        }
        return dep;
    }
}
