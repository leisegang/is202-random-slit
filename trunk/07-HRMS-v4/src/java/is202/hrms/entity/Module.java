/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vetle
 */
@Entity
public class Module implements Serializable {
    
    @Id
    private String moduleName;
    
    private String description;
    private String criteria;
    private int numberOfStudents;
    private String difficulty;
    
    @Temporal(TemporalType.DATE)
    private Date timeLimit;
    
    /**
     * constructor
     */
    public Module() {
    
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String modueName) {
        this.moduleName = modueName;
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
    
}
