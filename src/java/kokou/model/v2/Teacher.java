/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import kokou.model.v2.teacher.AttendingInformation;
import kokou.model.v2.teacher.FamilyInformation;
import kokou.model.v2.teacher.LastGraduation;
import kokou.model.v2.teacher.PositionInformation;
import kokou.model.v2.teacher.RewardPunishment;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"enterDate", "enterYear", "enterMonth", "enterDay", "enterKind", "positionInformation",
    "lastGraduation", "careers", "familyInformation", "passport", "contacts", "attendingInformation",
    "rewardPunishments"
})
public class Teacher extends Human {
    
    private String enterYear;
    private String enterMonth;
    private String enterDay;
    private String enterDate;
    private String enterKind;
    
    
    @XmlElement(name="enterYear")
    public String getEnterYear() {
        return this.enterYear;
    }
    public void setEnterYear(String enterYear) {
        this.enterYear = enterYear;
    }
    
    @XmlElement(name="enterMonth")
    public String getEnterMonth() {
        return this.enterMonth;
    }
    public void setEnterMonth(String enterMonth) {
        this.enterMonth = enterMonth;
    }
    
    @XmlElement(name="enterDay")
    public String getEnterDay() {
        return this.enterDay;
    }
    public void setEnterDay(String enterDay) {
        this.enterDay = enterDay;
    }
    
    @XmlElement(name="enterDate")
    public String getEnterDate() {
        return this.enterDate;
    }
    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }
    
    @XmlElement(name="enterKind")
    public String getEnterKind() {
        return this.enterKind;
    }
    public void setEnterKind(String enterKind) {
        this.enterKind = enterKind;
    }
    
    private PositionInformation positionInformation;
    @XmlElement(name="positionInformation")
    public PositionInformation getPositionInformation() {
        if (this.positionInformation == null) {
            this.positionInformation = new PositionInformation();
        }
        return this.positionInformation;
    }
    public void setPositionInformation(PositionInformation positionInformation) {
        this.positionInformation = positionInformation;        
    }
    
    private LastGraduation lastGraduation;
    @XmlElement(name="lastGraduation")
    public LastGraduation getLastGraduation() {
        if (this.lastGraduation == null) {
            this.lastGraduation = new LastGraduation();
        }
        return this.lastGraduation;
    }
    public void setLastGraduation(LastGraduation lastGraduation) {
        this.lastGraduation = lastGraduation;        
    }
    
    private List<kokou.model.v2.teacher.Career> careers;
    @XmlElement(name="career")
    public List<kokou.model.v2.teacher.Career> getCareers() {
        if (this.careers == null) {
            this.careers = new ArrayList();
        }
        return this.careers;
    }
    public void setCareers(List<kokou.model.v2.teacher.Career> careers) {
        this.careers = careers;
    }
    
    private kokou.model.v2.teacher.Passport passport;
    @XmlElement(name="passport")
    public kokou.model.v2.teacher.Passport getPassport() {
        if (this.passport == null) {
            this.passport = new kokou.model.v2.teacher.Passport();
        }
        return this.passport;
    }
    public void setPassport(kokou.model.v2.teacher.Passport passport) {
        this.passport = passport;
    }
    
    private List<kokou.model.v2.teacher.Contact> contacts;
    @XmlElement(name="contact")
    public List<kokou.model.v2.teacher.Contact> getContacts() {
        if (this.contacts == null) {
            this.contacts = new ArrayList();
        }
        return this.contacts;
    }
    public void setContacts(List<kokou.model.v2.teacher.Contact> contacts) {
        this.contacts = contacts;
    }
    
    private AttendingInformation attendingInformation;
    @XmlElement(name="attending")
    public AttendingInformation getAttendingInformation() {
        if (this.attendingInformation == null) {
            this.attendingInformation = new AttendingInformation();
        }
        return this.attendingInformation;
    }
    public void setAttendingInformation(AttendingInformation attendingInformation) {
        this.attendingInformation = attendingInformation;
    }
    
    private List<RewardPunishment> rewardPunishments;
    @XmlElement(name="rewardPunishment")
    public List<RewardPunishment> getRewardPunishments() {
        if (this.rewardPunishments == null) {
            this.rewardPunishments = new ArrayList();
        }
        return this.rewardPunishments;
    }
    public void setRewardPunishments(List<RewardPunishment> rewardPunishments) {
        this.rewardPunishments = rewardPunishments;
    }
    
    private FamilyInformation familyInformation;
    @XmlElement(name="familyInformation")
    public FamilyInformation getFamilyInformation() {
        if (this.familyInformation == null) {
            this.familyInformation = new FamilyInformation();
        }
        return this.familyInformation;
    }
    public void setFamilyInformation(FamilyInformation familyInformation) {
        this.familyInformation = familyInformation;
    }
}
