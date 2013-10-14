/**
 * Klassen Student er en subklasse av klassen Bruker. den blir brukt til å opprette Studentobjekter
 * 
 * @author Kjetil Homme 
 * @version 14.10.2013
 */

package is202.hrms.entity;

/**
 *
 * @author kjetil
 */
public class Student extends Bruker {
    
    private String studentID;
   
    
public Student () {
    
}

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }



}
    

