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
@XmlType(propOrder = {"has", "no"})
public class Passport extends Entity {
    
    private Boolean has;
    private String no;
    
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
    
    @XmlElement(name="no")
    public String getNo() {
        return this.no;
    }
    public void setNo(String no) {
        this.no = no;
    }
}
