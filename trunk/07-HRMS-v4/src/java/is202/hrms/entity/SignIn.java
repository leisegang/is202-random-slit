/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.entity;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author kjetil og Vlorjan
 */

@Entity
public class SignIn implements Serializable {
    
    private String username1;
    private String password;
    
    
    
    
    public SignIn () {
    
    }

    public String getUsername1() {
        return username1;
    }

    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String logInn () {
        if(username1.equals(Student.class) && password.equals(Student.class)) {
            System.out.println("login sucess");
          
                    
        }
        return "index";
            
    }
    
}
