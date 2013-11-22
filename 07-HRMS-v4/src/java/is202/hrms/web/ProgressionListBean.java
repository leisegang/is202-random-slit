/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.ModuleEJB;
import is202.hrms.ejb.ProgressionEJB;
import is202.hrms.ejb.StudentEJB;
import is202.hrms.entity.Progression;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Kjetil,Vetle,Vlorjan
 */
@Named("progressionlistBean")
@RequestScoped //lol
public class ProgressionListBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    ProgressionEJB progressionEjb;
    @EJB
    ModuleEJB modEjb;
    @EJB
    StudentEJB studEjb;

    public ProgressionListBean() {
    }

    public List<Progression> getProgression() {
        List<Progression> l = progressionEjb.findAll();
        List<Progression> temp = new ArrayList<Progression>();
        for (Progression p : l) {
            if (p.getProve() != null) {
                p.setModule(modEjb.find(p.getModule().getModuleId()));
                p.setStudent(studEjb.find(p.getStudent().getStudentID()));
                if (p.getGodkjent() != 1) {
                    temp.add(p);
                }
            }
        }
        return temp;
    }
}
