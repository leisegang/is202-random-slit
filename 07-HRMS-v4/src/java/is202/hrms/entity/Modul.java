package is202.hrms.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class Modul
 * 
 * Denne klassen er en del av en modulbasert læringsapplikasjon som skal brukes av studenter som tar kurset IS-102, Objektorientert programmering
 * Applikasjonen skal håndtere moduler, brukere og deres progresjon.
 * 
 * Denne klassen representerer modulobjektene som vil bli lagret i databasen.
 * 
 * @author Vetle, Kjetil, Vlorjan
 * @version 02.12.2013
 */
@Entity
public class Modul implements Serializable {

    @Id
    @GeneratedValue
    private long moduleId;
    private String moduleName;
    private String description;
    private String criteria;
    private int numberOfStudents; //kan fjernes?s
    private String difficulty;
    private int sortBy;
    @Temporal(TemporalType.DATE)
    private Date timeLimit;
    @OneToMany(mappedBy = "modul")
    private List<Progression> progression;

    /**
     * Oppretter et modulobjekt med gitte parameterverdier 
     * @param moduleName
     * @param description
     * @param criteria
     * @param numberOfStudents
     * @param difficulty
     * @param timeLimit 
     */
    public Modul(String moduleName, String description, String criteria, int numberOfStudents, String difficulty, Date timeLimit) {
        this.moduleName = moduleName;
        this.description = description;
        this.criteria = criteria;
        this.numberOfStudents = numberOfStudents;
        this.difficulty = difficulty;
        this.timeLimit = timeLimit;
        progression = new ArrayList<Progression>();
    }

    public void addProgression(Progression p) {
        progression.add(p);
    }

    public long getModuleId() {
        return moduleId;
    }

    public int currentStudents() {
        int size = 0;
        for (Progression p : progression) {
            if (p.isLastProgress()) {
                size++;
            }
        }
        return size;
    }

    public List<Progression> getProgression() {
        return progression;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public Modul() {
        progression = new ArrayList<Progression>();
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String modueName) {
        this.moduleName = modueName;
    }

    public int getSortBy() {
        return sortBy;
    }

    public void setSortBy(int sortBy) {
        this.sortBy = sortBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Date getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Date timeLimit) {
        this.timeLimit = timeLimit;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (int) (this.moduleId ^ (this.moduleId >>> 32));
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
        final Modul other = (Modul) obj;
        if (this.moduleId != other.moduleId) {
            return false;
        }
        return true;
    }
}
