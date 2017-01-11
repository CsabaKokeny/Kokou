/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2.student;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import kokou.model.v2.Entity;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
public class StudentDiploma extends Entity {
    private Integer studentId;
    private String no;
    
    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    
    @XmlElement(name="no")
    public String getNo() {
        return this.no;
    }
    public void setSetNo(String no) {
        if (no!=null) {
            this.no = no.trim();
        } else {
            this.no = no;
        }
    }
}
