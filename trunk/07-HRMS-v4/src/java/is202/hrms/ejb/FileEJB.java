/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.ejb;

import is202.hrms.entity.StoredFile;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Persistence handler for uploaded files
 * @author even
 */
@Stateless
public class FileEJB extends AbstractFacade<StoredFile>{
    @PersistenceContext
    EntityManager em;

    public FileEJB() {
        super(StoredFile.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public byte[] getFileContents(long id) {
        StoredFile f = this.find(id);

        if (null == f) return null;
        else return f.getContents();
    }
}
