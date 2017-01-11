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
import my.helper.Date_helper;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
public class StudentCareer extends Entity {
    
    private String schoolName;
    private String schoolState;
    private String schoolStateLabel;
    private String enterDate;
    private String admitDate;
    private String explusionDate;
    private String graduationDate;
    private String preSchoolName;
    
    private Integer studentId;
    
    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    
    @XmlElement(name="schoolName")
    public String getSchoolName() {
        return this.schoolName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    
    @XmlElement(name="schoolState")
    public String getSchoolState() {
        return this.schoolState;
    }
    public void setSchoolState(String schoolState) {
        this.schoolState = schoolState;
    }
    
    @XmlElement(name="schoolStateLabel")
    public String getSchoolStateLabel() {
        return this.schoolStateLabel;
    }
    
    public void setSchoolStateLabel(String schoolStateLabel) {
        this.schoolStateLabel = schoolStateLabel;
    }
    
    @XmlElement(name="preSchoolName")
    public String getPreSchoolName() {
        return this.preSchoolName;
    }
    
    public void setPreSchoolName(String preSchoolName) {
        this.preSchoolName = preSchoolName;
    }
    
    @XmlElement(name="enterDate")
    public String getEnterDate() {
        return this.enterDate;
    }
    
    public void setEnterDate(String enterDate) {
        this.enterDate = Date_helper.getDateString(enterDate);
    }
    
    @XmlElement(name="admitDate")
    public String getAdmitDate() {
        return this.admitDate;
    }
    
    public void setAdmitDate(String admitDate) {
        this.admitDate = Date_helper.getDateString(admitDate);
    }
    
    @XmlElement(name="explusionDate")
    public String getExplusionDate() {
        return this.explusionDate;
    }
    
    public void setExplusionDate(String explusionDate) {
        this.explusionDate = Date_helper.getDateString(explusionDate);
    }
    
    @XmlElement(name="graduationDate")
    public String getGraduationDate() {
        return this.graduationDate;
    }
    
    public void setGraduationDate(String graduationDate) {
        this.graduationDate = Date_helper.getDateString(graduationDate);
    }
    
}
