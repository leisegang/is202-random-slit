/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.StudentEJB;
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
    private String username;
    private String password;

    public SignInBean() {
        username="";
        password = "";
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
    
    public String checkStudent() { 
        System.out.println(password + "" + username);
        for (Student s: studentEjb.findAll()){
            if (username.equals(s.getUsername() ) && password.equals(s.getPassword())) {
                return "indexS";
            }
       }
     return "loginFail.xhtml";   
        
}
}

