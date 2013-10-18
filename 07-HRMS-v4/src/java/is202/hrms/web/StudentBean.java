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
 * @author Vlorjan
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
    private int studentID;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String moduleNr;

    public StudentBean() {
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getModuleNr() {
        return moduleNr;
    }

    public void setModuleNr(String moduleNr) {
        this.moduleNr = moduleNr;
    }

    public String getParam() {
        return null;
    }

    public void setParam(String studentID) {
        if (conv.isTransient()) {
            conv.begin();
        }

        Student s = StudentEjb.find(studentID);
        if (null != s) {
            updating = true;
            this.studentID = s.getStudentID();
            this.firstname = s.getFirstname();
            
            this.lastname = s.getLastname();
            this.email = s.getEmail();
            this.password = s.getPassword();
            this.moduleNr = s.getModuleNr();
        } else {
            updating = false;
        }

    }

    public View save() {
        conv.end();
        Student s = new Student(studentID, firstname, lastname, email, username, password);
        if (updating) {
            StudentEjb.update(s);
        } else {
            StudentEjb.insert(s);
        }
        return View.registration;
    }

    public View delete() {
        conv.end();
        Student s = new Student(studentID, firstname, lastname, email, username, password);
        if (updating) {
            StudentEjb.delete(s);
        }
        return View.registration;
    }

    public boolean isUpdating() {
        return updating;
    }
}
