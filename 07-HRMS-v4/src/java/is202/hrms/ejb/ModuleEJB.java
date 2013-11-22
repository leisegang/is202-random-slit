/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.ejb;

import is202.hrms.entity.Modul;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Vetle
 */
@Stateless
public class ModuleEJB extends AbstractFacade<Modul> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    //BRUKER IKKE 
    public List<Modul> getModules() {

        TypedQuery<Modul> m = em.createQuery("SELECT m FROM Modul m ORDER BY m.sortBy ASC",
                Modul.class);

        return m.getResultList();

    }

    public ModuleEJB() {
        super(Modul.class);
    }

    public Modul find(long depNo) {
        Modul dep = super.find(depNo);
        if (null != dep) {
            dep.getProgression();
        }
        return dep;
    }

    public List<Modul> findAll() {
    ArrayList<Modul> temp = new ArrayList<Modul>();
        List<Modul> l = super.findAll();
        if (null != l) {
            for (Modul m : l) {
                m.getProgression();
                temp.add(m.getSortBy()-1, m);
            }

        }
        return temp;
    }
}