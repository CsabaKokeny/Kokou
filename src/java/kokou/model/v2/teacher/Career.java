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
import my.helper.Date_helper;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name="TeacherCareer", propOrder = {"place", "enterDate", "retireDate", "job"})
public class Career extends Entity {
    
    private String place;
    private String enterDate;
    private String retireDate;
    private String job;
    
    
    @XmlElement(name="place")
    public String getPlace() {
        return this.place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    
    @XmlElement(name="enterDate")
    public String getEnterDate() {
        return this.enterDate;
    }
    
    public void setEnterDate(String enterDate) {
        this.enterDate = Date_helper.getDateString(enterDate);
    }
    
    @XmlElement(name="retireDate")
    public String getRetireDate() {
        return this.retireDate;
    }
    
    public void setRetireDate(String retireDate) {
        this.retireDate = Date_helper.getDateString(retireDate);
    }
    
    @XmlElement(name="job")
    public String getJob() {
        return this.job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    
}
