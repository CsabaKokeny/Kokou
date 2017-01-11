/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2.student;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import kokou.model.v2.Entity;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
public class StudentAttending extends Entity{
    
    private String duration;
    private List<StudentTransport> studentTransportList;
    
    private Integer studentId;
    
    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    
    @XmlElement(name="duration")
    public String getDuration() {
        return this.duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    @XmlElement(name="transport")
    public List<StudentTransport> getTransportList() {
        if (this.studentTransportList == null) {
            this.studentTransportList = new ArrayList();
        }
        return this.studentTransportList;
    }
    public void setTransportList(List<StudentTransport> studentTransportList) {
        this.studentTransportList = studentTransportList;
    }
}
