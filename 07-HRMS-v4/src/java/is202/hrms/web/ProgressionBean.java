/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.ModuleEJB;
import is202.hrms.ejb.ProgressionEJB;
import is202.hrms.ejb.StudentEJB;
import is202.hrms.entity.Modul;
import is202.hrms.entity.ProgId;
import is202.hrms.entity.Progression;
import is202.hrms.entity.Student;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Vetle
 */
@Named("progressionbean")
@RequestScoped
public class ProgressionBean implements Serializable {

    @EJB
    private ProgressionEJB progressionEjb;
    @EJB
    private StudentEJB studEjb;
    @EJB
    private ModuleEJB modEjb;
    private int godkjent;
    private long studentID;
    private Progression prog;

    public ProgressionBean() {
    }

    public int getGodkjent() {
        return godkjent;
    }

    public void setGodkjent(int godkjent) {
        this.godkjent = godkjent;
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public Progression getProg() {
        return prog;
    }

    public void setProg(Progression prog) {
        this.prog = prog;
    }

    public void save(int student, int modul) {
        ProgId d = new ProgId(student, modul);
        Progression pa = progressionEjb.find(d);

        if (pa != null) {
            pa.setGodkjent(godkjent);
            progressionEjb.update(pa);
        }
        nextModule(student, modul);
    }

    public void nextModule(int student, int modul) {
        int currentOrder = modEjb.find(modul).getSortBy();
        Modul nextModul = null;
        for (Modul m : modEjb.findAll()) {
            if (m.getSortBy() == currentOrder + 1) {
                nextModul = m;
            }
        }
        Progression p = new Progression();
        Student s = studEjb.find(student);
        p.setStudent(s);
        p.setModule(nextModul);
        progressionEjb.insert(p);
    }
}
