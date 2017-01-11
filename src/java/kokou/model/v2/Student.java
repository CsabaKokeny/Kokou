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
import kokou.model.v2.student.StudentAttending;
import kokou.model.v2.student.StudentCareer;
import kokou.model.v2.student.StudentContact;
import kokou.model.v2.student.StudentDiploma;
import kokou.model.v2.student.StudentFamilyMember;
import kokou.model.v2.student.StudentHealth;
import kokou.model.v2.student.StudentKeeper;
import kokou.model.v2.student.StudentTransport;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Student extends Human {
    
    private String enterYear;
    private String enterMonth;
    private String enterDay;
    private String enterDate;
    private String enterSchoolKind;
    private String enterSchoolKindLabel;
    private String enterSchoolYear;
    private String code;
    private String rollNo;
    
    private String emergencyContacts;
    
    private StudentKeeper studentKeeper;
    private List<StudentCareer> studentCareerList;
    private List<StudentFamilyMember> studentFamilyList;
    private Passport studentPassport;
    private Foreigner studentForeigner;
    private List<StudentContact> studentContactList;
    private StudentAttending studentAttending;
    private StudentHealth studentHealth;
    private SchoolClass studentClass;
    private StudentDiploma studentDiploma;
    
    
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
    
    @XmlElement(name="enterSchoolKind")
    public String getEnterSchoolKind() {
        return this.enterSchoolKind;
    }
    public void setEnterSchoolKind(String enterSchoolKind) {
        this.enterSchoolKind = enterSchoolKind;
    }
    
    @XmlElement(name="enterSchoolKindLabel")
    public String getEnterSchoolKindLabel() {
        return this.enterSchoolKindLabel;
    }
    public void setEnterSchoolKindLabel(String enterSchoolKindLabel) {
        this.enterSchoolKindLabel = enterSchoolKindLabel;
    }
    
    @XmlElement(name="enterSchoolYear")
    public String getEnterSchoolYear() {
        return this.enterSchoolYear;
    }
    public void setEnterSchoolYear(String enterSchoolYear) {
        this.enterSchoolYear = enterSchoolYear;
    }
    
    @XmlElement(name="fullCode")
    public String getFullCode() {
        StringBuilder builder = new StringBuilder();
        try {
            if (this.getEnterYear() != null) {
                builder.append(this.getEnterYear());
            }
            if (this.getEnterSchoolKind() != null) {
                builder.append(this.getEnterSchoolKind());
            }
            if (this.getCode() != null) {
                builder.append(this.getCode());
            }
            return builder.toString();
        } catch (Exception ex) {}
        return "";
    }
    
    @XmlElement(name="code")
    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    
    @XmlElement(name="rollNo")
    public String getRollNo() {
        return this.rollNo;
    }
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
    
    @XmlElement(name="schoolYear")
    public String getSchoolYear() {
        return this.getSchoolClass().getSchoolYear();
    }
    
    public void setSchoolYear(String schoolYear) {
        
    }
    
    @XmlElement(name="keeperJob")
    public String getKeeperJob() {
        return this.getKeeper().getJob();
    }
    
    @XmlElement(name="keeper")
    public StudentKeeper getKeeper() {
        if (this.studentKeeper == null) {
            this.studentKeeper = new StudentKeeper();
        }
        return this.studentKeeper;
    }
    public void setKeeper(StudentKeeper studentKeeper) {
        this.studentKeeper = studentKeeper;
    }
    
    @XmlElement(name="career")
    public List<StudentCareer> getCareerList() {
        if (this.studentCareerList == null) {
            this.studentCareerList = new ArrayList();
        }
        return this.studentCareerList;
    }
    public void setCareerList(List<StudentCareer> studentCareerList) {
        this.studentCareerList = studentCareerList;
    }
    
    @XmlElement(name="family")
    public List<StudentFamilyMember> getFamilyList() {
        if (this.studentFamilyList == null) {
            this.studentFamilyList = new ArrayList();
        }
        return this.studentFamilyList;
    }
    public void setFamilyList(List<StudentFamilyMember> studentFamilyList) {
        this.studentFamilyList = studentFamilyList;
    }
    
    @XmlElement(name="mother")
    public StudentFamilyMember getMother() {
        for (StudentFamilyMember item : getFamilyList()) {
            if ("m".equals(item.getRelation()) || "母".equals(item.getRelation())) {
                return item;
            }
        }
        return null;
    }
    
    @XmlElement(name="father")
    public StudentFamilyMember getFather() {
        for (StudentFamilyMember item : getFamilyList()) {
            if ("f".equals(item.getRelation()) || "父".equals(item.getRelation())) {
                return item;
            }
        }
        return null;
    }
    
    @XmlElement(name="passport")
    public Passport getPassport() {
        if (this.studentPassport == null) {
            this.studentPassport = new Passport();
        }
        return this.studentPassport;
    }
    public void setPassport(Passport studentPassport) {
        this.studentPassport = studentPassport;
    }
    
    @XmlElement(name="foreigner")
    public Foreigner getForeigner() {
        if (this.studentForeigner == null) {
            this.studentForeigner = new Foreigner();
        }
        return this.studentForeigner;
    }
    public void setForeigner(Foreigner studentForeigner) {
        this.studentForeigner = studentForeigner;
    }
    
    @XmlElement(name="contact")
    public List<StudentContact> getContactList() {
        if (this.studentContactList == null) {
            this.studentContactList = new ArrayList();
        }
        return this.studentContactList;
    }
    public void setContactList(List<StudentContact> studentContactList) {
        this.studentContactList = studentContactList;
    }
    
    @XmlElement(name="emergencyContact")
    public String getEmergencyContacts() {
        StringBuilder buffer = new StringBuilder();
        for (StudentContact item : this.getContactList()) {
            if (item.getPhone()!=null) {
                buffer.append(item.getPhone());
                if (item.getRelationLabel()!=null && item.getRelationLabel().isEmpty()) {
                    buffer.append("(").append(item.getRelationLabel()).append(")");
                }
                buffer.append(", ");
            }
        }
        if (buffer.length()<=0) {
            return this.emergencyContacts;
        }
        return buffer.toString();
    }
    
    public void setEmergencyContacts(String emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }
    
    @XmlElement(name="attending")
    public StudentAttending getAttending() {
        if (this.studentAttending == null) {
            this.studentAttending = new StudentAttending();
        }
        return this.studentAttending;
    }
    public void setAttending(StudentAttending studentAttending) {
        this.studentAttending = studentAttending;
    }
    
    @XmlElement(name="bus")
    public StudentTransport getBus() {
        if (this.getAttending().getTransportList().size()>0) {
            return getAttending().getTransportList().get(0);
        }
        return null;
    }
    
    @XmlElement(name="health")
    public StudentHealth getHealth() {
        if (this.studentHealth == null) {
            this.studentHealth = new StudentHealth();
        }
        return this.studentHealth;
    }
    public void setHealth(StudentHealth studentHealth) {
        this.studentHealth = studentHealth;
    }
    
    
    @XmlElement(name="class")
    public SchoolClass getSchoolClass() {
        if (this.studentClass == null) {
            this.studentClass = new SchoolClass();
        }
        return this.studentClass;
    }
    public void setSchoolClass(SchoolClass studentClass) {
        this.studentClass = studentClass;
    }
    /*
    public SchoolClass getSchoolClass() {
        if (this.studentClass == null) {
            this.studentClass = new SchoolClass();
        }
        return this.studentClass;
    }
    public void setSchoolClass(SchoolClass studentClass) {
        this.studentClass = studentClass;
    }
    */
    @XmlElement(name="diploma")
    public StudentDiploma getDiploma() {
        if (this.studentDiploma==null) {
            this.studentDiploma = new StudentDiploma();
        }
        return this.studentDiploma;
    }
    public void setDiploma(StudentDiploma value) {
        this.studentDiploma = value;
    }
    
    private String className;
    @XmlElement(name="className")
    public void setClassName(String className) {
        this.className = className;
    }
    public String getClassName() {
        if (this.className == null) {
            String schoolKind = this.getEnterSchoolKind();
            String schoolYear = this.getSchoolYear();
            String name = this.getSchoolClass().getName();
            return (schoolKind==null?"":schoolKind)+(schoolYear==null?"":schoolYear)
                    +(name==null?"":name);
        } else {
            return this.className;
        }
    }
    
    private Integer reportGroupNo;
    @XmlElement(name="reportGroupNo")
    public void setReportGroupNo(Integer reportGrouopNo) {
        this.reportGroupNo = reportGrouopNo;
    }
    public Integer getReportGroupNo() {
        return this.reportGroupNo;
    }
    
}
