package is202.hrms.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    private long id;
    
    // Name is not null, and minimum one char
    @NotNull @Size(min=1)
    private String name;
    
  
    
    @ManyToMany
    private Module module;

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        module.addStudent(this);
        this.module = module;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        if (id != other.id) return false;
        return true;
    }
}
