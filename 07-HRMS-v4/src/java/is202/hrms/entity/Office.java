/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author even
 */
@Entity
public class Office implements Serializable {

    @Id
    private String roomNo;
    private int sizeSqMeter;

    public Office() {
    }

    public Office(String roomNo, int sizeSqMeter) {
        this.roomNo = roomNo;
        this.sizeSqMeter = sizeSqMeter;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getSizeSqMeter() {
        return sizeSqMeter;
    }

    public void setSizeSqMeter(int sizeSqMeter) {
        this.sizeSqMeter = sizeSqMeter;
    }
}
