/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.ejb;

import is202.hrms.entity.Module;
import is202.hrms.entity.Progression;
import is202.hrms.entity.Student;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vetle
 */
@Stateless
public class ProgressionEJB extends AbstractFacade<Progression> {
    
    @PersistenceContext
    private EntityManager em;
    @EJB
    private ModuleEJB module;
    @EJB
    private StudentEJB student;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public ProgressionEJB() {
        super(Progression.class);
    }
    
    @Override
    public Progression insert(Progression prog) {
        
        Module modul = module.find(prog.getModule().getModuleId());
        Student stud = student.find(prog.getStudent().getStudentID());
        prog = super.insert(prog);
        modul.addProgression(prog);
        prog.setModule(modul);
        
        stud.addProgression(prog);
        prog.setStudent(stud);
        return prog;
        
    }
}