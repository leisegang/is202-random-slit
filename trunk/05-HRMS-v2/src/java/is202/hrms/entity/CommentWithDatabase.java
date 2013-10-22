/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kjetil
 */

@Entity
public class Comment implements Serializable {
    
   private static final long serialVersionUID = 1L;
    
    
  @Id @GeneratedValue
   private long id;
  
  @NotNull @Size(min=1)
    private String comment;
  
  @ManyToOne
    private Student Student;
  
    public Comment() {
    
    
    }
    
    
     public long getId() {
        return id;
    }

     public String getComment() {
        return comment;
    }
     
      public void setComment(String comment) {
        this.comment = comment;
    }
      
       public Student getStudent() {
        return student;
    }
       
    public String toString() {
        return "["+id+" "+name+"]";
    }
      }