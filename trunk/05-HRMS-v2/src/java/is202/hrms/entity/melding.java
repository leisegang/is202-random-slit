/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author kjetil
 */


@ManagedBean(name = "melding")
@SessionScooped
public class melding {
    private String txt;
    private String tekst;

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
    
    
    
    
}
