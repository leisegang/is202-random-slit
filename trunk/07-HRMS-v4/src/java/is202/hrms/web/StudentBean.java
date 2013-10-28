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

    private Student student;
    
    private Progression prog;
    
    private ArrayList<Modul> modules;
    
    private Modul module; //kan jeg bruke denne? Ikke enda brukt?

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
        for(Progression p : student.getProgression()) {
           modules.add(moduleEjb.find(p.getModule().getModuleId()));
           
        }
        return modules;
    }
    
    public void setParam(long studentID) {
        if (conv.isTransient()) {
            conv.begin();
        }
        ProgId progId = null;
        long modId = 0;
        for(Modul m : moduleEjb.findAll()) {
            if("Introduksjon".equals(m.getModuleName())) {
                modId = m.getModuleId();
                progId = new ProgId(studentID, modId);
            }
        }
        prog = progressionEjb.find(progId);
        if (prog != null) {
            updating = true;
            student = StudentEjb.find(studentID);
            
            

        } else {
            updating = false;
            student = new Student();
            Modul m = moduleEjb.find(modId); //Hvis det ikke eksisterer noen modul med navn "Introduksjon", kommer det feilmelding, men objektet blir fremdeles opprettet uten verdier.
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
