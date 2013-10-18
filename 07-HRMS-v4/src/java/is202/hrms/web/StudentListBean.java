

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.StudentEJB;
import is202.hrms.entity.Student;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author even
 */
@Named("studentlistbean")
@RequestScoped
public class StudentListBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB StudentEJB studentEjb;

    public StudentListBean() {
    }

    public List<Student> getStudents() {
        List<Student> l = studentEjb.findAll();
        return l;
    }

}
