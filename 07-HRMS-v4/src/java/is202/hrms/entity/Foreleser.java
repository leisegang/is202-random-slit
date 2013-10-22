/**
 * Klassen Student er en subklasse av klassen Bruker. den blir brukt til å opprette Studentobjekter
 * 
 * @author Kjetil Homme 
 * @version 14.10.2013
 */

package is202.hrms.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 *
 * @author kjetil
 */
@Entity
public class Foreleser implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id @GeneratedValue  
    private int foreleserID;
    
    @NotNull @Size(min=1)
    private String firstname;
    
    @NotNull @Size(min=1)
    private String lastname;
    
    @NotNull @Size(min=1)
    private String email;
    
    @NotNull @Size(min=1)  
    private String username;
    
    @NotNull @Size(min=1)   
    private String password;
              
    
    public Foreleser () {
    
}

    public Foreleser(int foreleserID, String firstname, String lastname, String email, String username, String password) {
        this.foreleserID = foreleserID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getForeleserID() {
        return foreleserID;
    }

    public void setForeleserID(int foreleserID) {
        this.foreleserID = foreleserID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.foreleserID;
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
        final Foreleser other = (Foreleser) obj;
        if (this.foreleserID != other.foreleserID) {
            return false;
        }
        return true;
    }

    
    
}