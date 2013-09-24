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

@Named("kommentar")
@SessionScoped
public class kommentar implements Serializable {
    
    private String radioButton;
    private String comment;
    
    
    public kommentar ()
    {
        
    }

    public String getradioButton() {
        return radioButton;
    }

    public void setradioButton(String radioButton) {
        this.radioButton = radioButton;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
