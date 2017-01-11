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
@XmlType(propOrder = { "has", "name"})
public class Allergy extends Entity{
    private Boolean has;
    private String name;
    
    @XmlElement(name="has")
    public Boolean getHas() {
        if (this.has == null) {
            this.has = Boolean.FALSE;
        }
        return this.has;
    }
    public void setHas(Boolean has) {
        this.has = has;
    }
    
    @XmlElement(name="name")
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
