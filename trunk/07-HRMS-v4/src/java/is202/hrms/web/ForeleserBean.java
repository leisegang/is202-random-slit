/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.ForeleserEJB;
import is202.hrms.entity.Foreleser;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Vlorjan og Kjetil
 */
@Named("foreleserbean")
@ConversationScoped
public class ForeleserBean implements Serializable {

    private boolean updating;
    @EJB
    private ForeleserEJB ForeleserEjb;
    @Inject
    private Conversation conv;
    //felter fra studentklassen
    private Foreleser foreleser;

    public ForeleserBean() {
    }

    public long getParam() {
        if(foreleser == null) {
            return 0;
        }
        else return foreleser.getForeleserID();
    }
    

    public void setParam(long foreleserID) {
        if (conv.isTransient()) {
            conv.begin();
        }

        if (foreleserID > 0) {
            updating = true;
            foreleser = ForeleserEjb.find(foreleserID);
            
        }
        else {
            updating = false;
            foreleser = new Foreleser(); //
        }

    }

    public String save() {
        conv.end();
        if (updating) {
            ForeleserEjb.update(foreleser);
        } else {
            ForeleserEjb.insert(foreleser);
        }
        return "registration";
    }

    public View delete() {
        if (updating) {
            ForeleserEjb.delete(foreleser);
        }
        conv.end();        
        return View.registration;
    }

    public boolean isUpdating() {
        return updating;
    }

    public Foreleser getForeleser() {
        return foreleser;
    }

    public void setForeleser(Foreleser foreleser) {
        this.foreleser = foreleser;
    }
    
    
    
}
