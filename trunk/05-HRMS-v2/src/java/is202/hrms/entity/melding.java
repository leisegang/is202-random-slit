/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.entity;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author kjetil
 */

@Named("melding")
@SessionScoped
public class melding implements Serializable {
    
    private String radioButton;
    private String tekst;
    
    
    public melding ()
    {
        
    }

    public String getradioButton() {
        return radioButton;
    }

    public void setradioButton(String radioButton) {
        this.radioButton = radioButton;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

}
