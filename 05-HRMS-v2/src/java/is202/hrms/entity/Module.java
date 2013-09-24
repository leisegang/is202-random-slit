/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.entity;

/**
 *
 * @author Vetle
 */
public class Module {
    private String name;
    private String description;
    private String criteria;
    private String resources;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Module() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }
    
    
    
}
