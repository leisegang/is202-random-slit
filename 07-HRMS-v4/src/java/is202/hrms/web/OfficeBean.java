/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.OfficeEJB;
import is202.hrms.entity.Office;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author even
 */
@Named("officebean")
@ConversationScoped
public class OfficeBean implements Serializable {
    private boolean updating;
    @EJB private OfficeEJB officeEjb;
    @Inject private Conversation conv;

    // office fields
    private String roomNo;
    private int sizeSqM;

    public String getRoomNo() {
        return roomNo;
    }

    public String getParam() {
        return null;
    }

    public void setParam(String roomNo) {
        if (conv.isTransient()) {
            conv.begin();
        }

        Office o = officeEjb.find(roomNo);
        if (null != o) {
            updating = true;
            this.roomNo = o.getRoomNo();
            this.sizeSqM = o.getSizeSqMeter();
        }
        else {
            updating = false;
        }

    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getSizeSqM() {
        return sizeSqM;
    }

    public void setSizeSqM(int sizeSqM) {
        this.sizeSqM = sizeSqM;
    }

    public View save() {
        conv.end();
        Office o = new Office(roomNo, sizeSqM);
        if (updating) officeEjb.update(o);
        else officeEjb.insert(o);
        return View.offices;
    }

    public View delete() {
        conv.end();
        Office o = new Office(roomNo, sizeSqM);
        if (updating) officeEjb.delete(o);
        return View.offices;
    }

    public boolean isUpdating() {
        return updating;
    }
}
