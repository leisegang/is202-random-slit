/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.entity.Student;
import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Backing bean for employee.xhtml
 *
 * @author even
 */
@Named("studbean")
@ConversationScoped
public class StudentBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject private StudentListBean studListBean;
    @Inject private ModuleListBean modListBean;
    @Inject private Conversation conv;
    private Student employee;
    private boolean updating;

    public StudentBean() {
    }

    public void setStudId(long StudId) {
        if (conv.isTransient()) {
            conv.begin();
        }
        if (0 < StudId) {
            student = studListBean.find(StudId);
            updating = true;
        }
        else {
            student = new Student();
            student.setModule(modListBean.getDefaultModule());
            updating = false;
        }
    }

    public long getStudId() {
        if (null == student) {
            return 0;
        } else {
            return student.getId();
        }
    }

    public Student getStudent() {
        return employee;
    }

    public boolean isUpdating() {
        return updating;
    }

    public View saveStudent() {
        studListBean.add(student);
        conv.end();
        return View.students;
    }

}
