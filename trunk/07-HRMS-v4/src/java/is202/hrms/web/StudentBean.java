/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.StudentEJB;
import is202.hrms.entity.Student;
import java.io.Serializable;
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

    private boolean updating;
    @EJB
    private StudentEJB StudentEjb;
    @Inject
    private Conversation conv;
    //felter fra studentklassen
    private Student student;

    public StudentBean() {
    }

    public long getParam() {
        if(student == null) {
            return 0;
        }
        else return student.getStudentID();
    }
    

    public void setParam(long studentID) {
        if (conv.isTransient()) {
            conv.begin();
        }

        if (studentID > 0) {
            updating = true;
            student = StudentEjb.find(studentID);
            
        }
        else {
            updating = false;
            student = new Student(); //
        }

    }

    public String save() {
        conv.end();
        if (updating) {
            StudentEjb.update(student);
        } else {
            StudentEjb.insert(student);
        }
        return "registration";
    }

    public View delete() {
        conv.end();
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
