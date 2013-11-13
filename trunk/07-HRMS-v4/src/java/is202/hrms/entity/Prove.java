/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Vetle
 */
@Entity
public class Prove implements Serializable {
    @GeneratedValue @Id private int proveId;
    private String reflectionNote;
    private boolean understood;

    public Prove() {
    }

    public String getReflectionNote() {
        return reflectionNote;
    }

    public void setReflectionNote(String reflectionNote) {
        this.reflectionNote = reflectionNote;
    }

    public boolean isUnderstood() {
        return understood;
    }

    public void setUnderstood(boolean understood) {
        this.understood = understood;
    }

    public int getProveId() {
        return proveId;
    }

    public void setProveId(int proveId) {
        this.proveId = proveId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.proveId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prove other = (Prove) obj;
        if (this.proveId != other.proveId) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
