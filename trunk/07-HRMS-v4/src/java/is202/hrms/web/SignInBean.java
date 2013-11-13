/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.ForeleserEJB;
import is202.hrms.ejb.StudentEJB;
import is202.hrms.entity.Foreleser;
import is202.hrms.entity.Student;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Vlorjan
 */
@Named ("signinbean")
@SessionScoped
public class SignInBean implements Serializable{
    @EJB private StudentEJB studentEjb;
    @EJB private ForeleserEJB foreleserEjb;
    private String username;
    private String password;
    private Student student;
    private boolean foreleser;

    public SignInBean() {
        username="";
        password = "";
        foreleser = false;
    }

    public String getUsername() {
        return username;
    }

    public boolean isForeleser() {
        return foreleser;
    }

    public void setForeleser(boolean foreleser) {
        this.foreleser = foreleser;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
    
    public String checkStudent() { 

        for (Student s: studentEjb.findAll()){
            if (username.equals(s.getUsername() ) && password.equals(s.getPassword())) {
                foreleser = false;
                student = s;
                return "indexS";
            }
       }
        for (Foreleser f: foreleserEjb.findAll()){
            if (username.equals(f.getUsername() ) && password.equals(f.getPassword())) {
                foreleser = true;
                
                return "hrms";
            }
       }        
        
     return "loginFail.xhtml";   
        
}
}

