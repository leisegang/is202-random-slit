/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.entity;

import java.io.Serializable;

/**
 *
 * @author Vetle
 */
public class ProgId implements Serializable {
    private long student;
    private long modul;
    
    public ProgId() {
    
    }
    
    public ProgId(long student, long modul) {
        this.student = student;
        this.modul = modul;
    }    

    public long getStudent() {
        return student;
    }

    public long getModule() {
        return modul;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.student ^ (this.student >>> 32));
        hash = 89 * hash + (int) (this.modul ^ (this.modul >>> 32));
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
        final ProgId other = (ProgId) obj;
        if (this.student != other.student) {
            return false;
        }
        if (this.modul != other.modul) {
            return false;
        }
        return true;
    }
    
}
