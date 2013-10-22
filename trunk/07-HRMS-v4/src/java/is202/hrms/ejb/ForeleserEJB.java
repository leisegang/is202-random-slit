/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.ejb;


import is202.hrms.entity.Foreleser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vlorjan
 */
@Stateless
public class ForeleserEJB extends AbstractFacade<Foreleser> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ForeleserEJB() {
        super(Foreleser.class);
    }
}
