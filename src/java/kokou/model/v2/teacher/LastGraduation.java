/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2.teacher;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"schoolKind", "schoolName", "schoolDepartment", "schoolSubject", "schoolResult", "teacherScholar"})
public class LastGraduation extends Entity {
    
    private String schoolKind;
    @XmlElement(name="schoolKind")
    public String getSchoolKind() {
        return this.schoolKind;
    }
    public void setSchoolKind(String schoolKind) {
        this.schoolKind = schoolKind;
    }
    
    private String schoolName;
    @XmlElement(name="schoolName")
    public String getSchoolName() {
        return this.schoolName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    
    private String schoolDepartment;
    @XmlElement(name="schoolDepartment")
    public String getSchoolDepartment() {
        return this.schoolDepartment;
    }
    public void setSchoolDepartment(String schoolDepartment) {
        this.schoolDepartment = schoolDepartment;
    }
    
    private String schoolSubject;
    @XmlElement(name="schoolSubject")
    public String getSchoolSubject() {
        return this.schoolSubject;
    }
    public void setSchoolSubject(String schoolSubject) {
        this.schoolSubject = schoolSubject;
    }
    
    private String schoolResult;
    @XmlElement(name="schoolResult")
    public String getSchoolResult() {
        return this.schoolResult;
    }
    public void setSchoolResult(String schoolResult) {
        this.schoolResult = schoolResult;
    }
    
    private String teacherScholar;
    @XmlElement(name="teacherScholar")
    public String getTeacherScholar() {
        return this.teacherScholar;
    }
    public void setTeacherScholar(String teacherScholar) {
        this.teacherScholar = teacherScholar;
    }
    
}
