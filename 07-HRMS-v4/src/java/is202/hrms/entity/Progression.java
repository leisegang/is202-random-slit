/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

/**
 *
 * @author Vetle
 */
@Entity
@IdClass(ProgId.class)

public class Progression implements Serializable {
   
    
    @Id @ManyToOne private Student student;
    @Id @ManyToOne private Modul modul;
    

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Modul getModule() {
        return modul;
    }

    public void setModule(Modul module) {
        this.modul = module;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.student != null ? this.student.hashCode() : 0);
        hash = 31 * hash + (this.modul != null ? this.modul.hashCode() : 0);
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
        final Progression other = (Progression) obj;
        if (this.student != other.student && (this.student == null || !this.student.equals(other.student))) {
            return false;
        }
        if (this.modul != other.modul && (this.modul == null || !this.modul.equals(other.modul))) {
            return false;
        }
        return true;
    }
    
    
    
    
}
