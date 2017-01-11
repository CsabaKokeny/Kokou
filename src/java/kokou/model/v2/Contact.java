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
@XmlType(propOrder = {"relation", "relationLabel", "name", "phone"})
public class Contact extends Entity{
    
    private String name;
    private String phone;
    private String relation;
    private String relationLabel;
    
    @XmlElement(name="name")
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @XmlElement(name="phone")
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @XmlElement(name="relation")
    public String getRelation() {
        return this.relation;
    }
    public void setRelation(String relation) {
        this.relation = relation;
    }
    
    @XmlElement(name="relationLabel")
    public String getRelationLabel() {
        return this.relationLabel;
    }
    public void setRelationLabel(String relationLabel) {
        if (relationLabel!=null) {
            this.relationLabel = relationLabel.trim();
        } else {
            this.relationLabel = null;
        }  
    }
}
