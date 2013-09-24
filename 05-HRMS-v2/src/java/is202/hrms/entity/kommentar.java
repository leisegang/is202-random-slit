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
    
    private String radioButton1;
    private String radioButton2;
    private String radioButton3;
    private String comment;
    
    
    public kommentar ()
    {
        
    }

    public String getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(String radioButton1) {
        this.radioButton1 = radioButton1;
    }

    public String getRadioButton2() {
        return radioButton2;
    }

    public void setRadioButton2(String radioButton2) {
        this.radioButton2 = radioButton2;
    }

    public String getRadioButton3() {
        return radioButton3;
    }

    public void setRadioButton3(String radioButton3) {
        this.radioButton3 = radioButton3;
    }
    
    
    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
