/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
public class SchoolClass extends Entity {
    
    private String name;
    private String schoolYear;
    private Teacher teacher;
    
    @XmlElement(name="name")
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @XmlElement(name="schoolYear")
    public String getSchoolYear() {
        if (this.schoolYear == null || this.schoolYear.isEmpty()) {
            return this.getName();
        }
        return this.schoolYear;
    }
    public void setSchoolYear(String schoolYear) {
        if (schoolYear != null) {
            this.schoolYear = schoolYear.trim();
        } else {
            this.schoolYear= schoolYear;
        }
    }
    
    @XmlElement(name="teacher")
    public Teacher getTeacher() {
        if (this.teacher == null) {
            this.teacher = new Teacher();
        }
        return this.teacher;
    }
    public void setTeahcer(Teacher teacher) {
        this.teacher =teacher;
    }
    
}
