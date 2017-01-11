/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.model.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"name", "nameKr", "nameNick", "job", "sex", "sexLabel", "birth", "birthday", "address", "alterAddress",
    "postalCode", "phone", "phoneNo", "phoneType", "phoneTypeLabel", "mobile","fax", "mail", "residence",
    "nation", "nationLabel", "note"
})
public class Human extends Entity {
    
    private String name;
    private String nameKr;
    private String nameNick;
    private String job;
    private String sex;
    private Date birthday;
    private String address;
    private String alterAddress;
    private String phone;
    private String phoneType;
    private String mobile;
    private String fax;
    private String mail;
    private String nation;
    private String note;
    
    
    private String sexLabel;
    private String nationLabel;
    private String phoneTypeLabel;
    
    @XmlElement(name="name")
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @XmlElement(name="nameKr")
    public String getNameKr() {
        return this.nameKr;
    }
    public void setNameKr(String nameKr) {
        this.nameKr = nameKr;
    }
    
    @XmlElement(name="nameNick")
    public String getNameNick() {
        return this.nameNick;
    }
    public void setNameNick(String nameNick) {
        this.nameNick = nameNick;
    }
    
    @XmlElement(name="job")
    public String getJob() {
        return this.job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    
    @XmlElement(name="sex")
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    @XmlElement(name="sexLabel")
    public String getSexLabel() {
        return this.sexLabel;
    }
    public void setSexLabel(String sexLabel){
        this.sexLabel = sexLabel;
    }
    
    @XmlElement(name="birthday")
    public Date getBirth() {
        if (this.birthday == null) {
            this.birthday = new Date();
        }
        return this.birthday;
    }
    
    @XmlElement(name="birth")
    public String getBirthday() {
        return this.getBirth().toString();
    }
    
    public void setBirthday(String birthday) {
        this.getBirth().setValue(birthday);
    }
    
    @XmlElement(name="address")
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    
    @XmlElement(name="address2")
    public String getAlterAddress() {
        return this.alterAddress;
    }
    public void setAlterAddress(String alterAddress) {
        this.alterAddress = alterAddress;
    }
    
    @XmlElement(name="phone")
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @XmlElement(name="phoneNo")
    public String getPhoneNo() {
        return this.getPhone();
    }
    
    @XmlElement(name="phoneType")
    public String getPhoneType() {
        return this.phoneType;
    }
    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }
    
    @XmlElement(name="phoneTypeLabel")
    public String getPhoneTypeLabel() {
        return this.phoneTypeLabel;
    }
    public void setPhoneTypeLabel(String phoneTypeLabel) {
        this.phoneTypeLabel = phoneTypeLabel;
    }
    
    @XmlElement(name="mobile")
    public String getMobile() {
        return this.mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    @XmlElement(name="fax")
    public String getFax() {
        return this.fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    
    @XmlElement(name="postalCode")
    public String getPostalCode() {
        return this.getFax();
    }
    public void setPostalCode(String value) {
        this.setFax(value);
    }
    
    @XmlElement(name="mail")
    public String getMail() {
        return this.mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    @XmlElement(name="nation")
    public String getNation() {
        return this.nation;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }
    
    @XmlElement(name="nationLabel")
    public String getNationLabel() {
        return this.nationLabel;
    }
    public void setNationLabel(String nationLabel) {
        this.nationLabel = nationLabel;
    }
    
    @XmlElement(name="residence")
    public String getResidence() {
        return this.getNationLabel();
    }
    
    @XmlElement(name="note")
    public String getNote() {
        return this.note;
    }
    public void setNote(String note) {
        this.note = note;
    }
}
