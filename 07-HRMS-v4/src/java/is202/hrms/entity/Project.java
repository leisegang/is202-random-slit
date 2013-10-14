package is202.hrms.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long projectNo;
    
    @NotNull @Size(min=1)
    private String name;
    
    @ManyToMany
    Set<Employee> members;

    public Project() {
        members = new HashSet<Employee>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public List<Employee> getMembers() {
        return new ArrayList(members);
    }

    public void addMember(Employee emp) {
        if (null == emp) {
            return;
        }
        if (members.contains(emp)) {
            return;
        }
        members.add(emp);
    }

    public void removeMember(Employee emp) {
        members.remove(emp);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        long result = 1;
        result = prime * result + projectNo;
        return (int)result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Project other = (Project) obj;
        if (projectNo != other.projectNo) {
            return false;
        }
        return true;
    }
}
