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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Vlorjan og Kjetil
 */
@Named("studentbean")
@SessionScoped
public class StudentBean implements Serializable {

    @Inject
    Conversation conv;
    private boolean updating;
    @EJB
    private StudentEJB StudentEjb;
    @EJB
    private ModuleEJB moduleEjb;
    @EJB
    private ProgressionEJB progressionEjb;
    private Student student;
    private Progression prog;
    private ArrayList<Modul> modules;
    private boolean moduleExistence;

    public StudentBean() {
    }

    public long getParam() {
        if (student == null) {
            return 0;
        } else {
            return student.getStudentID();
        }
    }

    public List<Progression> getProgression() {

        return student.getProgression();
    }

    public ArrayList<Modul> getModules() {
        modules = new ArrayList<Modul>();
        for (Progression p : student.getProgression()) {
            modules.add(moduleEjb.find(p.getModule().getModuleId()));

        }
        return modules;
    }

    public void setParam(long studentID) {
        ProgId progId = null;
        long modId = 0;
        for (Modul m : moduleEjb.findAll()) {
            if ("Introduksjon".equals(m.getModuleName())) {
                modId = m.getModuleId();
                progId = new ProgId(studentID, modId);
                moduleExistence = true;
            } 
        }
        prog = progressionEjb.find(progId);
        if (prog != null) {
            updating = true;
            student = StudentEjb.find(studentID);

        } else {
            updating = false;
            student = new Student();
            Modul m;
            if(moduleExistence) {
                m = moduleEjb.find(modId);
            } else {
            m = new Modul();
            m.setModuleName("Introduksjon");

            moduleEjb.insert(m);            
            }


            prog = new Progression();
            prog.setStudent(student);
            prog.setModule(m);
        }
    }

    public String save() {
        if (updating) {
            StudentEjb.update(student);
        } else {
            StudentEjb.insert(student);
            progressionEjb.insert(prog);
        }
        return "registration";
    }

    public View delete() {

        if (updating) {
            StudentEjb.delete(student);
        }
        return View.registration;
    }

    public boolean isUpdating() {
        return updating;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
