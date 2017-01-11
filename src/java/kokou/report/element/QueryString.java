/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokou.report.element;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"language","value"})
public class QueryString extends Object implements Serializable {
    private String language;
    private String value;
    
    @XmlAttribute(name="language")
    public String getLanguage() {
        return this.language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    
    @XmlValue()
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    } 
}
