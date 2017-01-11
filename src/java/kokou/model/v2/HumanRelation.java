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
@XmlType(propOrder = {"relation", "relationLabel"})
public class HumanRelation extends Human {
    
    private String relation;
    private String relationLabel;
    
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
        this.relationLabel = relationLabel;
    }
}
