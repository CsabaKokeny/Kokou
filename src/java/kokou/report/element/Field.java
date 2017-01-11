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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author master
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder={"name", "className", "fieldDescription"})
public class Field extends Object implements Serializable{
    private String name;
    private String className="java.lang.String";
    
    private String fieldDescription;
    
    @XmlAttribute(name="name")
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @XmlAttribute(name="class")
    public String getClassName() {
        return this.className;
    }
    public void setClassName(String className) {
        this.className=className;
    }
    
    @XmlElement(name="fieldDescription")
    public String getFieldDescription() {
        if (this.fieldDescription == null) {
            return this.name;
        }
        return this.fieldDescription;
    }
    public void setFieldDescription(String fieldDescription) {
        this.fieldDescription = fieldDescription;
    }
}
