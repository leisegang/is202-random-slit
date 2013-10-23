/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.ModuleEJB;
import is202.hrms.ejb.ProgressionEJB;
import is202.hrms.ejb.StudentEJB;
import is202.hrms.entity.Module;
import is202.hrms.entity.ProgId;
import is202.hrms.entity.Progression;
import is202.hrms.entity.Student;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Vlorjan og Kjetil
 */
@Named("studentbean")
@ConversationScoped
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
    //felter fra studentklassen
    private Student student;
    Progression prog;

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

    public void setParam(long studentID) {
        if (conv.isTransient()) {
            conv.begin();
        }
        ProgId progId = new ProgId(studentID, 3401);
        prog = progressionEjb.find(progId);
        if (prog != null) {
            updating = true;
            student = StudentEjb.find(studentID);
            
            

        } else {
            updating = false;
            student = new Student();
            Module m = moduleEjb.find(3401);
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
        conv.end();
        return "registration";
    }

    public View delete() {
        student = new Student();
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
