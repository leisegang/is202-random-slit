/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

//import is202.hrms.ejb.EmployeeEJB;
import is202.hrms.entity.Student;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Backing bean for employee.xhtml
 *
 * @author even
 */
@Named("studlistbean")
@ApplicationScoped
public class StudentListBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long nextEmpId = 1;
    private Map<Long,Student> studs;

    public StudentListBean() {
        studs = new HashMap<Long,Student>();
    }

    public List<Student> getStudents() {
        return  new ArrayList<Student>(studs.values());
    }


    public Student find(long studid) {
        return studs.get(studid);
    }
    
    
    public void add(Student stud) {
        if (0 == stud.getId()) {
            stud.setId(nextEmpId);
            nextStudId++;
            studs.put(stud.getId(), stud);
        }
        else {
            // ???
        }
    }
}
