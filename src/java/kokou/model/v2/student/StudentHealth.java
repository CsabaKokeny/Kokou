/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2.student;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import kokou.model.v2.Allergy;
import kokou.model.v2.Entity;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
public class StudentHealth extends Entity{
    private Allergy allergy = null;
    private String importantNote;
    
    private Integer studentId;
    
    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    
    @XmlElement(name="allergy")
    public Allergy getAllergy() {
        if (this.allergy == null) {
            this.allergy = new Allergy();
        }
        return this.allergy;
    }
    
    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }
    
    @XmlElement(name="important")
    public String getImportantNote() {
        return this.importantNote;
    }
    public void setImportantNote(String importantNote) {
        this.importantNote = importantNote;
    }
}
